package br.edu.vianna.sistemaclube.model.inscricoes;

import br.edu.vianna.sistemaclube.model.eventos.Evento;
import br.edu.vianna.sistemaclube.model.usuarios.Membro;
import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataHora;

import java.time.LocalDate;
import java.time.LocalTime;

public class InscricaoEvento {
    private int id;
    private Membro membro;
    private Evento evento;
    private LocalDate dataInscricao;
    private LocalTime horaInscricao;

    public InscricaoEvento() {}

    public InscricaoEvento(int id, Membro membro, Evento evento, String dataInscricao, String horaInscricao) {
        setId(id);
        setMembro(membro);
        setEvento(evento);
        setDataInscricao(dataInscricao);
        setHoraInscricao(horaInscricao);
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

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        if (evento != null) {
            this.evento = evento;
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

    @Override
    public String toString() {
        return String.format("Id: %d\nMembro: %s\nEvento: %s\nData inscrição: %s\nHora inscrição: %s\n",
                getId(),
                getMembro().getNome(),
                getEvento(),
                FormataData.formataDataParaExibicao(getDataInscricao()),
                getHoraInscricao());
    }
}
