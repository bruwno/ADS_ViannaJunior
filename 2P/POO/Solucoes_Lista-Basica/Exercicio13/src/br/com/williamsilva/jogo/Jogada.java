package br.com.williamsilva.jogo;

import java.util.Arrays;

public enum Jogada {
    VAZIO('-', "Vazio"),
    JOGADOR1('X', "Jogador 1"),
    JOGADOR2('O', "Jogador 2");

    private final char simbolo;
    private final String nomeOcupacao;

    Jogada(char simbolo, String nomeOcupacao) {
        this.simbolo = simbolo;
        this.nomeOcupacao = nomeOcupacao;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public String getNomeOcupacao() {
        return nomeOcupacao;
    }

    public static Jogada[] getPossibilidades() {
        return (Jogada[]) Arrays.stream(Jogada.values()).toArray();
    }
}
