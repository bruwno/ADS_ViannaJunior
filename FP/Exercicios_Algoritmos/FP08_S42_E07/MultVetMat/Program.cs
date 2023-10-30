/* Objetivo : Multiplicar um vetor por um matriz.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 25/10/2023
 * Material : FP08 (Matrizes)
 * Slide    : 42
 * Exercício: 07
 */

/* 7) Faça um programa que leia um vetor de dimensão 5 e uma matriz quadrada de dimensão 5. 
 * Crie um procedimento que multiplique o vetor pela matriz. Imprima o resultado.
 */

using System;

namespace MultVetMat
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double[] vet = new double[5];
            double[,] mat = new double[5, 5];

            for (int i = 0; i < vet.Length; i++)
            {
                Console.Write($"Digite o {i + 1}º valor do vetor: ");
                vet[i] = Convert.ToDouble(Console.ReadLine());
            }

            for (int j = 0; j < mat.GetLength(0); j++)
            {
                for (int k = 0; k < mat.GetLength(1); k++)
                {
                    Console.Write($"Digite o elemento {j},{k} da matriz: ");
                    mat[j, k] = Convert.ToDouble(Console.ReadLine());
                }
            }

            MultiplicarVetPorMat(vet, mat);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void MultiplicarVetPorMat(double[] vet, double[,] mat)
        {
            System.Console.WriteLine("Resultado: ");
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    double resultado = vet[i] * mat[i, j];
                    Console.WriteLine($"{vet[i]} x {mat[i, j]} = {resultado}");
                }
                Console.WriteLine();
            }
        }
    }
}