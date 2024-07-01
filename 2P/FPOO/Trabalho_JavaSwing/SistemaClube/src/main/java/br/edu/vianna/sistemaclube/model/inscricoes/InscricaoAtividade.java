package br.edu.vianna.sistemaclube.model.inscricoes;

import br.edu.vianna.sistemaclube.model.atividades.Atividade;
import br.edu.vianna.sistemaclube.model.usuarios.Membro;
import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataHora;

import java.time.LocalDate;
import java.time.LocalTime;

public class InscricaoAtividade {
    private int id;
    private Membro membro;
    private Atividade atividade;
    private LocalDate dataInscricao;
    private LocalTime horaInscricao;
    private boolean atividadeAvaliada;

    public InscricaoAtividade() {}

    public InscricaoAtividade(int id, Membro membro, Atividade atividade, String dataInscricao, String horaInscricao) {
        setId(id);
        setMembro(membro);
        setAtividade(atividade);
        setDataInscricao(dataInscricao);
        setHoraInscricao(horaInscricao);
        setAtividadeAvaliada(atividadeAvaliada);
    }

    public InscricaoAtividade(int id, Membro membro, Atividade atividade, String dataInscricao, String horaInscricao, boolean atividadeAvaliada) {
        setId(id);
        setMembro(membro);
        setAtividade(atividade);
        setDataInscricao(dataInscricao);
        setHoraInscricao(horaInscricao);
        setAtividadeAvaliada(atividadeAvaliada);
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

    public String getDataInscricao() {
        return FormataData.dbFormataDataParaStringBase(dataInscricao);
    }

    public void setDataInscricao(String dataInscricao) {
        if (dataInscricao != null && !dataInscricao.isBlank()) {
            this.dataInscricao = FormataData.formataStringParaData(dataInscricao);
        }
    }

    public String getHoraInscricao() {
        return FormataHora.formataHoraParaString(horaInscricao);
    }

    public void setHoraInscricao(String horaInscricao) {
        this.horaInscricao = FormataHora.formataStringParaHora(horaInscricao);
    }

    public boolean isAtividadeAvaliada() {
        return atividadeAvaliada;
    }

    public void setAtividadeAvaliada(boolean atividadeAvaliada) {
        this.atividadeAvaliada = atividadeAvaliada;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nMembro: %s\nAtividade: %s\nData inscrição: %s\nHora inscrição: %s\n",
                getId(),
                getMembro().getNome(),
                getAtividade(),
                FormataData.formataDataParaExibicao(getDataInscricao()),
                getHoraInscricao());
    }
}