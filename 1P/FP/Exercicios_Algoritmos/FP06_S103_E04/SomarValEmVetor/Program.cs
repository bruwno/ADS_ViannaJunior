/* Objetivo : Somar os valores de dois vetores.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 10/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 103
 * Exercício: 04
 */

/* 4) Faça um algoritmo para ler e somar dois vetores de 10 elementos inteiros.
 * Imprima ao final os valores dessa soma, elemento a elemento.
 */

using System;

namespace SomarValEmVetor
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            int i, j, resultado;
            int[] vet1 = new int[] { 1, 2, 1, 3, 10, 5, 11, 8, 45, 6, 15 };
            int[] vet2 = new int[] { 2, 1, 4, 3, 5, 3, 11, 20, 45, 4, 12 };

            for (i = 0; i < vet1.Length; i++)
            {
                resultado = vet1[i] + vet2[i];
                Console.WriteLine($"Resultado de {vet1[i],2} + {vet2[i],2} = {resultado,3}");
            }

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }
    }
}