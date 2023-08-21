/* Objetivo : Calcular a quantidade de salários mínimos que uma pessoa ganha baseado no valor que ela recebe.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 15/08/2023
 * Material : FP02
 * Slide    : 47
 * Exercício: 02
 */

/* Comando:
 * 2. Faça um programa que lê um valor de salário
 * mínimo e o salário de um funcionário. O programa
 * deve calcular e imprimir quantos salários mínimos
 * esse funcionário ganha.
 */

using System;

namespace CalcularSalario
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Verificar quantos salários mínimos recebo\n");
            ObterDados();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterDados()
        {
            double qtdSalarios = 0.0d;
            Console.Write("[i] Informe o valor do salário mínimo atual: ");
            double salarioMinimo = Convert.ToDouble(Console.ReadLine().Replace(',', '.'));
            Console.Write("[i] Informe o valor do seu salário: ");
            double salarioFuncionario = Convert.ToDouble(Console.ReadLine().Replace(',', '.'));

            qtdSalarios = CalcularSalario(salarioMinimo, salarioFuncionario);
            Console.WriteLine($"\n[>] Com base no salário mínimo informado, você recebe {qtdSalarios:N1} salário(s) mínimo(s).");
        }

        private static double CalcularSalario(double valorSalarioMinimo, double valorSalarioFuncionario)
        {
            return valorSalarioFuncionario / valorSalarioMinimo;
        }
    }
}