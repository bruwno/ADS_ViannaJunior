/* Objetivo : Separar valores ímpares e pares em dois vetores distintos.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 11/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 113
 * Exercício: 07
 */

/* 7) Faça um programa que leia um conjunto de 20 valores e armazene-os num vetor V. 
 * Particione-o em dois outros vetores, P e I, conforme os valores de V forem pares ou ímpares. 
 * No final, imprima os valores dos 3 vetores.
*/

using System;

namespace SepararImparPar
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            int[] v = new int[20] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

            Console.WriteLine("");

            DeterminarImparPar(v);

            Console.Write("\n\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void DeterminarImparPar(int[] vet)
        {
            int[] i = new int[20];
            int[] p = new int[20];

            for (int j = 0; j < vet.Length; j++)
            {
                if (vet[j] % 2 == 0)
                {
                    p[j] = vet[j];
                }
                else if (vet[j] % 2 == 1)
                {
                    i[j] = vet[j];
                }
            }

            Console.WriteLine("\nVetor v:");
            for (int j = 0; j < vet.Length; j++)
            {
                Console.Write($"{vet[j]} | ");
            }

            Console.WriteLine("\nPares:");
            for (int k = 0; k < p.Length; k++)
            {
                if (p[k] != 0)
                {
                    Console.Write($"{p[k]} | ");
                }
            }

            Console.WriteLine("\nÍmpares:");
            for (int l = 0; l < i.Length; l++)
            {
                if (i[l] != 0)
                {
                    Console.Write($"{i[l]} | ");
                }
            }
        }
    }
}