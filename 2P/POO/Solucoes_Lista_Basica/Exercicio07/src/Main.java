/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 28/02/2024
 *
 * Exercício 7: Crie um programa para verificar se um empregado está qualificado para a
 * aposentadoria ou não. Para estar em condições, um dos seguintes requisitos deve ser
 * satisfeito:
 * - Ter no mínimo 65 anos de idade;
 * - Ter trabalhado no mínimo 30 anos.
 * - Ter no mínimo 60 anos e ter trabalhado no mínimo 25 anos.
 */

public class Main {
    public static void main(String[] args) {
        Empregado empreg = new Empregado("João da Silva", 65, 24);
        System.out.println(empreg.exibeInformacoes());
        System.out.println("Situação: " + empreg.verificaSituacaoAposentadoria());
    }
}