/* Objetivo : Ler valores de um vetor e imprimir apenas os valores que estiverem no índices pares.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 11/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 112
 * Exercício: 02
 */

/* 2) Faça um procedimento que faça a leitura um vetor de 10 elementos inteiros e imprima somente os valores armazenados nos índices pares.
 */

using System;

namespace LerValores
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            int[] vet = new int[10];

            Console.WriteLine("Ler 10 valores");

            for (int i = 0, j = 1; i < vet.Length; i++, j++)
            {
                Console.Write($"Digite o {j}º valor: ");
                vet[i] = Convert.ToInt32(Console.ReadLine());
            }

            ImprimirValoresNosIndicesPares(vet);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ImprimirValoresNosIndicesPares(int[] vet)
        {
            for (int i = 0; i < vet.Length; i += 2)
            {
                Console.WriteLine($"Valor: {vet[i],3} | Posição: {i,1}");
            }
        }
    }
}