package br.edu.vianna.sistemaclube.model.rankings;

import br.edu.vianna.sistemaclube.dao.impl.usuariodao.MembroDAO;
import br.edu.vianna.sistemaclube.model.avaliacoes.Avaliacao;
import br.edu.vianna.sistemaclube.model.atividades.Atividade;
import br.edu.vianna.sistemaclube.model.usuarios.Membro;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class GeraRanking {
    public List<Ranking> gerarRanking(List<Avaliacao> avaliacoes) throws SQLException, ClassNotFoundException {
        List<Ranking> listaDeRankings = new ArrayList<>();
        Map<Integer, List<Avaliacao>> avaliacoesAgrupadasPorMembro = agruparAvaliacoesDeCadaMembro(avaliacoes);

        for (Map.Entry<Integer, List<Avaliacao>> entry : avaliacoesAgrupadasPorMembro.entrySet()) {
            Integer membroId = entry.getKey();
            List<Avaliacao> avaliacoesDoMembro = entry.getValue();

            double media = retornaMediaDasAtividadesDoMembro(avaliacoesDoMembro);

            Avaliacao ultimaAvaliacao = retornaAvaliacaoMaisRecente(avaliacoesDoMembro);

            assert ultimaAvaliacao != null;
            Atividade atividade = ultimaAvaliacao.getAtividade();
            Membro membro = new MembroDAO().buscarPorId(membroId);

            listaDeRankings.add(new Ranking(listaDeRankings.size() + 1, membro, atividade, media));
        }

        ordenarLista(listaDeRankings);

        return listaDeRankings;
    }

    private static double retornaMediaDasAtividadesDoMembro(List<Avaliacao> avaliacoesDoMembro) {
        double media = avaliacoesDoMembro.stream()
                .mapToInt(Avaliacao::getNota)
                .average()
                .orElse(0.0);
        return media;
    }

    private static Avaliacao retornaAvaliacaoMaisRecente(List<Avaliacao> avaliacoesDoMembro) {
        return avaliacoesDoMembro.stream()
                .max(Comparator.comparing(Avaliacao::getDataHoraAvaliacao))
                .orElse(null);
    }

    private static Map<Integer, List<Avaliacao>> agruparAvaliacoesDeCadaMembro(List<Avaliacao> avaliacoes) {
        Map<Integer, List<Avaliacao>> avaliacoesAgrupadasPorMembro = avaliacoes.stream()
                .collect(Collectors.groupingBy(avaliacao -> avaliacao.getMembro().getId()));
        return avaliacoesAgrupadasPorMembro;
    }

    private static void ordenarLista(List<Ranking> listaDeRankings) {
        listaDeRankings.sort(Comparator.comparingDouble(Ranking::getMedia).reversed());
    }
}
