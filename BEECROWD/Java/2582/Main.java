/*
 * Objetivo: Ler dois valores de entrada e retornar a música correspondente à soma desses valores.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 31/01/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 2582
 * Nome    : System of a Download
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2582
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int c = readLine.nextInt();
        String[] xy = new String[c];
        int[] armazenaSomas = new int[c];
        readLine.nextLine();

        for (int i = 0; i < c; i++) {
            int soma = 0;

            xy = readLine.nextLine().trim().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            soma = x + y;
            armazenaSomas[i] = soma;
        }
        exibeMusica(armazenaSomas);
    }

    private static void exibeMusica(int[] somasArmazenadas) {
        ArrayList<String> musicas = new ArrayList<>();

        for (int i = 0; i < somasArmazenadas.length; i++) {
            musicas.add(retornaMusica(somasArmazenadas[i]));
        }

        for (String musica : musicas) {
            System.out.println(musica);
        }
    }

    private static String retornaMusica(int num) {
        Map<Integer, String> musicas = new HashMap<>();
        musicas.put(0, "PROXYCITY");
        musicas.put(1, "P.Y.N.G.");
        musicas.put(2, "DNSUEY!");
        musicas.put(3, "SERVERS");
        musicas.put(4, "HOST!");
        musicas.put(5, "CRIPTONIZE");
        musicas.put(6, "OFFLINE DAY");
        musicas.put(7, "SALT");
        musicas.put(8, "ANSWER!");
        musicas.put(9, "RAR?");
        musicas.put(10, "WIFI ANTENNAS");

        return musicas.get(num);
    }
}