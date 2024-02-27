package br.com.williamsilva.calculardistancia;

public class Ponto {
    private double x;
    private double y;
    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        if (!Double.isNaN(x)) {
            this.x = x;
        }
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        if (!Double.isNaN(y)) {
            this.y = y;
        }
    }
}
