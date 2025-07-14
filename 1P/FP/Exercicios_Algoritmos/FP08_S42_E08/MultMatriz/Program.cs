/* Objetivo : Multiplicar duas matrizes.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 25/10/2023
 * Material : FP08 (Matrizes)
 * Slide    : 42
 * Exercício: 08
 */

/* 8) Faça um programa que leia duas matrizes quadradas de dimensão 3. 
 * Crie um procedimento que multiplique as duas matrizes. Imprima o resultado.
 */

using System;

namespace MultMatriz
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double[,] mat1 = new double[3, 3];
            double[,] mat2 = new double[3, 3];

            Console.WriteLine("\nInforme os elementos da 1ª matriz:");
            for (int i = 0; i < mat1.GetLength(0); i++)
            {
                for (int j = 0; j < mat1.GetLength(1); j++)
                {
                    Console.Write($"Digite o elemento {i},{j}: ");
                    mat1[i, j] = Convert.ToDouble(Console.ReadLine());
                }
            }

            Console.WriteLine("\nInforme os elementos da 2ª matriz:");
            for (int k = 0; k < mat1.GetLength(0); k++)
            {
                for (int l = 0; l < mat1.GetLength(1); l++)
                {
                    Console.Write($"Digite o elemento {k},{l}: ");
                    mat2[k, l] = Convert.ToDouble(Console.ReadLine());
                }
            }

            Multiplicar(mat1, mat2);

            Console.WriteLine("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void Multiplicar(double[,] mat1, double[,] mat2)
        {
            for (int i = 0; i < mat1.GetLength(0); i++)
            {
                for (int j = 0; j < mat1.GetLength(1); j++)
                {
                    double resultado = mat1[i, j] * mat2[i, j];
                    Console.Write($"{mat1[i, j]} x {mat2[i, j]} = {resultado}\n");
                }
                Console.WriteLine();
            }
        }
    }
}