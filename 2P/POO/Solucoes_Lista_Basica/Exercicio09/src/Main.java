/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 29/02/2024
 *
 * Exercício 09) Faça uma programa que leia um valor a ser pego emprestado, uma taxa de juros
 * (em porcentagem) mensal e um período em meses, informe as seguintes
 * informações:
 * a) Valor da mensalidade
 * b) Valor total pago, ao final do empréstimo
 * c) Total pago de juros.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Valor do empréstimo: ");
        double valorEmprestimo = Double.parseDouble(scanner.nextLine());
        System.out.print("Taxa de juros      : ");
        double taxaDeJuros = Double.parseDouble(scanner.nextLine());
        System.out.print("Prazo de pagamento : ");
        int periodoEmMeses = Integer.parseInt(scanner.nextLine());

        Emprestimo emprestimo = new Emprestimo(valorEmprestimo, taxaDeJuros, periodoEmMeses);
        System.out.println(String.format("Mensalidade   : R$ %.2f", emprestimo.calculaValorMensalidade()));
        System.out.println(String.format("Total pago    : R$ %.2f", emprestimo.calculaValorTotalPago()));
        System.out.println(String.format("Total em juros: R$ %.2f", emprestimo.calculaValorTotalEmJuros()));

        scanner.close();
    }
}