/* Objetivo : Preencher uma matriz com 3 vetores.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/10/2023
 * Material : FP08 (Matrizes)
 * Slide    : 50
 * Exercício: 06
 */

/* 6) Faça um programa que leia 3 vetores reais de dimensão 10 e um procedimento que gere uma matriz (10 x 3)
 * onde cada coluna é dada por um destes vetores.
 */

using System;

namespace VetPreencheMat
{
    internal class Program
    {
        const int dim = 10;
        internal static void Main(string[] args)
        {
            double[] vet1 = new double[dim];
            double[] vet2 = new double[dim];
            double[] vet3 = new double[dim];
            int numVetor = 1;

            while (numVetor <= 3)
            {
                Console.WriteLine($"Vetor {numVetor}");
                for (int i = 0; i < dim; i++)
                {
                    Console.Write($"Digite o {i + 1}º valor do vetor: ");
                    switch (numVetor)
                    {
                        case 1:
                            vet1[i] = Convert.ToDouble(Console.ReadLine());
                            break;
                        case 2:
                            vet2[i] = Convert.ToDouble(Console.ReadLine());
                            break;
                        case 3:
                            vet3[i] = Convert.ToDouble(Console.ReadLine());
                            break;
                    }
                }
                Console.WriteLine();
                numVetor++;
            }

            PreencherMatriz(vet1, vet2, vet3);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void PreencherMatriz(double[] vet1, double[] vet2, double[] vet3)
        {
            double[,] mat = new double[10, 3];

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    switch (j)
                    {
                        case 0:
                            mat[i, j] = vet1[i];
                            break;
                        case 1:
                            mat[i, j] = vet2[i];
                            break;
                        case 2:
                            mat[i, j] = vet3[i];
                            break;
                    }
                }
            }

            Console.WriteLine("\nImpressão da matriz");
            for (int k = 0; k < mat.GetLength(0); k++)
            {
                for (int l = 0; l < mat.GetLength(1); l++)
                {
                    Console.Write($"{mat[k, l]} ");
                }
                Console.WriteLine();
            }
        }
    }
}