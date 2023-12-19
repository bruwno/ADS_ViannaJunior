/* Objetivo : Imprimir a quantidade de números pares, ípares, positivos e negativos.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 19/12/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 1066
 * Nome     : Pares, Ímpares, Positivos e Negativos
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/1066
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int[] nums = new int[5];

        for (int i = 0; i < 5; i++) {
            nums[i] = readLine.nextInt();
        }
        readLine.close();

        int contPares = 0, contImpares = 0, contPositivos = 0, contNegativos = 0;
        for (int num : nums) {
            if (num % 2 == 0 & num > 0) {
                contPares++;
                contPositivos++;
            } else if (num % 2 == 0 & num < 0) {
                contPares++;
                contNegativos++;
            } else if (num % 2 != 0 & num > 0) {
                contImpares++;
                contPositivos++;
            } else if (num % 2 != 0 & num < 0) {
                contImpares++;
                contNegativos++;
            } else {
                contPares++;
            }
        }

        System.out.printf(
                "%d valor(es) par(es)\n%d valor(es) impar(es)\n%d valor(es) positivo(s)\n%d valor(es) negativo(s)\n",
                contPares, contImpares, contPositivos, contNegativos);
    }
}