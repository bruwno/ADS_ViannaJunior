/* Objetivo : Exibir os valores das diagonaias.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 22/11/2023
 * Material : FP08 (Matrizes)
 * Slide    : EXRV (Exercícios de Revisão)
 * Exercício: 02
 */

/* 2) Faça um programa que leia uma matriz quadrada do tipo char e exiba apenas os carcteres das diagonais principal e secundária.
 * Os caracteres que forem digitados em minúsculo devem ser exibidos em maiúsculo e vice-versa.
 */

using System;
using System.Text;

namespace MatStr
{
    internal class Program
    {
        const int dim = 4;
        public static void Main(string[] args)
        {
            char[,] mat = new char[dim, dim];

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Digite o caractere para a posição {i},{j}: ");
                    mat[i, j] = Convert.ToChar(Console.ReadLine());
                }
            }

            MontarMatrizOriginal(mat);
            Console.WriteLine();
            ExibirMatriz(InverterCaractMatriz(mat));

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void MontarMatrizOriginal(char[,] mat)
        {
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"{mat[i, j]} ");
                }
                Console.WriteLine();
            }
        }

        private static char ConverterCaracteres(char caractere)
        {
            if (caractere >= 'a' && caractere <= 'z')
            {
                // Converte de minúsculas para maiúsculas.
                return Convert.ToChar(caractere - 'a' + 'A');
            }
            else if (caractere >= 'A' && caractere <= 'Z')
            {
                // Converte de maiúsculas para minúsculas.
                return Convert.ToChar(caractere - 'A' + 'a');
            }
            else
            {
                return caractere;
            }
        }

        private static char[,] InverterCaractMatriz(char[,] mat)
        {
            char[,] matrizInvertida = new char[dim, dim];

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    matrizInvertida[i, j] = ConverterCaracteres(mat[i, j]);
                }
            }

            return matrizInvertida;
        }

        private static void ExibirMatriz(char[,] mat)
        {
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    if ((i == j) || (j == (mat.GetLength(1) - 1) - i))
                    {
                        Console.Write($"{mat[i, j]} ");
                    }
                    else
                    {
                        Console.Write(' ');
                    }
                }
                Console.WriteLine();
            }
        }
    }
}
