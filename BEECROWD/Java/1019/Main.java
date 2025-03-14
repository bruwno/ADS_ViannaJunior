/* Objetivo: Converter uma entrada de tempo em segundos para horas, minutos e segundos.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 07/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1019
 * Nome    : Conversão de Tempo
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1019
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int tempoEmSegundos = Integer.parseInt(readLine.nextLine());
        converteTempo(tempoEmSegundos);
        readLine.close();
    }

    private static void converteTempo(int tempoEmSegundos) {
        int tempoRestante, horas, minutos, segundos;
        horas = tempoEmSegundos / 3600;
        tempoRestante = tempoEmSegundos % 3600;
        minutos = tempoRestante / 60;
        segundos = tempoRestante % 60;
        System.out.printf("%d:%d:%d\n", horas, minutos, segundos);
    }
}