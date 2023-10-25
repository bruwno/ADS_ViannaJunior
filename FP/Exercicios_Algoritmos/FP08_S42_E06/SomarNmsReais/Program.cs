/* Objetivo : Somar os elementos de uma matriz utilizando uma função.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 25/10/2023
 * Material : FP08 (Matriz)
 * Slide    : 42
 * Exercício: 06
 */

/* 6) Crie uma função que receba uma matriz de números reais e retorne a soma dos elementos desta matriz.
 */

using System;

namespace SomarNmsReais
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double[,] mat = new double[3, 3];
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Elemento {i},{j}: ");
                    mat[i, j] = Convert.ToDouble(Console.ReadLine());
                }
            }


            Console.WriteLine($"Soma dos elementos = {RetornaSoma(mat)}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static double RetornaSoma(double[,] mat)
        {
            double soma = 0;

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    soma += mat[i, j];
                }
            }

            return soma;
        }
    }
}