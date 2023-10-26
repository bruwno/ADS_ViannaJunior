/* Objetivo : Encontrar o maior e o menor valor de um matriz.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 25/10/2023
 * Material : FP08 (Matriz)
 * Slide    : 49
 * Exercício: 03
 */

/* 3) Faça um programa que leia uma matriz quadrada de dimensão 10, uma função que encontre o maior valor desta 
 * matriz e uma função que encontre o menor valor. Imprima os valores encontrados na função principal.
 */

using System;

namespace EncontMaiorMenor
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double[,] mat = new double[10,10];

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Elemento {i},{j}: ");
                    mat[i,j] = Convert.ToInt32(Console.ReadLine());
                }
            }

            double maiorValor = EncontrarMaiorValor(mat);
            double menorValor = EncontrarMenorValor(mat);

            Console.Write($"O maior valor da matriz é = {maiorValor}\n", Console.ForegroundColor = ConsoleColor.DarkRed);
            Console.Write($"O menor valor da matriz é = {menorValor}\n", Console.ForegroundColor = ConsoleColor.Blue);

            Console.Write($"\nPressione qualquer tecla para finalizar...", Console.ForegroundColor = ConsoleColor.Gray);
            Console.ReadKey();
        }

        private static double EncontrarMaiorValor(double[,] mat)
        {
            double maiorValor = double.MinValue;

            for (int i = 0; i < mat.GetLength(0); i++) 
            {
                for(int j = 0; j < mat.GetLength(1); j++)
                {
                    if (mat[i,j] > maiorValor) 
                    {
                        maiorValor = mat[i,j];
                    }
                }
            }

            return maiorValor;
        }

        private static double EncontrarMenorValor(double[,] mat)
        {
            double menorValor = double.MaxValue;

            for (int i = 0; i < mat.GetLength(0); i++) 
            {
                for (int j = 0; j < mat.GetLength(1); j++) 
                {
                    if (mat[i,j] < menorValor) 
                    {
                        menorValor = mat[i,j];
                    }
                }
            }

            return menorValor;
        }
    }
}
