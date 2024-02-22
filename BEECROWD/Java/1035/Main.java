/* Objetivo: Ler valores, realizar avaliações lógicas e determinar se é válido ou não.
 * Autor   : William Silva (https://github.com/unclWill)
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
        int A = Integer.parseInt(valores[0]);
        int B = Integer.parseInt(valores[1]);
        int C = Integer.parseInt(valores[2]);
        int D = Integer.parseInt(valores[3]);
        int somaAB = A + B;
        int somaCD = C + D;

        if ((B > C) && (D > A) && (somaCD > somaAB) && (C > 0 && D > 0) && (ehPar(A))) {
            System.out.println("Valores aceitos");
        } else {
            System.out.println("Valores nao aceitos");
        }
    }

    private static boolean ehPar(int num) {
        return (num % 2 == 0) ? true : false;
    }
}