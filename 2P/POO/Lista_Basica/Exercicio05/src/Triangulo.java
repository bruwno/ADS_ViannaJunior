public class Triangulo {
    private double a;
    private double b;
    private double c;

    public Triangulo() {}

    public Triangulo(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double calculaAreaTriangulo() {
        return b * c / 2;
    }

    public double calculaPerimetroTriangulo() {
        return a + b + c;
    }

    public String defineTipoTriangulo() {
        String tipoTriangulo;
        if (trianguloEquilatero()) {
            tipoTriangulo = "Equilátero";
        } else if (trianguloIsosceles()) {
            tipoTriangulo = "Isósceles";
        } else {
            tipoTriangulo = "Escaleno";
        }

        return tipoTriangulo;
    }

    private boolean trianguloEquilatero() {
        return ((a == b) && (b == c));
    }

    private boolean trianguloIsosceles() {
        return (a == b || a == c || b == c);
    }
}
