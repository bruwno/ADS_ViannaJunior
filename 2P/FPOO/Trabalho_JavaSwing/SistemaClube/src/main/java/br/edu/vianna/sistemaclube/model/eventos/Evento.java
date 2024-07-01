package br.edu.vianna.sistemaclube.model.eventos;

import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataHora;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private int id;
    private String nome;
    private String descricao;
    private LocalDate dataEvento;
    private LocalTime horarioEvento;
    private int idInstrutor;

    public Evento() {}

    public Evento(int id, String nome, String descricao, String dataEvento, String horaEvento, int idInstrutor) {
        setId(id);
        setNome(nome);
        setDescricao(descricao);
        setDataEvento(dataEvento);
        setHoraEvento(horaEvento);
        setIdInstrutor(idInstrutor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao != null && !descricao.isBlank()) {
            this.descricao = descricao;
        }
    }

    public String getDataEvento() {
        return FormataData.dbFormataDataParaStringBase(dataEvento);
    }

    public void setDataEvento(String dataEvento) {
        if (dataEvento != null && !dataEvento.isBlank()) {
            this.dataEvento = FormataData.formataStringParaData(dataEvento);
        }
    }

    public String getHoraEvento() {
        return FormataHora.formataHoraParaString(horarioEvento);
    }

    public void setHoraEvento(String horarioEvento) {
        if (horarioEvento != null) {
            this.horarioEvento = FormataHora.formataStringParaHora(horarioEvento);
        }
    }

    public int getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(int idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nNome: %s\nDescrição: %s\nData do evento: %s\nHorário do evento: %s\nId Instrutor: %d\n",
                getId(), getNome(), getDescricao(),
                FormataData.formataDataParaExibicao(getDataEvento()),
                getHoraEvento(),
                getIdInstrutor());
    }
}
