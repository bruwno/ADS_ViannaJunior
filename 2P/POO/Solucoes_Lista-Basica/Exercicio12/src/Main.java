/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 19/03/2024
 *
 * Exercício 12 - Crie um programa que determine se uma pessoa possui uma idade superior a 17 anos.
 * O usuário deverá informar o nome, ano de nascimento e email da pessoa. Faça uso da classe acima.
 */

public class Main {
    public static void main(String[] args) {
        Data data = new Data(13,4,2006);
        Pessoa p = new Pessoa();

        p.setNome("Serginho");
        p.setAnoNascimento(data);
        p.setEmail("serginho2009@hotmail.com.br");

        int idade = p.verificarIdade();

        if (idade > 17) {
            System.out.printf("%s tem mais de 17 anos.", p.getNome());
        } else if (idade == 17) {
            System.out.printf("%s tem exatamente 17 anos.", p.getNome());
        } else {
            System.out.printf("%s tem menos de 17 anos.", p.getNome());
        }
    }
}