/* Objetivo : Apresentar um sequência de valores.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/12/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 1095
 * Nome     : Sequência IJ 1
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/1095
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        for (int i = 1, j = 60; i < 40 || j > 0; i += 3, j -= 5) {
            System.out.printf("I=%d J=%d\n", i, j);
        }
    }
}