/*
 * Objetivo: Simular o jogo do PIM.
 * Autor : William Silva (https://github.com/unclWill)
 * Data : 23/12/2023
 * Tipo : 9 (SQL)
 * ID : 1142
 * Nome : PUM
 * Link : https://www.beecrowd.com.br/judge/pt/problems/view/1142
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int n = readLine.nextInt();
        readLine.close();
        int cont = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 3; j++) {
                if (j == 3) {
                    System.out.println("PUM");
                } else {
                    System.out.printf("%d ", cont);
                }
                cont++;
            }
        }
    }
}