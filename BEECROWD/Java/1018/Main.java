/* Objetivo: Determinar a quantidade de notas necessárias para formar um valor.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 05/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1018
 * Nome    : Cédulas
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1018
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static final int NOTA100 = 100, NOTA50 = 50, NOTA20 = 20, NOTA10 = 10, NOTA5 = 5, NOTA2 = 2, NOTA1 = 1;

    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int valor = Integer.parseInt(readLine.nextLine());
        int valorOriginal = valor;
        readLine.close();
        int[] notas = new int[] { NOTA100, NOTA50, NOTA20, NOTA10, NOTA5, NOTA2, NOTA1 };
        int[] qtdNotas = new int[notas.length];

        for (int i = 0; i < notas.length; i++) {
            qtdNotas[i] = valor / notas[i];
            valor %= notas[i];
        }

        System.out.printf("%d\n", valorOriginal);

        for (int i = 0; i < notas.length; i++) {
            System.out.printf("%d nota(s) de R$ %d,00\n", qtdNotas[i], notas[i]);
        }
    }
}