/* Objetivo : Imprimir tabela de produtos.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/10/2023
 * Material : FP08 (Matrizes)
 * Slide    : 51
 * Exercício: 08
 */

/* 8) Faça um programa para ler a quantidade de um total de 5 produtos que uma empresa tem em suas 7 lojas e imprimir em uma tabela:
 * a) o total de cada produto nestas lojas 
 * b) a loja que tem menos produtos
 */

using System;

namespace ExibirTabProd
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            int[,] mat = new int[7, 5];

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                Console.WriteLine($"LOJA {i + 1}");

                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.WriteLine($"[Produto {j + 1}]");
                    Console.Write($"Digite a QTD do produto: ");
                    mat[i, j] = Convert.ToInt32(Console.ReadLine());
                }
                Console.WriteLine();
            }

            ExibirTabela(mat);
            VerifLojaComMenosProdutos(mat);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ExibirTabela(int[,] mat)
        {
            Console.WriteLine("\nTabela de Estoque:\n");
            Console.WriteLine("Loja |\tProduto 1 |\tProduto 2 |\tProduto 3 |\tProduto 4 |\tProduto 5 |\tTOTAIS");

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                Console.Write($"{i + 1}\t");

                int quantidadeTotal = 0;
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"{mat[i, j]}\t\t");
                    quantidadeTotal += mat[i, j];
                }
                Console.Write($"{quantidadeTotal}\t", Console.ForegroundColor = ConsoleColor.Green);
                Console.ForegroundColor = ConsoleColor.Gray;
                Console.WriteLine();

            }
        }

        private static void VerifLojaComMenosProdutos(int[,] mat)
        {
            int menorEstoqueLoja = 0;
            int menorQuantidade = int.MaxValue;

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                int quantidadeTotal = 0;
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    quantidadeTotal += mat[i, j];
                }

                if (quantidadeTotal < menorQuantidade)
                {
                    menorQuantidade = quantidadeTotal;
                    menorEstoqueLoja = i + 1;
                }
            }

            Console.WriteLine($"\nA loja com menos produtos é a Loja {menorEstoqueLoja}.");
        }
    }
}