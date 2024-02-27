/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 26/02/2024
 * Exercício 4) Crie um programa que calcule a distância entre dois pontos no plano cartesiano.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] lados = leRetornaValor();

        Triangulo triangulo = new Triangulo(lados[0], lados[1], lados[2]);
        System.out.println(triangulo.calculaAreaTriangulo());
        System.out.println(triangulo.calculaPerimetroTriangulo());
        System.out.println(triangulo.defineTipoTriangulo());
    }



    private static double[] leRetornaValor() {
        Scanner scanner = new Scanner(System.in);
        double[] lados = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.printf("Digite o valor do lado %c: ", defineNomeLado(i));
            lados[i] = Double.parseDouble(scanner.nextLine());
        }
        return lados;
    }

    private static char defineNomeLado(int i) {
        if (i == 0) {
            return 'A';
        } else if (i == 1) {
            return 'B';
        } else {
            return 'C';
        }
    }
}