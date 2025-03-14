/* Objetivo: Verificar se um número é primo.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 04/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1165
 * Nome    : Número Primo
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1165
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        ArrayList<Integer> numeros = new ArrayList<>();
        int n = Integer.parseInt(readLine.nextLine());

        for (int i = 0; i < n; i++) {
            numeros.add(Integer.parseInt(readLine.nextLine()));
        }
        readLine.close();

        for (int numero : numeros) {
            if (ehPrimo(numero)) {
                System.out.printf("%d eh primo\n", numero);
            } else {
                System.out.printf("%d nao eh primo\n", numero);
            }
        }
    }

    private static boolean ehPrimo(int num) {
        if (num <= 1) {
            return false;
        }

        if (num == 2 || num == 3) {
            return true;
        }

        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }
}