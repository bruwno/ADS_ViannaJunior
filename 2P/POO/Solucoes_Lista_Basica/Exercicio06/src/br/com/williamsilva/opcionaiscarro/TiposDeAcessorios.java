package br.com.williamsilva.opcionaiscarro;

import java.util.Arrays;
import java.util.List;

public enum TiposDeAcessorios {
    AR_CONDICIONADO("Ar Condicionado"),
    VIDRO_AUTOMATICO("Vidro Automático"),
    CAMBIO_AUTOMATICO("Câmbio Automático"),
    ALARME("Alarme"),
    PINTURA("Pintura especial"), // Preciso retornar o tipo da pintura! <AJUSTAR>
    TETO_SOLAR("Teto Solar"),
    KIT_MULTIMIDIA("Kit Multimídia");

    private final String tipoAcessorio;

    TiposDeAcessorios(String tipoAcessorio) {
        this.tipoAcessorio = tipoAcessorio;
    }

    public String getTipoAcessorio() {
        return tipoAcessorio;
    }

    public static List<TiposDeAcessorios> getTiposAcessorios() {
        return Arrays.asList(TiposDeAcessorios.values());
    }
}