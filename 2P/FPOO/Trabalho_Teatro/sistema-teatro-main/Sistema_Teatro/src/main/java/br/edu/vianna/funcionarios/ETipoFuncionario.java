package br.edu.vianna.funcionarios;

public enum ETipoFuncionario {
    ADMINISTRADOR("Administrador"),
    VENDEDOR("Vendedor");

    private final String tipoFuncionario;

    ETipoFuncionario(String tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getTipoFuncionario() {
        return tipoFuncionario;
    }
}
