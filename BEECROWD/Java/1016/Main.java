/* Objetivo: Calcular a distância percorrida por dois veículos se movendo a velocidades diferentes.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 31/01/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1016
 * Nome    : Distância
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1016
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int distancia = readLine.nextInt();
        int tempo = distancia * 2;
        System.out.printf("%d minutos\n", tempo);
        readLine.close();
    }
}