/* Objetivo: Cifrar mensagem.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 24/08/2024
 * Tipo    : 3 (STRINGS)
 * ID      : 1024
 * Nome    : Criptografia
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1024
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int qtdTestes = Integer.parseInt(sc.nextLine());

        List<String> senhas = new ArrayList<>();
        for (int i = 0; i < qtdTestes; i++) {
            senhas.add(sc.nextLine());
        }

        List<String> encriptado = senhas.stream()
                .map(Main::deslocarCaracteres)
                .map(Main::inverterString)
                .map(Main::truncarString)
                .collect(Collectors.toList());

        encriptado.stream().forEach(System.out::println);

        sc.close();
    }

    private static String deslocarCaracteres(String str) {
        StringBuilder strBuilder = new StringBuilder();
    
        for (int i = 0; i < str.length(); i++) {
            char caractere = str.charAt(i);

            if ((caractere >= 'a' && caractere <= 'z') || (caractere >= 'A' && caractere <= 'Z')) {
                strBuilder.append((char) (caractere + 3));
            } else {
                strBuilder.append(caractere);
            }
        }
        
        return strBuilder.toString();
    }
    
    private static String inverterString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static String truncarString(String str) {
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i >= str.length() / 2) {
                strBuilder.append((char) (str.charAt(i) - 1));
            } else {
                strBuilder.append(str.charAt(i));
            }
        }

        return strBuilder.toString();
    }
}