package br.edu.vianna.sistemaclube.model.instrutores;

public enum EEspecializacao {
    NENHUMA("Nenhuma"),
    NATACAO("Natação"),
    FUTEBOL("Futebol"),
    VOLEIBOL("Voleibol"),
    TENIS("Tênis"),
    ATLETISMO("Atletismo"),
    CAPOEIRA("Capoeira"),
    BASQUETE("Basquete"),
    XADREZ("Xadrez");

    private String nomeEspecialidade;

    EEspecializacao(String nomeEspecialidade) {
        this.nomeEspecialidade = nomeEspecialidade;
    }

    @Override
    public String toString() {
        return nomeEspecialidade;
    }
}