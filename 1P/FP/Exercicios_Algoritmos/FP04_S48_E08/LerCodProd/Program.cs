/* Objetivo : Ler o código de um produto e exibir sua origem..
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 29/08/2023
 * Material : FP04 (Estruturas Condicionais)
 * Slide    : 48
 * Exercício: 08
 */

/* Comando:
 * 8) Elaborar um algoritmo para ler o código
 * de um produto e informar a sua origem:
 * a) Código do produto entre 1 e 20: Europa
 * b) Código do produto entre 21 e 40: Ásia
 * c) Código do produto entre 41 e 60: América
 * d) Código do produto entre 61 e 80: África
 * e) Código do produto maior que 80: Paraguai
 */

using System;

namespace LerCodProd
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Informar código do produto e descobrir a dua origem");
            ExibirOrigemProduto();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ExibirOrigemProduto()
        {
            int codProduto = LerCodigo();
            string origem = string.Empty;

            if (codProduto > 0 && codProduto <= 20)
            {
                origem = "Europa";
            }
            else if (codProduto >= 21 && codProduto <= 40)
            {
                origem = "Ásia";
            }
            else if (codProduto >= 41 && codProduto <= 60)
            {
                origem = "América";
            }
            else if (codProduto >= 61 && codProduto <= 80)
            {
                origem = "África";
            }
            else if (codProduto > 80)
            {
                origem = "Paraguai";
            }

            Console.WriteLine($"\n[>] Origem do produto: {origem}");
        }

        private static int LerCodigo()
        {
            Console.Write("\n[i] Digite o código de um produto: ");
            int codigoProd = Convert.ToInt32(Console.ReadLine());
            return codigoProd;
        }
    }
}