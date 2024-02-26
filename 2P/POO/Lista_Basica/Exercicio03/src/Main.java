/*
 * Objetivo: Imprimir informações sobre cachorros.
 * Autor   : William Silva (https://gitlab.com/unclWill)
 * Data    : 26/02/2024
 *
 * 2) Crie uma classe chamada "Cachorro" que represente um cachorro. Esta classe deve
 * ter os seguintes atributos: nome (String), idade (int) e raça (String). Em seguida, crie
 * um programa principal que instancia objetos da classe "Cachorro" e exibe algumas
 * informações sobre eles.
 */

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro1, cachorro2, cachorro3;

        cachorro1 = new Cachorro("Johnny Walker", 13, "Bull terrier" + "\n");
        System.out.println(cachorro1.exibeInformacoes());

        cachorro2 = new Cachorro("Beethoven", 10, "São-bernardo" + "\n");
        System.out.println(cachorro2.exibeInformacoes());

        cachorro3 = new Cachorro("Frank", 12, "Pug");
        System.out.println(cachorro3.exibeInformacoes() + "\n");

    }
}