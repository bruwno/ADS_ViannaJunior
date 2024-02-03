/* Objetivo: Definir o qual idioma deve ser falado em uma conversa entre pessoas de diferentes nacionalidades.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 02/02/2024
 * Tipo    : 3 (STRINGS)
 * ID      : 1581
 * Nome    : Conversa Internacional
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1581
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        ArrayList<String> resultados = new ArrayList<>();
        int n = Integer.parseInt(readLine.nextLine());

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(readLine.nextLine());
            String[] conversas = new String[k];

            for (int j = 0; j < k; j++) {
                conversas[j] = readLine.nextLine();
            }
            resultados.add(determinaIdiomaDaConversa(conversas));
        }
        readLine.close();

        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }

    private static String determinaIdiomaDaConversa(String[] idiomasFalados) {
        String determinarIdioma = null, idiomaBase = null;
        int qtdIdiomasIguais = 0, qtdIdiomasDiferentes = 0;

        for (int i = 0; i < idiomasFalados.length; i++) {
            idiomaBase = idiomasFalados[0];

            if (qtdIdiomasDiferentes > 1) {
                break;
            }

            if (idiomaBase.equals(idiomasFalados[i])) {
                qtdIdiomasIguais++;
            } else {
                qtdIdiomasDiferentes++;
            }
        }

        if (qtdIdiomasDiferentes >= 1) {
            determinarIdioma = "ingles";
        } else {
            determinarIdioma = idiomaBase;
        }

        return determinarIdioma;
    }
}