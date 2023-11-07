/* Objetivo : Ler dados e exibir médias.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 07/11/2023
 * Material : FP09 (Classes)
 * Slide    : 21
 * Exercício: 05
 */

/* 5) Imagine que tenha sido realizada uma pesquisa com 6 pessoas a respeito de salário e idade. 
 * Crie uma classe Pessoa e faça um programa que leia os dados coletados e forneça a média salarial e a média de idades dos entrevistados.
 */

using System;

namespace LerDados
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Pessoa p1 = new Pessoa();
            Pessoa p2 = new Pessoa();
            Pessoa p3 = new Pessoa();
            Pessoa p4 = new Pessoa();
            Pessoa p5 = new Pessoa();
            Pessoa p6 = new Pessoa();

            for (int i = 1; i <= 6; i++)
            {
                Console.WriteLine($"\nPessoa {i}");
                switch (i)
                {
                    case 1:
                        p1.Salario = LerSalarioPessoa();
                        p1.Idade = LerIdadePessoa();
                        break;
                    case 2:
                        p2.Salario = LerSalarioPessoa();
                        p2.Idade = LerIdadePessoa();
                        break;
                    case 3:
                        p3.Salario = LerSalarioPessoa();
                        p3.Idade = LerIdadePessoa();
                        break;
                    case 4:
                        p4.Salario = LerSalarioPessoa();
                        p4.Idade = LerIdadePessoa();
                        break;
                    case 5:
                        p5.Salario = LerSalarioPessoa();
                        p5.Idade = LerIdadePessoa();
                        break;
                    case 6:
                        p6.Salario = LerSalarioPessoa();
                        p6.Idade = LerIdadePessoa();
                        break;
                }
            }

            double mediaSalarial = CalcularMediaSalarial(p1.Salario, p2.Salario, p3.Salario, p4.Salario, p5.Salario, p6.Salario);
            Console.WriteLine($"\nValor médio dos salários   : {mediaSalarial:C}");

            double mediaIdades = CalcularMediaDeIdades(p1.Idade, p2.Idade, p3.Idade, p4.Idade, p5.Idade, p6.Idade);
            Console.WriteLine($"\nIdade média dos pesquisados: {mediaIdades:F1}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static double LerSalarioPessoa()
        {
            Console.Write("Informe o valor do salário: ");
            double salario = Convert.ToDouble(Console.ReadLine());
            return salario;
        }

        private static double LerIdadePessoa()
        {
            Console.Write("Informe sua idade: ");
            double idade = Convert.ToDouble(Console.ReadLine());
            return idade;
        }

        private static double CalcularMediaSalarial(double p1, double p2, double p3, double p4, double p5, double p6)
        {
            double mediaSalarial = 0.0;
            return mediaSalarial = (p1 + p2 + p3 + p4 + p5 + p6) / 6.0;
        }

        private static double CalcularMediaDeIdades(double p1, double p2, double p3, double p4, double p5, double p6)
        {
            double mediaIdades = 0.0;
            return mediaIdades = (p1 + p2 + p3 + p4 + p5 + p6) / 6.0;
        }
    }
}