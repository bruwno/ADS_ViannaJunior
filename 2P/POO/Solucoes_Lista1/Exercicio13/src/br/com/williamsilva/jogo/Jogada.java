package br.com.williamsilva.jogo;

public enum Jogada {
    VAZIO('-'),
    JOGADOR1('X'),
    JOGADOR2('O');

    private final char simbolo;

    Jogada(char simbolo) {
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }
}
