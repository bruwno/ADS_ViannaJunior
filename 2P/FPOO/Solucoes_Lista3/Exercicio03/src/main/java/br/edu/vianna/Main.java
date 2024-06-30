package br.edu.vianna;

public class Main {
    public static void main(String[] args) {
        PessoaIMC homem, mulher;
        homem  = new Homem("Romildo", "02/01/1990", 80.0, 1.77);
        System.out.println(homem);
        System.out.println(homem.resultIMC());

        System.out.println();

        mulher = new Mulher("Marina", "03/09/2000", 90.5, 1.70);
        System.out.println(mulher);
        System.out.println(mulher.resultIMC());
    }
}