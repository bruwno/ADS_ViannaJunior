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
            int[,] mat = new int[4, 3];

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

            CalcularTotalProdutos(mat);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void CalcularTotalProdutos(int[,] mat)
        {

            Console.WriteLine("LOJA 1\t | LOJA 2\t | LOJA 3\t | LOJA 4\t");
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                int qtdProdutos = 0;

                //Console.WriteLine("---------------------------------------------");
                //Console.WriteLine("| Produto \t| Quantidade |");
                //Console.WriteLine("---------------------------------------------");

                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    qtdProdutos += mat[i, j];
                    Console.Write($"| Produto {j + 1}\t| {mat[i, j]}\t|");
                }

                System.Console.WriteLine();
                /*Console.WriteLine("---------------------------------------------");
                Console.WriteLine($"Total:\t\t| {qtdProdutos}\t|");
                Console.WriteLine("---------------------------------------------");*/


                /*
                for (int i = 0; i < mat.GetLength(0); i++)
                {
                    int qtdProdutos = 0;

                    Console.WriteLine($"QTD PRODUTO {i + 1}");

                    for (int j = 0; j < mat.GetLength(1); j++)
                    {
                        qtdProdutos += mat[i, j];
                    }
                    Console.WriteLine($"Total: {qtdProdutos}");*/
            }
        }
    }
}