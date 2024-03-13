/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 26/02/2024
 *
 * Exercício 3
 */

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro1, cachorro2, cachorro3;

        cachorro1 = new Cachorro("Johnny Walker", 13, "Bull terrier");
        System.out.println(cachorro1.exibeInformacoes());

        cachorro2 = new Cachorro("Beethoven", 10, "São-bernardo");
        System.out.println(cachorro2.exibeInformacoes());

        cachorro3 = new Cachorro("Frank", 12, "Pug");
        System.out.println(cachorro3.exibeInformacoes());
    }
}