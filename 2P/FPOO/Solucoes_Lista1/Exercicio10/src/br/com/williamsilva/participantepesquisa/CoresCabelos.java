package br.com.williamsilva.participantepesquisa;

import java.util.Arrays;
import java.util.List;

public enum CoresCabelos {
    LOUROS(1, "Louros"),
    CASTANHOS(2, "Castanhos"),
    PRETOS(3, "Pretos");

    private final int idCorCabelos;
    private final String corCabelos;

    CoresCabelos(int idCorCabelos, String corCabelos) {
        this.idCorCabelos = idCorCabelos;
        this.corCabelos = corCabelos;
    }

    public int getIdCorCabelos() {
        return idCorCabelos;
    }

    public String getCorDosCabelos() {
        return corCabelos;
    }

    public static List<CoresCabelos> getCoresDeCabelos() {
        return Arrays.asList((CoresCabelos.values()));
    }

}
