/* Objetivo: Testar um valor de entrada.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 30/01/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1114
 * Nome    : Senha Fixa
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1114
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int senha;

        do {
            senha = readLine.nextInt();
            if (senha != 2002) {
                System.out.println("Senha Invalida");
            } else {
                System.out.println("Acesso Permitido");
                break;
            }
        } while (true);
        readLine.close();
    }
}