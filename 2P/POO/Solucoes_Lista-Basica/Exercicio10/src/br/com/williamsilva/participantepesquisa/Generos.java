package br.com.williamsilva.participantepesquisa;

import java.util.Arrays;
import java.util.List;

public enum Generos {
    MASCULINO('M', "Masculino"),
    FEMININO('F',"Feminino");

    private final char idGenero;
    private final String nomeGenero;

    Generos(char idGenero, String nomeGenero) {
        this.idGenero = idGenero;
        this.nomeGenero = nomeGenero;
    }

    public char getIdGenero() {
        return idGenero;
    }

    public String getNomeGenero() {
        return nomeGenero;
    }

    public static List<Generos> getGeneros() {
        return Arrays.asList((Generos.values()));
    }
}
