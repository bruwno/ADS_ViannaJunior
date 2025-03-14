/*
 * Objetivo: Realizar um cálculo utilizando a fórmula de Bhaskara.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 22/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1036
 * Nome    : Fórmula de Bhaskara
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1036
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        String[] entrada = readLine.nextLine().trim().split(" ");
        double a = Double.parseDouble(entrada[0]);
        double b = Double.parseDouble(entrada[1]);
        double c = Double.parseDouble(entrada[2]);

        calcularBhaskara(a, b, c);
        readLine.close();
    }

    private static void calcularBhaskara(double a, double b, double c) {
        double delta = b * b - 4 * a * c;

        if (a == 0 || delta < 0) {
            System.out.println("Impossivel calcular");
        } else {
            double r1 = (-b + Math.sqrt(delta)) / (2 * a);
            double r2 = (-b - Math.sqrt(delta)) / (2 * a);

            System.out.printf("R1 = %.5f%nR2 = %.5f%n", r1, r2);
        }
    }
}