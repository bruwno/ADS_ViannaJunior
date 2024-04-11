/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 26/02/2024
 *
 */

package br.com.williamsilva.auxiliar;

import java.util.Scanner;

public class LerLados {
    private static final int QUANTIDADE_LADOS = 3;

    public static double[] leRetornaLados() {
        Scanner sc = new Scanner(System.in);
        double[] lados = new double[QUANTIDADE_LADOS];

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
