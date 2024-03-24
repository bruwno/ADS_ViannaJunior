package br.com.williamsilva.jogo;

public class Jogador {
    private int numJogador;
    private final Jogada simbolo;

    public Jogador() {
        this.simbolo = Jogada.JOGADOR1;
    }

    public Jogador(int numJogador) {
        this.numJogador = numJogador;
        this.simbolo = Jogada.JOGADOR1;
    }

    public int getNumJogador() {
        return numJogador;
    }

    public void setNumJogador(int numJogador) {
        this.numJogador = numJogador;
    }

    public char getSimbolo() {
        return simbolo.getSimbolo();
    }

    public void efetuarJogada() {

    }
}
