/* Objetivo : Contar a quantidade de vogais em uma String e retornar em uma função.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 15/11/2023
 * Material : Simulado
 * Slide    : 00
 * Exercício: 02
 */

/* Questão 2: Faça um programa que leia uma matriz de números reais de tamanho 5 x 5 e, em
 * seguida, imprima a soma dos números positivos pertencentes à diagonal secundária dessa matriz.
 */

using System;

namespace SomaMat
{
    internal class Program
    {
        const int dimMat = 5;
        internal static void Main(string[] args)
        {
            double[,] mat = new double[dimMat, dimMat]
            {{ 1, 2.1, 2, 4, 3 },
            { 1, 2, 4, 3, 6    },
            { 5, 3, -2, 6, 5   },
            { 1, -3, 2, 5, 4   },
            { 9, 1, 4, 33, 44  }
            };
            /*
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Digite o valor de {i},{j}: ");
                    mat[i, j] = Convert.ToDouble(Console.ReadLine());
                }
            }*/

            SomarPositivosDiagSecundaria(mat);
        }

        private static void SomarPositivosDiagSecundaria(double[,] mat)
        {
            double soma = 0.0;

            // Faz a soma se a posição atual estiver na diagonal secundária.
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    if ((mat[i, j] >= 0) && (j == (mat.GetLength(1) - 1) - i))
                    {
                        soma += mat[i, j];
                    }
                }
            }

            // Exibe a matriz preenchida.
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"{mat[i, j]} ");
                }
                Console.WriteLine();
            }

            System.Console.WriteLine($"\nSOMA = {soma}");
        }
    }
}