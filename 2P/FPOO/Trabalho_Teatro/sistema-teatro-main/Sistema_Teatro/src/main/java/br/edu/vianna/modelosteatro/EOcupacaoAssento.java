package br.edu.vianna.modelosteatro;

public enum EOcupacaoAssento {
    DISPONIVEL("|_|"),
    OCUPADO("\\o/");

    private final String tipoOcupacao;

    EOcupacaoAssento(String tipoOcupacao) {
        this.tipoOcupacao = tipoOcupacao;
    }

    public String getTipoOcupacao() {
        return tipoOcupacao;
    }
}