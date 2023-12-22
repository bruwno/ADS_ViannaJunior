/* Objetivo: Determinas se um sobrenome í difícil a partir da quantidade de consoantes consecutivas.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 22/12/2023
 * Tipo    : 3 (STRINGS)
 * ID      : 3358
 * Nome    : Sobrenome Não é Fácil
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/3358
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int qtdLeituras = readLine.nextInt();
        String[] sobrenomes = new String[qtdLeituras];

        for (int i = 0; i < sobrenomes.length; i++) {
            sobrenomes[i] = readLine.next();
        }
        readLine.close();

        verificarComplexidadeDoSobrenome(sobrenomes);
    }

    public static void verificarComplexidadeDoSobrenome(String[] sobrenomes) {
        for (int i = 0; i < sobrenomes.length; i++) {
            String sobrenome = sobrenomes[i];
            int qtdConsoantes = 0;

            for (int j = 0; j < sobrenome.length(); j++) {
                char caractere = sobrenome.charAt(j);

                if (ehConsoante(caractere) == false) {
                    qtdConsoantes = 0;
                } else {
                    qtdConsoantes++;
                    if (qtdConsoantes == 3) {
                        break;
                    }
                }
            }

            if (qtdConsoantes < 3) {
                System.out.printf("%s eh facil\n", sobrenomes[i]);
            } else {
                System.out.printf("%s nao eh facil\n", sobrenomes[i]);
            }
        }
    }

    public static boolean ehLetra(char caractere) {
        if (caractere >= 'a' && caractere <= 'z' || caractere >= 'A' && caractere <= 'Z') {
            return true;
        }
        return false;
    }

    public static boolean ehConsoante(char caractere) {
        if (ehLetra(caractere) == true && ehVogal(caractere) == false) {
            return true;
        }
        return false;
    }

    public static boolean ehVogal(char caractere) {
        final String vogais = "aeiouAEIOU";
        for (int i = 0; i < vogais.length(); i++) {
            if (vogais.charAt(i) == caractere) {
                return true;
            }
        }
        return false;
    }
}