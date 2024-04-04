package br.com.williamsilva.jogo.auxiliar;

import java.util.Random;

public class SortearJogador {
    public SortearJogador() {}

    public int sortearPrimeiraJogada() {
        Random sorteiaNum = new Random();
        int idJogador = sorteiaNum.nextInt(0,50);
        return (idJogador % 2 == 0) ? 1 : 2;
    }


}
