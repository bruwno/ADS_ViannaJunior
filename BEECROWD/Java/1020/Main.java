/* Objetivo: Converter uma entrada de idade em dias para anos, meses e dias.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 07/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1020
 * Nome    : Idade em Dias
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1020
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int idadeEmDias = Integer.parseInt(readLine.nextLine());
        converteIdade(idadeEmDias);
        readLine.close();
    }

    private static void converteIdade(int idadeEmDias) {
        int diasRestantes, anos, meses, dias;
        anos = idadeEmDias / 365;
        diasRestantes = idadeEmDias % 365;
        meses = diasRestantes / 30;
        dias = diasRestantes % 30;
        System.out.printf("%d ano(s)\n%d mes(es)\n%d dia(s)\n", anos, meses, dias);
    }
}