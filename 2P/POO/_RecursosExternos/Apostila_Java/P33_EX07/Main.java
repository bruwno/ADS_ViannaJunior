/* Objetivo : Imprimir o valor de x.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 29/12/2023
 * Material : Apostila Java - Alura | Variáveis Primitivas e Controle de Fluxo
 * Slide    : 33
 * Exercício: 07
 */

/* 7. (Opcional) Escreva um programa em que, dada uma variável  x  com algum valor inteiro, temos um
 * novo  x  de acordo com a seguinte regra:
 * Se  x  é par,  x = x / 2 ;
 * Se  x  é impar,  x = 3 * x + 1 ;
 * Imprime  x ;
 * O programa deve parar quando  x  tiver o valor final de 1. Por exemplo, para  x = 13 , a saída será:
 * 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner readLine = new Scanner(System.in);
        int x = readLine.nextInt();
        readLine.close();

        do {
            if (x % 2 == 0) {
                x = x / 2;
            } else {
                x = 3 * x + 1;
            }
            // Impressão.
            if (x == 1) {
                System.out.printf("%d ", x);
            } else {
                System.out.printf("%d -> ", x);
            }
        } while (x != 1);
    }
}