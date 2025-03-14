/* Objetivo: Determinar de quantas maneiras uma senha pode ser formada.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 03/02/2024
 * Tipo    : 3 (STRINGS)
 * ID      : 1632
 * Nome    : Variações
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1632
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> resultados = new ArrayList<>();
        Scanner readLine = new Scanner(System.in);
        int t = Integer.parseInt(readLine.nextLine());

        for (int i = 0; i < t; i++) {
            String s = readLine.nextLine();
            resultados.add(retornaQtdPossibilidades(s));
        }
        readLine.close();

        for (int resultado : resultados) {
            System.out.println(resultado);
        }
    }

    private static int retornaQtdPossibilidades(String str) {
        int qtdPossib = 1;

        for (int i = 0; i < str.length(); i++) {
            char caractere = str.charAt(i);

            if (verificaCaractere(caractere)) {
                qtdPossib *= 3;
            } else {
                qtdPossib *= 2;
            }
        }
        return qtdPossib;
    }

    private static boolean verificaCaractere(char caractere) {
        final String conjuntoDeCaracteres = "AEIOSaeios";

        for (int i = 0; i < conjuntoDeCaracteres.length(); i++) {
            if (caractere == conjuntoDeCaracteres.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}