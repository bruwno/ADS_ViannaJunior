/* Objetivo : Ler números inteiros e retornar a média aritmética.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 24/09/2023
 * Material : FP0X
 * Slide    : EXRS (Exercícios Resolvidos)
 * Exercício: 05
 */

/* Comando:
 * 5) Faça uma função que receba por parâmetro um inteiro N, leia N números inteiros e retorne a média aritmética dos números positivos lidos. 
 * No método principal (Main), peça para o usuário informar quantos números ele deseja ler, passe essa informação por parâmetro para a função criada e imprima o retorno
 * da função com 3 casas decimais.
 */

using System;

namespace LerNums
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("Digite a quantidade de números que deseja ler: ");
            int qtdLeituras = Convert.ToInt32(Console.ReadLine());

            double media = LerNumsECalcularMedia(qtdLeituras);
            Console.WriteLine($"A média aritmética dos números lidos é = {media:F3}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static double LerNumsECalcularMedia(int qtdLeituras)
        {
            double media = 0.0, acm = 0.0;

            Console.Write("Digite um número positivo: ");
            double num = Convert.ToDouble(Console.ReadLine());

            for (int i = 1; i < qtdLeituras; i++)
            {
                if (num > 0)
                {
                    Console.Write("Digite um número positivo: ");
                    num = Convert.ToDouble(Console.ReadLine());

                    acm += num;
                }
                else
                {
                    Console.WriteLine("Número negativo desconsiderado.");
                }
            }

            media = acm / qtdLeituras;

            return media;
        }
    }
}