package br.com.williamsilva.participantepesquisa;

import java.util.Arrays;
import java.util.List;

public enum CoresOlhos {
    AZUIS(1,"Azuis"),
    VERDES(2,"Verdes"),
    CASTANHOS(3,"Castanhos");

    private final int id;
    private final String cor;

    CoresOlhos(int id, String cor) {
        this.id = id;
        this.cor = cor;
    }

    public String getCorDosOlhos() {
        return cor;
    }

    public int getIdCorDosOlhos() {
        return id;
    }

    public static List<CoresOlhos> getCoresOlhos() {
        return Arrays.asList((CoresOlhos.values()));
    }
}
