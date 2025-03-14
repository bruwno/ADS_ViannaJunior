/*
 * Objetivo: Verificar quem vence a batalha dos cinco exércitos de acordo com a quantidade de tropas.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 31/01/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 3147
 * Nome    : A Batalha dos Cinco Exércitos
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/3147
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        String[] entrada = readLine.nextLine().trim().split(" ");
        int[] exercitos = Arrays.stream(entrada).mapToInt(Integer::parseInt).toArray();
        int exercitosBem = retornaQtdExercitosDoBem(exercitos[0], exercitos[1], exercitos[2], exercitos[5]);
        int exercitosMal = retornaQtdExercitosDoMal(exercitos[3], exercitos[4]);

        if (exercitosBem >= exercitosMal) {
            System.out.println("Middle-earth is safe.");
        } else {
            System.out.println("Sauron has returned.");
        }
        readLine.close();
    }

    private static int retornaQtdExercitosDoBem(int h, int e, int a, int x) {
        int resultado = h + e + a + x;
        return resultado;
    }

    private static int retornaQtdExercitosDoMal(int o, int w) {
        int resultado = o + w;
        return resultado;
    }
}