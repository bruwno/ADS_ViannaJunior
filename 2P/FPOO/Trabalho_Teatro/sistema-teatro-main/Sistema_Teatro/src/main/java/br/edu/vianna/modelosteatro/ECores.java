package br.edu.vianna.modelosteatro;

public enum ECores {
    RESET("\u001B[0m"),
    AMARELO("\u001B[33m");

    private final String codCor;

    ECores(String codCor) {
        this.codCor = codCor;
    }

    public String getCodCor() {
        return codCor;
    }
}
