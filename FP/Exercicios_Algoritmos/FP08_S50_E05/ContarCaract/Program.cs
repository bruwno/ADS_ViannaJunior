/* Objetivo : Contar  quantidade de letras a em uma matriz.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/10/2023
 * Material : FP08 (Matriz)
 * Slide    : 50
 * Exercício: 05
 */

/* 5) Faça um programa que leia uma matriz de caracteres 5 x 10 e uma função que conte quantas letras “a” aparecem na matriz. 
 * Você poderá fazer a leitura letra a letra ou considerar que cada linha da matriz é uma string.
 */

using System;
using System.Text;

namespace ContarCaract
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            string[,] mat = new string[5, 10];

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Elemento {i},{j}: ");
                    mat[i, j] = Console.ReadLine();
                }
            }

            int qtdOcorr = ContarOcorrenciasCaractere(mat);

            switch (qtdOcorr)
            {
                case 0:
                    Console.WriteLine($"A letra 'a' não aparece na matriz.");
                    break;
                case 1:
                    Console.WriteLine($"A letra 'a' aparece {qtdOcorr} vez na matriz.");
                    break;
                default:
                    Console.WriteLine($"A letra 'a' aparece {qtdOcorr} vezes na matriz.");
                    break;
            }

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static int ContarOcorrenciasCaractere(string[,] mat)
        {
            int qtdOcorrencias = 0;

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    string linhaAtual = mat[i, j];

                    for (int k = 0; k < linhaAtual.Length; k++)
                    {
                        char caractere = linhaAtual[k];

                        if (caractere == 'a' || caractere == 'A')
                        {
                            qtdOcorrencias++;
                        }
                    }
                }
            }

            return qtdOcorrencias;
        }
    }
}