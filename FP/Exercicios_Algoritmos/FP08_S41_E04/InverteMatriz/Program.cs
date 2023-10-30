/* Objetivo : Inverter linhas e colunas.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 24/10/2023
 * Material : FP08 (Matrizes)
 * Slide    : 41
 * Exercício: 04
 */

/* 4) Faça um programa que leia uma matriz quadrada de tamanho 10 e um procedimento que inverta as linhas pelas 
 * colunas em uma segunda matriz de mesmo tamanho. Imprima ao final a segunda matriz.
 */

using System;

namespace InverteMatriz
{
    internal class Program
    {
        const int dim = 10;
        internal static void Main(string[] args)
        {
            double[,] mat = new double[dim, dim];

            Console.WriteLine("Informe os valores da matriz:");
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Elemento {i},{j}: ");
                    mat[i, j] = Convert.ToDouble(Console.ReadLine());
                }
            }

            InverterMatriz(mat);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void InverterMatriz(double[,] mat)
        {
            double[,] matInvert = new double[dim, dim];

            for (int i = 0; i < matInvert.GetLength(0); i++)
            {
                for (int j = 0; j < matInvert.GetLength(1); j++)
                {
                    matInvert[j, i] = mat[i, j];
                }
            }

            Console.WriteLine("\nImprimindo os valores (col|lin):");
            for (int k = 0; k < matInvert.GetLength(0); k++)
            {
                for (int l = 0; l < matInvert.GetLength(1); l++)
                {
                    Console.Write($"{matInvert[k, l]} ");
                }
                Console.WriteLine();
            }
        }
    }
}