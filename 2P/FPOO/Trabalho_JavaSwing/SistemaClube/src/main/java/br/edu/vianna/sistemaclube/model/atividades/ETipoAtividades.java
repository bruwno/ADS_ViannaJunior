package br.edu.vianna.sistemaclube.model.atividades;

public enum ETipoAtividades {
    NATACAO("Natação"),
    FUTEBOL("Futebol"),
    VOLEIBOL("Voleibol"),
    TENIS("Tênis"),
    CORRIDA("Corrida"),
    CAPOEIRA("Capoeira"),
    BASQUETE("Basquete"),
    XADREZ("Xadrez");

    private String nomeAtividade;

    ETipoAtividades(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    @Override
    public String toString() {
        return nomeAtividade;
    }
}