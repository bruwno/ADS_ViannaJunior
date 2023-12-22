/* Objetivo: Imprimir o quadrado dos pares até o número n informado.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 22/12/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1073
 * Nome    : Quadrado de Pares
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1073
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int n = readLine.nextInt();
        readLine.close();

        for (int i = 2; i <= n; i += 2) {
            int result = (int) Math.pow(i, 2);
            System.out.printf("%d^2 = %d\n", i, result);
        }
    }
}