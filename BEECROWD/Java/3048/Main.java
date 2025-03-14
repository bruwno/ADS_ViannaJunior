/* Objetivo: Exibir a quantidade máxima de números que podem estar em uma sequência sem se repetir.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 19/12/2023
 * Tipo    : 2 (AD-HOC)
 * ID      : 3048
 * Nome    : Sequência Secreta
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/3048
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);

        int tamSeq = readLine.nextInt();
        int[] sequencia = new int[tamSeq];

        for (int i = 0; i < sequencia.length; i++) {
            sequencia[i] = readLine.nextInt();
        }
        readLine.close();

        analisarSequencia(sequencia);
    }

    public static void analisarSequencia(int[] seq) {
        int qtdSeq = 1;

        for (int i = 0; i < seq.length - 1; i++) {
            int numAtual = seq[i];
            int proxNum = seq[i + 1];

            if (numAtual != proxNum) {
                qtdSeq++;
            }
        }
        System.out.printf("%d\n", qtdSeq);
    }
}