/*
 * Objetivo: Somar valores e, se existirem, remover os zeros dos resultados.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 31/01/2024
 * Tipo    : 3 (STRINGS)
 * ID      : 1871
 * Nome    : Zero vale Zero
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1871
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        ArrayList<String> armazenaSomas = new ArrayList<>();

        do {
            int i = 0, soma = 0;

            String[] entrada = readLine.nextLine().trim().split(" ");

            if (entrada[i].equals("0") && entrada[i + 1].equals("0")) {
                break;
            } else {
                soma = Integer.parseInt(entrada[i]) + Integer.parseInt(entrada[i + 1]);
                armazenaSomas.add(Integer.toString(soma));
            }
            i++;
        } while (true);

        removeZeros(armazenaSomas);
        readLine.close();
    }

    private static void removeZeros(ArrayList<String> nums) {
        String novoValor = null;

        for (String num : nums) {
            if (num.contains("0")) {
                novoValor = num.replace("0", "");
                System.out.println(novoValor);
            } else {
                novoValor = num;
                System.out.println(novoValor);
            }
        }
    }
}