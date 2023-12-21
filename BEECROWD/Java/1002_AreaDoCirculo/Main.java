/* Objetivo: Calcular a área do círculo.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 18/12/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1002
 * Nome    : Área do Círculo
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1002
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        double raio = readLine.nextDouble();
        readLine.close();
        double area = 3.14159 * Math.pow(raio, 2);
        System.out.printf("A=%.4f\n", area);
    }
}