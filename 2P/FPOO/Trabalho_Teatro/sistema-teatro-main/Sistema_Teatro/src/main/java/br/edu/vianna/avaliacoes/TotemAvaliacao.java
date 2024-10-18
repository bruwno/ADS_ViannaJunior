package br.edu.vianna.avaliacoes;

import java.util.Random;

public class TotemAvaliacao {
    public int atribuirNota() {
        Random geraNota = new Random();
        return geraNota.nextInt(0,6);
    }
}
