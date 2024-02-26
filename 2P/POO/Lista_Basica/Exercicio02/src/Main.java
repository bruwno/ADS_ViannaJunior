/*
 * Objetivo: Imprimir um intervalo entre dois números.
 * Autor   : William Silva (https://gitlab.com/unclWill)
 * Data    : 26/02/2024
 *
 * 2) Escreva um programa que carregue dois valores A e B pelo teclado e imprima todos
 * os números ímpares entre A e B.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor inicial (A): ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.print("Digite o valor final   (B): ");
        int b = Integer.parseInt(scanner.nextLine());

        NumerosImpares intervaloDeImpares = new NumerosImpares(a, b);
        ArrayList<Integer> listaDeImpares =  intervaloDeImpares.retornaListaDeImpares();

        for (int numImpar : listaDeImpares) {
            System.out.print(numImpar + " ");
        }

        scanner.close();
    }
}