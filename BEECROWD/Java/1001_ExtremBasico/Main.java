/* Objetivo : Realizar uma soma e exibir na tela.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/12/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 1001
 * Nome     : Extremamente Básico
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/1001
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int a = readLine.nextInt();
        int b = readLine.nextInt();
        readLine.close();
        int result = a + b;

        System.out.println("X = " + result);
    }
}