/* Objetivo : Calcular Ã¡rea.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 26/09/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 1012
 * Nome     : Área
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/1012
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    static final int dimArray = 3;
    static final double pi = 3.14159;

    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        String[] entrada = new String[3];
        entrada = readLine.nextLine().split(" ");
        readLine.close();

        double[] valores = converterArray(entrada);

        double a = valores[0], b = valores[1], c = valores[2];
        calcular(a, b, c);
    }

    public static void calcular(double a, double b, double c) {
        double areaTriangRet = a * c / 2.0;
        double areaCirculo = pi * Math.pow(c, 2.0);
        double areaTrapezio = (a + b) * c / 2.0;
        double areaQuad = Math.pow(b, 2.0);
        double areaRet = a * b;

        System.out.printf("TRIANGULO: %.3f\nCIRCULO: %.3f\nTRAPEZIO: %.3f\nQUADRADO: %.3f\nRETANGULO: %.3f\n",
                areaTriangRet, areaCirculo, areaTrapezio, areaQuad,
                areaRet);
    }

    public static double[] converterArray(String[] entrada) {
        return Arrays.stream(entrada)
                .mapToDouble(Double::parseDouble)
                .toArray();
    }
}