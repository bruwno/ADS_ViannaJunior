/* Objetivo: Calcular a distância entre dois pontos.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 05/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1015
 * Nome    : Distância Entre Dois Pontos
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1015
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        String[] p1 = readLine.nextLine().trim().split("\\s+");
        String[] p2 = readLine.nextLine().trim().split("\\s+");

        double x1 = Double.parseDouble(p1[0]);
        double x2 = Double.parseDouble(p2[0]);
        double y1 = Double.parseDouble(p1[1]);
        double y2 = Double.parseDouble(p2[1]);

        readLine.close();
        System.out.printf("%.4f\n", calculaDistancia(x1, x2, y1, y2));
    }

    private static double calculaDistancia(double x1, double x2, double y1, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}