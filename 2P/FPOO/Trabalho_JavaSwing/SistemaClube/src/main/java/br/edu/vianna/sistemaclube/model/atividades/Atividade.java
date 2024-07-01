package br.edu.vianna.sistemaclube.model.atividades;

import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataHora;

import java.time.LocalDate;
import java.time.LocalTime;

public class Atividade {
    private int id;
    private String nome;
    private ETipoAtividades tipoAtividade;
    private String descricao;
    private LocalDate dataAtividade;
    private LocalTime horaAtividade;
    private int idInstrutor;

    public Atividade() {}

    public Atividade(String nome, ETipoAtividades tipoAtividade, String descricao, String dataAtividade, String horaAtividade, int idInstrutor) {
        setNome(nome);
        setTipoAtividade(tipoAtividade);
        setDescricao(descricao);
        setDataAtividade(dataAtividade);
        setHoraAtividade(horaAtividade);
        setIdInstrutor(idInstrutor);
    }

    public Atividade(int id, String nome, ETipoAtividades tipoAtividade, String descricao, String dataAtividade, String horaAtividade, int idInstrutor) {
        setId(id);
        setNome(nome);
        setTipoAtividade(tipoAtividade);
        setDescricao(descricao);
        setDataAtividade(dataAtividade);
        setHoraAtividade(horaAtividade);
        setIdInstrutor(idInstrutor);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ETipoAtividades getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(ETipoAtividades tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao != null) {
            this.descricao = descricao.trim();
        }
    }

    public String getDataAtividade() {
        return FormataData.dbFormataDataParaStringBase(dataAtividade);
    }

    public void setDataAtividade(String dataAtividade) {
        if (dataAtividade != null && !dataAtividade.isBlank()) {
            this.dataAtividade = FormataData.formataStringParaData(dataAtividade);
        }
    }

    public String getHoraAtividade() {
        return FormataHora.formataHoraParaString(horaAtividade);
    }

    public void setHoraAtividade(String horaAtividade) {
        this.horaAtividade = FormataHora.formataStringParaHora(horaAtividade);
    }

    public int getIdInstrutor() {
        return idInstrutor;
    }

    public void setIdInstrutor(int idInstrutor) {
        this.idInstrutor = idInstrutor;
    }

}

