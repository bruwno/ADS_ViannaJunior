/* Objetivo : Determinar o menor valor dentro de um vetor de 15 elementos e exibir o seu índice.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 11/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 112
 * Exercício: 03
 */

/* 3) Faça um programa que leia um vetor com 15 valores reais. 
 * A seguir, encontre o menor elemento do vetor e a sua posição dentro do vetor, mostrando: "O menor elemento do vetor está na posição XXXX e tem o valor YYYYY."
 */

using System;

namespace DetMenorElem
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double[] vet = new double[15];

            Console.WriteLine("Ler 15 valores");

            for (int i = 0, j = 1; i < vet.Length; i++, j++)
            {
                Console.Write($"Digite o {j}º valor: ");
                vet[i] = Convert.ToDouble(Console.ReadLine());
            }

            Console.WriteLine(DeterminarMenorValor(vet));

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static string DeterminarMenorValor(double[] vet)
        {
            double menorValor = double.MaxValue;
            int posic = 0;

            for (int i = 0; i < vet.Length; i++)
            {
                if (vet[i] < menorValor)
                {
                    menorValor = vet[i];
                    posic = i;
                }
            }

            return $"O menor elemento do vetor está na posição {posic} e tem o valor {menorValor}";
        }
    }
}