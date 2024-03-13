/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 27/02/2024
 *
 */

package br.com.williamsilva.calculoretangulo;

public class Retangulo {
    private double comprimento;
    private double largura;

    public Retangulo() {}

    public Retangulo(double comprimento, double largura) {
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        if (comprimento >= 0) {
            this.comprimento = comprimento;
        }
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        if (largura >= 0) {
            this.largura = largura;
        }
    }

    public double calculaArea() {
        return comprimento * largura;
    }

    public double calculaPerimetro() {
        return 2 * (comprimento + largura);
    }
}
