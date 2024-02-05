/* Objetivo: Calcular o gasto de combustível com base no tempo de viagem e na velocidade média do automóvel.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 05/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1017
 * Nome    : Gasto de Combustível
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1017
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner readLine = new Scanner(System.in);
        int tempoGasto = Integer.parseInt(readLine.nextLine());
        int velocidadeMedia = Integer.parseInt(readLine.nextLine());
        readLine.close();
        double resultado = (tempoGasto * velocidadeMedia) / 12.0;
        System.out.printf("%.3f\n", resultado);
    }
}