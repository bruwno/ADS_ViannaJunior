/* Objetivo:
 * Autor   : William Silva (https://gitlab.com/unclWill)
 * Data    : 26/02/2024
 * Exercício 1) Crie um programa que calcule a distância entre dois pontos no plano cartesiano.
 */

public class Ponto {
    // Um ponto tem as coordenadas A e B.
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
