/*
 * Autor   : William Silva (https://gitlab.com/unclWill)
 * Data    : 26/02/2024
 *
 * Exercício 2
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor inicial (A): ");
        int a = Integer.parseInt(sc.nextLine());
        System.out.print("Digite o valor final   (B): ");
        int b = Integer.parseInt(sc.nextLine());

        NumerosImpares intervaloDeImpares = new NumerosImpares(a, b);
        ArrayList<Integer> listaDeImpares =  intervaloDeImpares.retornaListaDeImpares();

        System.out.println("Números ímpares neste intervalo: ");
        for (int numImpar : listaDeImpares) {
            System.out.print(numImpar + " ");
        }
        sc.close();
    }
}