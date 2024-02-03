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

        int n = readLine.nextInt();
        for (int i = 0; i < n; i++) {

            int k = readLine.nextInt();
            readLine.nextLine();

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

    public static String determinaIdiomaDaConversa(String[] idiomasFalados) {
        String determinarIdioma = null;
        String idiomaBase = null;
        int qtdIdiomasIguais = 0, qtdIdiomasDiferentes = 0;

        for (int i = 0; i < idiomasFalados.length; i++) {
            idiomaBase = idiomasFalados[0];
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