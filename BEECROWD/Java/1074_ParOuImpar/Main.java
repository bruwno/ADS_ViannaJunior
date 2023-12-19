/*
 * Objetivo : Imprimir strings de acordo com o número digitado.
 * Autor : William Silva (https://github.com/unclWill)
 * Data : 19/12/2023
 * Tipo : 1 (INICIANTE)
 * ID : 1074
 * Nome : Par ou Ímpar
 * Link : https://www.beecrowd.com.br/judge/pt/problems/view/1074
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int n = readLine.nextInt();
        int[] valores = new int[n];

        for (int i = 0; i < valores.length; i++) {
            valores[i] = readLine.nextInt();
        }
        readLine.close();

        final String even = "EVEN";
        final String odd = "ODD";
        final String positive = "POSITIVE";
        final String negative = "NEGATIVE";
        final String nullValue = "NULL";

        for (int i = 0; i < valores.length; i++) {
            int num = valores[i];

            if (ehPar(num) == true && ehPositivo(num) == true) {
                System.out.printf("%s %s\n", even, positive);
            } else if (ehPar(num) == true && (ehPositivo(num) == false && num != 0)) {
                System.out.printf("%s %s\n", even, negative);
            } else if (ehPar(num) == false && ehPositivo(num) == true) {
                System.out.printf("%s %s\n", odd, positive);
            } else if (ehPar(num) == false && (ehPositivo(num) == false && num != 0)) {
                System.out.printf("%s %s\n", odd, negative);
            } else {
                System.out.printf("%s\n", nullValue);
            }
        }
    }

    public static boolean ehPar(int num) {
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }

    public static boolean ehPositivo(int num) {
        if (num > 0) {
            return true;
        }
        return false;
    }
}