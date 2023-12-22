/* Objetivo : Contar quantas casas brancas e quantas casas pretas um tabuleiro de xadrez com n linhas e colunas possui.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 21/12/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 3342
 * Nome     : Keanu
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/3342
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int dim = readLine.nextInt();
        readLine.close();
        int[][] tabuleiro = new int[dim][dim];
        int casasBrancas = 0, casasPretas = 0;

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                if ((i % 2 == 0) && (j % 2 == 0) || (i % 2 != 0) && (j % 2 != 0)) {
                    casasBrancas++;
                } else {
                    casasPretas++;
                }
            }
        }
        System.out.printf("%d casas brancas e %d casas pretas\n", casasBrancas, casasPretas);
    }
}