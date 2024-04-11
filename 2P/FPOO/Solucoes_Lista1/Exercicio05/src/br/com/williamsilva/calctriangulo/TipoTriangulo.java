package br.com.williamsilva.calctriangulo;

public enum TipoTriangulo {
    EQUILATERO("Equilátero"),
    ISOSCELES("Isósceles"),
    ESCALENO("Escaleno");

    private final String tipoTriangulo;

    TipoTriangulo(String tipoTriangulo) {
        this.tipoTriangulo = tipoTriangulo;
    }

    public String getTipoTriangulo() {
        return tipoTriangulo;
    }
}