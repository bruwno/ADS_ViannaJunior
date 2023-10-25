/* Objetivo : Imprimir uma matriz.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 25/10/2023
 * Material : FP08 (Matriz)
 * Slide    : 41
 * Exercício: 05
 */

/* 5) Faça um procedimento que receba uma matriz quadrada 5 x 5 e crie uma matriz identidade. 
 * Imprima a matriz após sua inicialização em um outro procedimento.
 */

using System;

namespace ImprimeMatriz
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            int[,] identidade = new int[5, 5];

            ReceberMatriz(identidade);

            Console.WriteLine("\nImprimindo os valores da matriz:");
            for (int i = 0; i < identidade.GetLength(0); i++)
            {
                for (int j = 0; j < identidade.GetLength(1); j++)
                {
                    Console.Write($"{identidade[i, j]}\t");
                }
                Console.WriteLine();
            }
        }

        private static void ReceberMatriz(int[,] mat)
        {
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Elemento {i},{j}: ");
                    mat[i, j] = Convert.ToInt32(Console.ReadLine());
                }
            }
        }
    }
}


