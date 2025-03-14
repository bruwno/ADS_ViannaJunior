/* Objetivo: Realizar a soma de dois valores.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 18/12/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1003
 * Nome    : Soma Simples
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1003
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int a = readLine.nextInt();
        int b = readLine.nextInt();
        readLine.close();

        int soma = a + b;
        System.out.printf("SOMA = %d\n", soma);
    }
}