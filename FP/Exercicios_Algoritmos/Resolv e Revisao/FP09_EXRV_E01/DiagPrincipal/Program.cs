/* Objetivo : Exibir os valores da diagonal principal.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 22/11/2023
 * Material : FP08 (Matrizes)
 * Slide    : EXRV (Exercícios de Revisão)
 * Exercício: 01
 */

/* 5) Faça um programa que que leia uma matriz quadrada e exiba apenas os valores contidos na diagonal principal.
 */

using System;

namespace DiagPrincipal
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            // Definição da dimensões da matriz.
            Console.WriteLine("Informe as dimensões da matriz");
            Console.Write("Quantidade de linhas : ");
            int linhas = DefinirDimensaoMatriz();
            Console.Write("Quantidade de colunas: ");
            int colunas = DefinirDimensaoMatriz();

            if (linhas != colunas)
            {
                Console.WriteLine($"\n[REQUISITO PARA DIAGONAL PRINCIPAL]\nEssa matriz precisa ser quadrada!\nAs dimensões foram ajustadas automaticamente.");

                if (linhas > colunas)
                {
                    colunas = linhas;
                }
                else if (linhas < colunas)
                {
                    linhas = colunas;
                }
            }

            ExibirDefinicoesMatriz(linhas, colunas);

            // Populando a matriz.
            int[,] mat = new int[linhas, colunas];

            Console.Write("Como deseja preencher a matriz?\n" +
                          "|1| MANUALMENTE\n" +
                          "|2| AUTOMATICAMENTE\n" +
                          "[>] ");
            int escolhaPreenchMatriz = Convert.ToInt32(Console.ReadLine());
            Console.Clear();

            if (escolhaPreenchMatriz == 1)
            {
                mat = PreencherManualmente(linhas, colunas);
            }
            else
            {
                mat = PreencherAutomaticamente(linhas, colunas);
            }

            Console.WriteLine("\nDIAGONAL PRINCIPAL\n", Console.ForegroundColor = ConsoleColor.Gray);
            ExibirDiagonalPrincipal(mat);
            Console.WriteLine("\nDIAGONAL SECUNDÁRIA\n", Console.ForegroundColor = ConsoleColor.Gray);
            ExibirDiagonalSecundaria(mat);

            Console.Write("\nPressione qualquer tecla para finalizar...", Console.ForegroundColor = ConsoleColor.Gray);
            Console.ReadKey();
        }

        private static int DefinirDimensaoMatriz()
        {
            int dim = Convert.ToInt32(Console.ReadLine());
            while (dim <= 0 || dim > 10)
            {
                Console.Write("Valor inválido!\nTente novamente: ");
                dim = Convert.ToInt32(Console.ReadLine());
            }

            return dim;
        }

        private static void ExibirDefinicoesMatriz(int linhas, int colunas)
        {
            Console.WriteLine("---------------------");
            Console.WriteLine($"[MATRIZ] {linhas}X{colunas}\n[TOTAL ] {linhas * colunas} valores");
            Console.WriteLine("---------------------");
        }

        private static int[,] PreencherManualmente(int linhas, int colunas)
        {
            int[,] mat = new int[linhas, colunas];

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Digite o valor {i},{j}: ");
                    mat[i, j] = Convert.ToInt32(Console.ReadLine());
                }
            }

            return mat;
        }

        private static int[,] PreencherAutomaticamente(int linhas, int colunas)
        {
            int[,] gerarMatriz = new int[linhas, colunas];
            Random valor = new Random();

            for (int i = 0; i < gerarMatriz.GetLength(0); i++)
            {
                for (int j = 0; j < gerarMatriz.GetLength(1); j++)
                {
                    gerarMatriz[i, j] = valor.Next(0, 9);
                }
            }

            return gerarMatriz;
        }

        private static void ExibirDiagonalPrincipal(int[,] mat)
        {
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    if (i == j)
                    {
                        Console.Write($"{mat[i, j]} ", Console.ForegroundColor = ConsoleColor.Green);
                    }
                    else
                    {
                        Console.Write("0 ", Console.ForegroundColor = ConsoleColor.Gray);
                    }
                }
                Console.WriteLine();
            }
        }

        private static void ExibirDiagonalSecundaria(int[,] mat)
        {
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    if (j == (mat.GetLength(1) - 1) - i)
                    {
                        Console.Write($"{mat[i, j]} ", Console.ForegroundColor = ConsoleColor.Red);
                    }
                    else
                    {
                        Console.Write("0 ", Console.ForegroundColor = ConsoleColor.Gray);
                    }
                }
                Console.WriteLine();
            }
        }
    }
}