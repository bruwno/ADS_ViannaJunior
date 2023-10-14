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

            for (int i = 0, j = 1; i < vet.Length; i++, j++)
            {
                Console.Write($"Digite o {j}º elemento de {n}: ");
                vet[i] = Convert.ToInt32(Console.ReadLine());
            }

            OrdenarValores(vet);

            for (int i = 0; i < vet.Length; i++)
            {
                Console.Write(vet[i] + " ");
            }

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void OrdenarValores(int[] vet)
        {
            int aux = 0;

            for (int i = vet.Length - 1; i > 0; i--)
            {
                int alt = 0;

                for (int j = 0; j < i; j++)
                {
                    int valorAtual = vet[j], proxValor = vet[j + 1];

                    if (valorAtual > proxValor)
                    {
                        aux = vet[j];
                        vet[j] = vet[j + 1];
                        vet[j + 1] = aux;
                        // Contador de alterações. Evita que o array, uma vez ordenado, seja percorrido pelo laço externo.
                        alt++;
                    }
                }

                if (alt == 0)
                {
                    break;
                }
            }
        }
    }
}