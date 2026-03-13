/* Objetivo: Ler um número, que representa uma senha, e exibir o número que vem depois dele.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 05/10/2025
 * Tipo    : 5 (MATEMÁTICA)
 * ID      : 3104
 * Nome    : Resto 2.0
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/3104
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        int b = Integer.parseInt(sc.nextLine());
        long resto = 0;

        for (char digito : a.toCharArray()) {
            int valor = digito - '0';
            resto = (resto * 10 + valor) % b;
        }

        System.out.println(resto);
    }
}