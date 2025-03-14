/* Objetivo: Imprimir o quociente q seguido pelo resto r da divisão de a por b.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 31/01/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1837
 * Nome    : Prefácio
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1837
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        String[] entrada = readLine.nextLine().trim().split(" ");
        readLine.close();
        int a = Integer.parseInt(entrada[0]);
        int b = Integer.parseInt(entrada[1]);
        int q, r;

        if (a >= 0) {
            q = a / b;
            r = a % b;
        } else {
            int c, d = 0;

            c = retornaNumeroPositivo(b);

            for (r = 0; r < c; r++) {
                d = a - r;

                if (d % b == 0) {
                    break;
                }
            }
            q = d / b;
        }
        System.out.printf("%d %d\n", q, r);
    }

    private static int retornaNumeroPositivo(int num) {
        if (num < 0) {
            return num * -1;
        } else {
            return num;
        }
    }
}