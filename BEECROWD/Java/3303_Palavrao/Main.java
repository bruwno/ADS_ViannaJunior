/* Objetivo: Contar a quantidade de letras em uma palavra e definir se a mesma é "palavrão" ou "palavrinha".
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 21/12/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 3303
 * Nome    : Palavrão
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/3303
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        String palavra = readLine.nextLine();
        determinarPalavra(palavra);
        readLine.close();
    }

    public static void determinarPalavra(String palavra) {
        int qtdCaracteres = 0;
        for (int i = 0; i < palavra.length(); i++) {
            qtdCaracteres++;
        }

        if (qtdCaracteres >= 10) {
            System.out.println("palavrao");
        } else {
            System.out.println("palavrinha");
        }
    }
}