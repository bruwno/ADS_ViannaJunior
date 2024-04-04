package br.com.williamsilva.jogo.auxiliar;

public enum CorTexto {
    RESET("\u001B[0m"),
    VERDE("\u001B[32m"),
    AZUL("\u001B[34m");

    private final String codCor;

    CorTexto(String codCor) {
        this.codCor = codCor;
    }

    public String getCodCor() {
        return codCor;
    }
}
