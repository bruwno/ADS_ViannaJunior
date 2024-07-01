package br.edu.vianna.sistemaclube.model.usuarios;

import br.edu.vianna.sistemaclube.model.associados.ETipoAssociado;
import br.edu.vianna.sistemaclube.model.avaliacoes.Avaliacao;
import br.edu.vianna.sistemaclube.model.inscricoes.InscricaoAtividade;
import br.edu.vianna.sistemaclube.model.inscricoes.InscricaoEvento;
import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataDataHora;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Membro extends Usuario {
    private double valorAssociado;
    private ETipoAssociado tipoAssociado;
    private List<InscricaoAtividade> atividades;
    private List<InscricaoEvento> eventos;
    private List<Avaliacao> avaliacoes;

    public Membro() {
        atividades = new ArrayList<>();
        eventos = new ArrayList<>();
        avaliacoes = new ArrayList<>();
    }

    public Membro(double valorAssociado, ETipoAssociado tipoAssociado) {
        atividades = new ArrayList<>();
        eventos = new ArrayList<>();
        avaliacoes = new ArrayList<>();
        setValorAssociado(valorAssociado);
        setTipoAssociado(tipoAssociado);
    }

    public Membro(int id, String nome, String sobrenome, String cpf, String email, String login, String senha, double valorAssociado, ETipoAssociado tipoAssociado, String dataNascimento, LocalDateTime dataRegistro) {
        super(id, nome, sobrenome, cpf, email, login, senha, dataNascimento, dataRegistro);
        atividades = new ArrayList<>();
        eventos = new ArrayList<>();
        avaliacoes = new ArrayList<>();
        setValorAssociado(valorAssociado);
        setTipoAssociado(tipoAssociado);
    }

    public Membro(int id, String nome, String sobrenome, String cpf, String email, String login, String senha, double valorAssociado, ETipoAssociado tipoAssociado, String dataNascimento, LocalDateTime dataRegistro, LocalDateTime dataUltimoAcesso) {
        super(id, nome, sobrenome, cpf, email, login, senha, dataNascimento, dataRegistro, dataUltimoAcesso);
        atividades = new ArrayList<>();
        eventos = new ArrayList<>();
        avaliacoes = new ArrayList<>();
        setValorAssociado(valorAssociado);
        setTipoAssociado(tipoAssociado);
    }

    public double getValorAssociado() {
        return valorAssociado;
    }

    public void setValorAssociado(double valorAssociado) {
        if (valorAssociado >= 0.00) {
            this.valorAssociado = valorAssociado;
        }
    }

    public ETipoAssociado getTipoAssociado() {
        return tipoAssociado;
    }

    public void setTipoAssociado(ETipoAssociado tipoAssociado) {
        if (tipoAssociado != null) {
            this.tipoAssociado = tipoAssociado;
        }
    }

    // Métodos de itens únicos nas listas
    public void addInscricaoAtividade(InscricaoAtividade atividade) {
        if (atividade != null) {
            this.atividades.add(atividade);
        }
    }

    public void addInscricaoEvento(InscricaoEvento evento) {
        if (eventos != null) {
            this.eventos.add(evento);
        }
    }

    public void addAvaliacao(Avaliacao avaliacao) {
        if (avaliacoes != null) {
            this.avaliacoes.add(avaliacao);
        }
    }

    public void removerInscricaoEmAtividade(InscricaoAtividade inscricaoAtividade) {
        atividades.removeIf(inscricao -> inscricao.getId() == inscricaoAtividade.getId());
    }

    // Métodos de listas completas.
    public List<InscricaoAtividade> getInscricoesAtividades() {
        return atividades;
    }

    public void addInscricoesAtividades(List<InscricaoAtividade> atividades) {
        if (atividades != null) {
            this.atividades = atividades;
        }
    }

    public List<InscricaoEvento> getInscricoesEventos() {
        return eventos;
    }

    public void addInscricoesEventos(List<InscricaoEvento> eventos) {
        if (eventos != null) {
            this.eventos = eventos;
        }
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void addAvaliacoes(List<Avaliacao> avaliacoes) {
        if (avaliacoes != null) {
            this.avaliacoes = avaliacoes;
        }
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nNome: %s\nSobrenome: %s\nCPF: %s\nEmail: %s\nLogin: %s\nSenha: %s\nValor associado: %.2f\nData nascimento: %s\nData de registro: %s\nÚtimo acesso: %s\n",
                getId(), getNome(), getSobrenome(), getCpf(), getEmail(), getLogin(), getSenha(),
                getValorAssociado(),
                FormataData.formataDataParaExibicao(getDataNascimento()),
                FormataDataHora.formataDataHoraParaExibicaoSemSegundos(getDataRegistro()),
                FormataDataHora.formataDataHoraParaExibicaoSemSegundos(getDataUltimoAcesso()));
    }
}
