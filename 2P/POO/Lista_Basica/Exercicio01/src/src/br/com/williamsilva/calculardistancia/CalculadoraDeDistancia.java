package br.com.williamsilva.calculardistancia;

public class CalculadoraDeDistancia {
    public double calculaDistanciaEntrePontos(Ponto a, Ponto b) {
        return Math.sqrt(Math.pow(a.getY() - a.getX(), 2) + (Math.pow(b.getY() - b.getX(), 2)));
    }
}
