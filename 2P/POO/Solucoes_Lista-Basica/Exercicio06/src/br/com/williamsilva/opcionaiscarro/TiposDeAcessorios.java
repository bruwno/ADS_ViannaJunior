package br.com.williamsilva.opcionaiscarro;

import java.util.Arrays;
import java.util.List;

public enum TiposDeAcessorios {
    AR_CONDICIONADO("Ar Condicionado", 3000),
    VIDRO_AUTOMATICO("Vidro Automático", 1500),
    CAMBIO_AUTOMATICO("Câmbio Automático", 5000),
    ALARME("Alarme", 800),
    PINTURA("Pintura customizada", 2500), // Preciso retornar o tipo da pintura! <AJUSTAR>
    TETO_SOLAR("Teto Solar", 4000),
    KIT_MULTIMIDIA("Kit Multimídia", 1800);

    private final String tipoAcessorio;
    private final double preco;

    TiposDeAcessorios(String tipoAcessorio, double preco) {
        this.tipoAcessorio = tipoAcessorio;
        this.preco = preco;
    }

    public String getTipoAcessorio() {
        return tipoAcessorio;
    }

    public double getPrecoAcessorio() {
        return preco;
    }

    public static List<TiposDeAcessorios> getTiposAcessorios() {
        return Arrays.asList(TiposDeAcessorios.values());
    }
}