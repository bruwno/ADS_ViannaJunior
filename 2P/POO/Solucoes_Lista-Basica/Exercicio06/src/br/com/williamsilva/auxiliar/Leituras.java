package br.com.williamsilva.auxiliar;

import java.util.Scanner;

public class Leituras {
    public static int lerOpcaoDigitada(int qtdOpcoes) {
        Scanner sc = new Scanner(System.in);
        int opcaoDigitada = 0;
        while (opcaoDigitada <= 0 || opcaoDigitada > qtdOpcoes) {
            System.out.print("|>| ");
            opcaoDigitada = sc.nextInt();
        }
        return opcaoDigitada;
    }

    public static boolean lerConverterOpcao() {
        Scanner sc = new Scanner(System.in);
        return sc.next().toUpperCase().equals("S");
    }
}
