/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 26/02/2024
 * Exercício 5) Crie um programa para ler os 3 lados de um triângulo, ao final imprima sua área, seu
 * perímetro e o tipo de triângulo. Isósceles, Escaleno ou Equilátero.
 */

import java.util.Scanner;
import br.com.williamsilva.calctriangulo.Triangulo;

public class Main {
    public static void main(String[] args) {
        double[] lados = leRetornaLados();

        Triangulo triangulo = new Triangulo(lados[0], lados[1], lados[2]);

        System.out.println("Características do triângulo: ");
        System.out.println("Área = " + triangulo.calculaAreaTriangulo());
        System.out.println("Perímetro = " + triangulo.calculaPerimetroTriangulo());
        System.out.println("Tipo = " + triangulo.defineTipoTriangulo());
    }

    private static double[] leRetornaLados() {
        Scanner sc = new Scanner(System.in);
        double[] lados = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.printf("Digite o valor do lado %c: ", defineNomeLado(i));
            lados[i] = Double.parseDouble(sc.nextLine());
        }
        sc.close();
        return lados;
    }

    private static char defineNomeLado(int i) {
        char nomeLado;
        if (i == 0) {
            nomeLado = 'A';
        } else if (i == 1) {
            nomeLado = 'B';
        } else {
            nomeLado = 'C';
        }
        return nomeLado;
    }
}