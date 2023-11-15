/* Objetivo : Determinar o menor valor contido em um vetor.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 11/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 104
 * Exercício: 08
 */

/* 8) Refaça o exercício anterior criando um procedimento que receba como parâmetro o vetor 
 * e imprima o menor valor e seu índice no vetor.
 */

using System;

namespace DetMenorValor
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.WriteLine("Determinar o menor valor");
            int[] vet = new int[20];

            for (int i = 0, j = 1; i < 20; i++, j++)
            {
                Console.Write($"Digite o {j}º valor: ");
                vet[i] = Convert.ToInt32(Console.ReadLine());
            }

            DeterminarMenorValor(vet);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void DeterminarMenorValor(int[] vet)
        {
            int posic = 0, menorValor = int.MaxValue;

            for (int i = 0; i < vet.Length; i++)
            {
                if (vet[i] < menorValor)
                {
                    menorValor = vet[i];
                    posic = i;
                }
            }

            Console.WriteLine($"O menor valor digitado foi {menorValor}, seu índice no vetor é: {posic}.");
        }
    }
}