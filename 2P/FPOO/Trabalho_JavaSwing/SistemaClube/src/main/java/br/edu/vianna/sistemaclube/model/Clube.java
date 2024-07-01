package br.edu.vianna.sistemaclube.model;

import br.edu.vianna.sistemaclube.model.atividades.Atividade;
import br.edu.vianna.sistemaclube.model.eventos.Evento;
import br.edu.vianna.sistemaclube.model.inscricoes.InscricaoAtividade;
import br.edu.vianna.sistemaclube.model.inscricoes.InscricaoEvento;
import br.edu.vianna.sistemaclube.model.rankings.Ranking;
import br.edu.vianna.sistemaclube.model.usuarios.Administrador;
import br.edu.vianna.sistemaclube.model.usuarios.Instrutor;
import br.edu.vianna.sistemaclube.model.usuarios.Membro;

import java.util.ArrayList;
import java.util.List;

public class Clube {
    private String nome;
    private List<Administrador> administradores;
    private List<Instrutor> instrutores;
    private List<Membro> membros;
    private List<Evento> eventos;
    private List<Atividade> atividades;
    private List<InscricaoAtividade> inscricoesAtividades;
    private List<InscricaoEvento> inscricoesEventos;
    private List<Ranking> rankings;

    private static Clube instance;

    private Clube() {
        this.administradores = new ArrayList<>();
        this.instrutores = new ArrayList<>();
        this.membros = new ArrayList<>();
        this.eventos = new ArrayList<>();
        this.atividades = new ArrayList<>();
        this.rankings = new ArrayList<>();
    }

    public static synchronized Clube getInstance() {
        if (instance == null) {
            instance = new Clube();
        }
        return instance;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null || !nome.isBlank()) {
            this.nome = nome;
        }
    }

    public List<Administrador> getAdministradores() {
        return administradores;
    }

    public List<Instrutor> getInstrutores() {
        return instrutores;
    }

    public List<Membro> getMembros() {
        return membros;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public List<Ranking> getRankings() {
        return rankings;
    }

    public List<InscricaoAtividade> getInscricoesAtividades() {
        return inscricoesAtividades;
    }

    public List<InscricaoEvento> getInscricoesEventos() {
        return inscricoesEventos;
    }

    public void addAdministrador(Administrador administrador) {
        this.administradores.add(administrador);
    }

    public void addInstrutor(Instrutor instrutor) {
        this.instrutores.add(instrutor);
    }

    public void addMembro(Membro membro) {
        this.membros.add(membro);
    }

    public void addEvento(Evento evento) {
        this.eventos.add(evento);
    }

    public void addAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }

    public void addRanking(Ranking ranking) {
        this.rankings.add(ranking);
    }

    // Adição de listas completas.
    public void addAdministradores(List<Administrador> administradores) {
        this.administradores = administradores;
    }

    public void addInstrutores(List<Instrutor> instrutores) {
        this.instrutores = instrutores;
    }

    public void addMembros(List<Membro> membros) {
        this.membros = membros;
    }

    public void addEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public void addAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    public void addInscricaoAtividade(InscricaoAtividade inscricaoAtividade) {
        this.inscricoesAtividades.add(inscricaoAtividade);
    }

    public void addInscricaoEvento(InscricaoEvento inscricaoEvento) {
        this.inscricoesEventos.add(inscricaoEvento);
    }

    public void addInscricoesAtividades(List<InscricaoAtividade> inscricoes) {
        this.inscricoesAtividades = inscricoes;
    }

    public void addInscricoesEventos(List<InscricaoEvento> inscricoes) {
        this.inscricoesEventos = inscricoes;
    }

    public void addRankings(List<Ranking> rankings) {
        this.rankings = rankings;
    }
}