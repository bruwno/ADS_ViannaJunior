/* Objetivo : Ordenar um vetor de valores inteiros.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 14/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 114
 * Exercício: 10
 */

/* 10) Faça um programa que leia um vetor de valores inteiros e imprima-o na ordem crescente.
 * O vetor deve ter tamanho N (declare e utilize uma constante N).
 */

using System;

namespace OrdenarVet
{
    internal class Program
    {
        const int n = 5;

        internal static void Main(string[] args)
        {
            int[] vet = new int[n] { 40, 10, 15, 5, 28 };

            /*for (int i = 0, j = 1; i < vet.Length; i++, j++)
            {
                Console.Write($"Digite o {j}º elemento de {n}: ");
                vet[i] = Convert.ToInt32(Console.ReadLine());
            }*/

            OrdenarValores(vet);

            for (int i = 0; i < vet.Length; i++)
            {
                System.Console.Write(vet[i] + " ");
            }

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void OrdenarValores(int[] vet)
        {
            int aux;
            int[] vetOrd = new int[n];

            for (int i = 0; i < vet.Length; i++)
            {
                for (int j = vet.Length - 1; j > i; j--)
                {
                    int valorAtual = vet[j], antecessor = vet[j - 1];

                    if (valorAtual < antecessor)
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