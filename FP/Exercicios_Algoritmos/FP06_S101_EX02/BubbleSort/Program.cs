/* Objetivo : Ordenar valores de um vetor de forma crescente.
 * Autor    : Camillo Falcão
 * Data     : 10/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 101
 * Exercício: 02
 */

/* Algoritmo de ordenação por bolha (bubble sort).
 */

using System;

namespace BubbleSort
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double[] vet = new double[5] { 11.0, 22.0, 3.0, 44.0, 5.0 };
            OrdenarValores(vet);

            for (int i = 0; i < 5; i++)
            {
                Console.Write($"{vet[i]:N2} | ");
            }

            Console.ReadKey();
        }

        private static void OrdenarValores(double[] vet)
        {
            double aux;

            for (int i = 0; i < vet.Length; i++)
            {
                for (int j = vet.Length - 1; j > i; j--)
                {
                    if (vet[j] < vet[j - 1])
                    {
                        aux = vet[j];
                        vet[j] = vet[j - 1];
                        vet[j - 1] = aux;
                    }
                }
            }
        }
    }
}