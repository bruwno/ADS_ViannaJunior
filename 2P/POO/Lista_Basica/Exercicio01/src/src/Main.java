/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 26/02/2024
 * Exercício 1) Crie um programa que calcule a distância entre dois pontos no plano cartesiano.
 */

import br.com.williamsilva.calculardistancia.CalculadoraDeDistancia;
import br.com.williamsilva.calculardistancia.Ponto;

public class Main {
    public static void main(String[] args) {
        Ponto a , b;
        a = new Ponto(8, 3);
        b = new Ponto(-4, 8);

        CalculadoraDeDistancia calcDistancia = new CalculadoraDeDistancia();
        System.out.println("Distância = " + calcDistancia.calculaDistanciaEntrePontos(a, b));
    }
}
