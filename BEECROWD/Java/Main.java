/* Objetivo : Apresentar um sequência de valores.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/12/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 1096
 * Nome     : Sequência IJ 2
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/1096
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        for (int cont = 0, i = 1, j = 7; cont < 11; cont++) {
            i = cont;
            j = 7;
            int contRepeticoes = 3;

            if (cont < 15 && ehImpar(i)) {
                while (contRepeticoes > 0) {
                    System.out.printf("I=%d J=%d\n", i, j);
                    j--;
                    contRepeticoes--;
                }
            }
        }
    }

    public static boolean ehImpar(int num) {
        if (num % 2 == 1) {
            return true;
        }
        return false;
    }
}