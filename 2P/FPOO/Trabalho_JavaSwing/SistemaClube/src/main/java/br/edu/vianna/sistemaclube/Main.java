/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.vianna.sistemaclube;

import br.edu.vianna.sistemaclube.dao.IGenericDAO;
import br.edu.vianna.sistemaclube.dao.impl.*;
import br.edu.vianna.sistemaclube.dao.impl.usuariodao.AdministradorDAO;
import br.edu.vianna.sistemaclube.dao.impl.usuariodao.InstrutorDAO;
import br.edu.vianna.sistemaclube.dao.impl.usuariodao.MembroDAO;
import br.edu.vianna.sistemaclube.model.associados.ETipoAssociado;
import br.edu.vianna.sistemaclube.model.atividades.Atividade;
import br.edu.vianna.sistemaclube.model.atividades.ETipoAtividades;
import br.edu.vianna.sistemaclube.model.avaliacoes.Avaliacao;
import br.edu.vianna.sistemaclube.model.instrutores.EEspecializacao;
import br.edu.vianna.sistemaclube.model.eventos.Evento;
import br.edu.vianna.sistemaclube.model.inscricoes.InscricaoAtividade;
import br.edu.vianna.sistemaclube.model.rankings.Ranking;
import br.edu.vianna.sistemaclube.model.usuarios.Administrador;
import br.edu.vianna.sistemaclube.model.usuarios.Instrutor;
import br.edu.vianna.sistemaclube.model.usuarios.Membro;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author William Silva
 */
public class Main {

    public static void main(String[] args) {
        Administrador adm = new Administrador(1,"Samuel", "Costa", "12345678999", "samuel@mail.com", "samuel", "123", "18/06/2000", LocalDateTime.now(), LocalDateTime.now());
        Instrutor instrutor = new Instrutor(1, "Raphael", "Guarnieri", "00987654328", "raphael@mail.com", "raphael", "123", 1500, EEspecializacao.CAPOEIRA, "20/06/1994", LocalDateTime.now(), LocalDateTime.now());
        Instrutor instrutor2 = new Instrutor(2, "Otávio", "Henrique", "11122233345", "otavio@mail.com", "otavio", "123", 2000, EEspecializacao.FUTEBOL, "08/03/1989", LocalDateTime.now(), LocalDateTime.now());

        Membro membro = new Membro(1, "Diogenes", "Lopes", "12345678900", "dili@mail.com", "diogenes", "123", 1800.0, ETipoAssociado.ANUAL, "10/01/1995", LocalDateTime.now(), LocalDateTime.now());
        Membro membro2 = new Membro(2, "Romildo", "Santos", "12345678901", "romildo@mail.com", "romildo", "123", 150.0, ETipoAssociado.SEMESTRAL, "20/07/1990", LocalDateTime.now(), LocalDateTime.now());
        Membro membro3 = new Membro(3, "Renan", "Guedes", "11348678901", "renan@mail.com", "renan", "123", 150.0, ETipoAssociado.SEMESTRAL, "20/07/1995", LocalDateTime.now(), LocalDateTime.now());

        Atividade atv = new Atividade(1, "Corrida da madrugada", ETipoAtividades.CORRIDA, "Corrida de 1KM", "27/06/2024", "15:10", 2);
        Atividade atv2 = new Atividade(2, "Disputa de Natação", ETipoAtividades.NATACAO, "Disputa na piscina de 100M", "27/06/2024", "15:20", 1);
        Atividade atv3 = new Atividade(3, "Vôlei dos Compadres", ETipoAtividades.VOLEIBOL, "Jogo de vôlei", "27/06/2024", "15:15", 2);
        Atividade atv4 = new Atividade(4, "Basquete dos Truta", ETipoAtividades.BASQUETE, "Jogo de basquete", "27/06/2024", "15:12", 1);
        Atividade atv5 = new Atividade(5, "Aula de Tênis", ETipoAtividades.TENIS, "Aulas de tênis", "27/06/2024", "15:08", 2);
        Atividade atv6 = new Atividade(6, "Xadrez dos crias", ETipoAtividades.XADREZ, "Jogo de Xadrez", "27/06/2024", "15:30", 1);
        Atividade atv7 = new Atividade(7, "Capoeira do Paranauê", ETipoAtividades.CAPOEIRA, "Capoeira com o Mestre Confúcio", "27/06/2024", "15:42", 2);
        Atividade atv8 = new Atividade(8, "Corrida maluca", ETipoAtividades.CORRIDA, "Corrida de 15KM", "27/06/2024", "15:09", 1);
        Atividade atv9 = new Atividade(9, "Xadrez dos cabeça", ETipoAtividades.XADREZ, "Jogo de xadrez", "27/06/2024", "16:10", 2);
        Atividade atv10 = new Atividade(10, "Futebol do Happy-hour", ETipoAtividades.FUTEBOL, "Futebol de salão", "27/06/2024", "16:25", 2);

        Evento evt = new Evento(1, "Capoeira", "Capoeira da ginga sinistra", "27/06/2024", "13:50", 1);
        Evento evt2 = new Evento(2, "Churrascão do Clube", "Churrasco beneficente", "27/06/2024", "11:00", 2);

        Avaliacao avl = new Avaliacao(1, membro, atv , instrutor, 8, "Ótimo desempenho!", true, LocalDateTime.now());
        InscricaoAtividade insAtv = new InscricaoAtividade(1, membro, atv, "27/06/2024", "19:00", false);
        Ranking rnk = new Ranking(1, membro, atv, 5.0);

        try {
            new AdministradorDAO().inserir(adm);
            new InstrutorDAO().inserir(instrutor);
            new InstrutorDAO().inserir(instrutor2);

            new MembroDAO().inserir(membro);
            new MembroDAO().inserir(membro2);
            new MembroDAO().inserir(membro3);

            new AtividadeDAO().inserir(atv);
            new AtividadeDAO().inserir(atv2);
            new AtividadeDAO().inserir(atv3);
            new AtividadeDAO().inserir(atv4);
            new AtividadeDAO().inserir(atv5);
            new AtividadeDAO().inserir(atv6);
            new AtividadeDAO().inserir(atv7);
            new AtividadeDAO().inserir(atv8);
            new AtividadeDAO().inserir(atv9);
            new AtividadeDAO().inserir(atv10);

            new EventoDAO().inserir(evt);
            new EventoDAO().inserir(evt2);

//            new AvaliacaoDAO().inserir(avl);
//            new InscricaoAtividadeDAO().inserir(insAtv);
//            new InscricaoEventoDAO().inserir(insEvt);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.printf("Não foi possível executar a operação no banco: %s", e.getMessage());
        }
    }
}
