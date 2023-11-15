/* Objetivo : Somar duas matrizes quadradas.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 24/10/2023
 * Material : FP08 (Matrizes)
 * Slide    : 41
 * Exercício: 03
 */

/* 3) Faça um programa para exibir a soma de duas matrizes quadradas 3 x 3. 
 * Deverá ser criado um procedimento para ler uma matriz (será chamado duas vezes com parâmetros diferentes) 
 * e um segundo procedimento que irá imprimir a soma das matrizes passadas como parâmetro.
 */

using System;

namespace SomarMatriz
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            int[,] mat1 = new int[3, 3];
            int[,] mat2 = new int[3, 3];

            Console.WriteLine("Informe os valores para a 1ª matriz");
            LerMatriz(mat1);
            Console.WriteLine("Informe os valores para a 2ª matriz");
            LerMatriz(mat2);
            Somar(mat1, mat2);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerMatriz(int[,] mat)
        {
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Elemento {i},{j}: ");
                    mat[i, j] = Convert.ToInt32(Console.ReadLine());
                }
                // Quebra de linha.
                Console.WriteLine();
            }
        }

        private static void Somar(int[,] m1, int[,] m2)
        {
            Console.WriteLine("Resultados: ");

            for (int i = 0; i < m1.GetLength(0); i++)
            {
                for (int j = 0; j < m1.GetLength(1); j++)
                {
                    Console.Write($"{m1[i, j] + m2[i, j]}\t");
                }
                Console.WriteLine("");
            }
        }
    }
}