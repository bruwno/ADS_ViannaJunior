/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 26/02/2024
 *
 * Exercício 5
 */

import br.com.williamsilva.auxiliar.LerLados;
import br.com.williamsilva.calctriangulo.Triangulo;

public class Main {
    public static void main(String[] args) {
        double[] lados = LerLados.leRetornaLados();
        Triangulo triangulo = new Triangulo(lados[0], lados[1], lados[2]);

        System.out.println("Características do triângulo: ");
        System.out.println("Área = " + triangulo.calculaAreaTriangulo());
        System.out.println("Perímetro = " + triangulo.calculaPerimetroTriangulo());
        System.out.println("Tipo = " + triangulo.defineTipoTriangulo());
    }
}