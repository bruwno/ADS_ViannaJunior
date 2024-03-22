package br.com.williamsilva.jogo;

import java.util.Arrays;

public enum PossibilidadeDeOcupacao {
    VAZIO(' ', "Vazio"),
    JOGADOR1('X', "Jogador 1"),
    JOGADOR2('O', "Jogador 2");

    private final char ocupacao;
    private final String nomeOcupacao;

    PossibilidadeDeOcupacao(char ocupacao, String nomeOcupacao) {
        this.ocupacao = ocupacao;
        this.nomeOcupacao = nomeOcupacao;
    }

    public char getOcupacao() {
        return ocupacao;
    }

    public String getNomeOcupacao() {
        return nomeOcupacao;
    }

    public static PossibilidadeDeOcupacao[] getPossibilidades() {
        return (PossibilidadeDeOcupacao[]) Arrays.stream(PossibilidadeDeOcupacao.values()).toArray();
    }
}
