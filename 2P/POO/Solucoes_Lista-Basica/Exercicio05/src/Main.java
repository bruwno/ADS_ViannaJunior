/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 26/02/2024
 *
 * Exercício 5 - Crie um programa para ler os 3 lados de um triângulo, ao final imprima sua área, seu
 * perímetro e o tipo de triângulo. Isósceles, Escaleno ou Equilátero.
 */

import br.com.williamsilva.auxiliar.LerLados;
import br.com.williamsilva.calctriangulo.Triangulo;

public class Main {
    public static void main(String[] args) {
        double[] lados = LerLados.leRetornaLados();
        double ladoA = lados[0], ladoB = lados[1], ladoC = lados[2];

        Triangulo triangulo = new Triangulo();
        triangulo.setA(ladoA);
        triangulo.setB(ladoB);
        triangulo.setC(ladoC);

        exibeCaracTriangulo(triangulo);
    }

    public static void exibeCaracTriangulo(Triangulo triangulo){
        System.out.println("Características do triângulo: ");
        System.out.println("Área      = " + triangulo.calculaAreaTriangulo());
        System.out.println("Perímetro = " + triangulo.calculaPerimetroTriangulo());
        System.out.println("Tipo      = " + triangulo.defineTipoTriangulo());
    }
}