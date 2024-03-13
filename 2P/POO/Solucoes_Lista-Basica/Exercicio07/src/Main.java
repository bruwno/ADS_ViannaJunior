/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 28/02/2024
 *
 */

public class Main {
    public static void main(String[] args) {
        Empregado empreg = new Empregado("João da Silva", 60, 30);
        
        System.out.println(empreg.exibeInformacoes());

        System.out.print("Situação: ");
        if (empreg.verificaSituacaoAposentadoria()) {
            System.out.println("Está qualificado para aposentadoria");
        } else {
            System.out.println("Ainda não pode se aposentar");
        }
    }
}