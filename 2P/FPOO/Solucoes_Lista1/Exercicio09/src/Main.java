/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 29/02/2024
 *
 * Exercício 09) Faça uma programa que leia um valor a ser pego emprestado, uma taxa de juros
 * (em porcentagem) mensal e um período em meses, informe as seguintes informações:
 * a) Valor da mensalidade
 * b) Valor total pago, ao final do empréstimo
 * c) Total pago de juros.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Emprestimo emprestimo = retornarDadosEmprestimo();
        exibeSimulacaoEmprestimo(emprestimo);
    }

    public static Emprestimo retornarDadosEmprestimo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe os dados do empréstimo");
        System.out.print("Valor do empréstimo (R$): ");
        double valorEmprestimo = Double.parseDouble(sc.nextLine());
        System.out.print("Taxa de juros (%): ");
        double taxaDeJuros = Double.parseDouble(sc.nextLine());
        System.out.print("Prazo de pagamento (meses): ");
        int periodoEmMeses = Integer.parseInt(sc.nextLine());
        sc.close();
        return new Emprestimo(valorEmprestimo, taxaDeJuros, periodoEmMeses);
    }

    public static void exibeSimulacaoEmprestimo(Emprestimo emprestimo) {
        System.out.println("\nInformações do empréstimo");
        System.out.printf("Mensalidade   : R$ %.2f%n", emprestimo.calculaValorMensalidade());
        System.out.printf("Total pago    : R$ %.2f%n", emprestimo.calculaValorTotalPago());
        System.out.printf("Total em juros: R$ %.2f%n", emprestimo.calculaValorTotalEmJuros());
    }
}