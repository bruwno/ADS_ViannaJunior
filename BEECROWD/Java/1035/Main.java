/* Objetivo: Ler valores, realizar avaliações lógicas e determinar se é válido ou não.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 22/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1035
 * Nome    : Teste de Seleção 1
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1035
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        String[] valores = readLine.nextLine().trim().split(" ");
        int a = Integer.parseInt(valores[0]);
        int b = Integer.parseInt(valores[1]);
        int c = Integer.parseInt(valores[2]);
        int d = Integer.parseInt(valores[3]);
        int somaAB = a + b;
        int somaCD = c + d;

        if ((b > c) && (d > a) && (somaCD > somaAB) && (c > 0 && d > 0) && (ehPar(a))) {
            System.out.println("Valores aceitos");
        } else {
            System.out.println("Valores nao aceitos");
        }
        readLine.close();
    }

    private static boolean ehPar(int num) {
        return (num % 2 == 0) ? true : false;
    }
}