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
            int[,] mat = new int[3, 2];

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
            Console.WriteLine("\nTabela de Estoque:");
            Console.WriteLine("Loja\tProduto 1\tProduto 2\tProduto 3\tProduto 4\tProduto 5");

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                Console.Write($"{i + 1}\t");

                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"{mat[i, j]}\t\t");
                }

                Console.WriteLine();
            }

            int menorEstoqueLoja = -1;
            int menorQuantidade = int.MaxValue;

            for (int i = 0; i < 7; i++)
            {
                int quantidadeTotal = 0;
                for (int j = 0; j < 5; j++)
                {
                    quantidadeTotal += mat[i, j];
                }

                if (quantidadeTotal < menorQuantidade)
                {
                    menorQuantidade = quantidadeTotal;
                    menorEstoqueLoja = i;
                }
            }

            Console.WriteLine($"\nA loja com menos produtos é a Loja {menorEstoqueLoja + 1}.");
        }

        /*
                private static void CalcularTotalProdutos(int[,] mat)
                {
                    int[,] tabelaDeProdutos = new int[3, 2];
                    int lojaComMenosProdutos = 0;
                    int menorQtd = int.MaxValue;
                    int i, j;

                    for (i = 0; i < mat.GetLength(0); i++)
                    {
                        int qtdProdutos = 0;

                        for (j = 0; j < mat.GetLength(1); j++)
                        {
                            qtdProdutos += mat[i, j];
                            //tabelaDeProdutos[i, j] = qtdProdutos;
                        }

                        tabelaDeProdutos[i, j - 1] = qtdProdutos;

                        if (qtdProdutos < menorQtd)
                        {
                            menorQtd = qtdProdutos;
                            lojaComMenosProdutos = i + 1;
                        }
                    }

                    ExibirTabela(tabelaDeProdutos, lojaComMenosProdutos, menorQtd);
                }*/

        private static void ExibirTabela(int[,] tabProd, int lojaComMenorQtd, int menorQtd)
        {
            Console.WriteLine("| LOJA 1 | LOJA 2 | LOJA 3 | LOJA 4 | LOJA 5 | LOJA 6 | LOJA 7 |");

            for (int i = 0; i < tabProd.GetLength(0); i++)
            {
                for (int j = 0; j < tabProd.GetLength(1); j++)
                {
                    Console.Write($"  {tabProd[i, j]}\t ");
                }

                Console.WriteLine();
            }

            Console.WriteLine($"Loja com a menor quantidade de produtos: LOJA {lojaComMenorQtd} | Total de: {menorQtd} produtos.");
        }
    }
}