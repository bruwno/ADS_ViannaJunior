package br.com.williamsilva.jogo.auxiliar;

import br.com.williamsilva.jogo.Jogador;
import java.security.SecureRandom;

public class SorteiaPrimeiraJogada {
    private Jogador primeiroAJogar;

    public SorteiaPrimeiraJogada() {
        this.primeiroAJogar = new Jogador();
    }

    public Jogador getPrimeiroAJogar() {
        return primeiroAJogar;
    }

    public int sortearPrimeiraJogada() {
        SecureRandom idJogador = new SecureRandom();
        primeiroAJogar.setNumJogador(idJogador.nextInt(1,3));
        return primeiroAJogar.getNumJogador();
    }


}
