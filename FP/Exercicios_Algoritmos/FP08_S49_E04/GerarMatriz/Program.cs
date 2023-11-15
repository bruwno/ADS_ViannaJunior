/* Objetivo : Transformar uma matriz 6x3 em duas matrizes 3x3.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 25/10/2023
 * Material : FP08 (Matrizes)
 * Slide    : 49
 * Exercício: 04
 */

/* 4) Faça um programa que leia uma matriz 6 x 3 e um procedimento que gere duas matrizes 3 x 3, 
 * a primeira com as 3 primeiras linhas e a outra com as restantes.
 */

using System;

namespace GerarMatriz
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double[,] mat = new double[6, 3];

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Elemento {i},{j}: ");
                    mat[i, j] = Convert.ToDouble(Console.ReadLine());
                }
            }

            GerarMatriz(mat);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void GerarMatriz(double[,] mat)
        {
            double[,] mat1 = new double[3, 3];
            double[,] mat2 = new double[3, 3];

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    if (i < 3)
                    {
                        mat1[i, j] = mat[i, j];
                    }
                    else
                    {
                        mat2[i - mat1.GetLength(0), j] = mat[i, j]; // GetLength(0) vale 3.
                    }
                }
            }

            Console.WriteLine("Matriz 1");
            for (int k = 0; k < mat1.GetLength(0); k++)
            {
                for (int l = 0; l < mat1.GetLength(1); l++)
                {
                    Console.Write($"{mat1[k, l]} ");
                }
                Console.WriteLine();
            }

            Console.WriteLine("\nMatriz 2");
            for (int m = 0; m < mat2.GetLength(0); m++)
            {
                for (int n = 0; n < mat2.GetLength(1); n++)
                {
                    Console.Write($"{mat2[m, n]} ");
                }
                Console.WriteLine();
            }
        }
    }
}