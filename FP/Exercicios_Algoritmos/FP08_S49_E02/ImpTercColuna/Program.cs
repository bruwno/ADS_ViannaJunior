/* Objetivo : Imprimir a terceira coluna de uma matriz.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 25/10/2023
 * Material : FP08 (Matriz)
 * Slide    : 49
 * Exercício: 02
 */

/* 2) Faça um programa que leia uma matriz 7 x 5 e imprima a terceira coluna.
 */

using System;

namespace ImpTerColuna
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            int[,] mat = new int[7,5];

            for(int i = 0; i < mat.GetLength(0); i++)
            {
                for(int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Elemento {i},{j}: ");
                    mat[i,j] = Convert.ToInt32(Console.ReadLine());
                }
            }

            ImprimirMatriz(mat);

            Console.Write("\nPressione qualquer tecla  para finalizar...");
            Console.ReadKey();
        }

        private static void ImprimirMatriz(int[,] mat)
        {
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j< mat.GetLength(1); j++)
                {
                    if (j == 2)
                    {
                        Console.Write($"{mat[i,j]} ");
                    }
                    else
                    {
                        System.Console.Write("0 ");
                    }

                }
                Console.WriteLine();
            }
        }
    }
}