package br.edu.vianna.sistemaclube.model.avaliacoes;

import br.edu.vianna.sistemaclube.model.atividades.Atividade;
import br.edu.vianna.sistemaclube.model.usuarios.Instrutor;
import br.edu.vianna.sistemaclube.model.usuarios.Membro;
import br.edu.vianna.sistemaclube.utils.datahora.FormataDataHora;

import java.time.LocalDateTime;

public class Avaliacao {
    private int id;
    private Membro membro;
    private Atividade atividade;
    private Instrutor instrutor;
    private String comentarioAvaliador;
    private boolean presente;
    private int nota;
    private LocalDateTime dataHoraAvaliacao;

    public Avaliacao() {}

    public Avaliacao(int id, Membro idMembro, Atividade atividade, Instrutor instrutor, int nota, String comentarioAvaliador, boolean presente, LocalDateTime dataHoraAvaliacao) {
        setId(id);
        setMembro(idMembro);
        setAtividade(atividade);
        setInstrutor(instrutor);
        setNota(nota);
        setComentarioAvaliador(comentarioAvaliador);
        setPresente(presente);
        setDataHoraAvaliacao(dataHoraAvaliacao);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        if (membro != null) {
            this.membro = membro;
        }
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        if (atividade != null) {
            this.atividade = atividade;
        }
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        if (instrutor != null) {
            this.instrutor = instrutor;
        }
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        if (nota >= 0 && nota <= 10) {
            this.nota = nota;
        }
    }

    public String getDataHoraAvaliacao() {
        return FormataDataHora.dbFormataDataHoraParaStringBase(dataHoraAvaliacao);
    }

    public void setDataHoraAvaliacao(LocalDateTime dataRegistro) {
        if (dataHoraAvaliacao == null) {
            this.dataHoraAvaliacao = LocalDateTime.now();
        } else {
            this.dataHoraAvaliacao = dataRegistro;
        }
    }

    public String getComentarioAvaliador() {
        return comentarioAvaliador;
    }

    public void setComentarioAvaliador(String comentarioAvaliador) {
        if (comentarioAvaliador != null && !comentarioAvaliador.isBlank()) {
            this.comentarioAvaliador = comentarioAvaliador.trim();
        }
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }
}
