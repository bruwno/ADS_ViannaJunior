/* Objetivo : Exibir valor de um produto com desconto.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 16/08/2023
 * Material : FP02
 * Slide    : 64
 * Exercício: 03
 */

/* Comando:
 * 3. Fazer um programa para ler o valor de um produto (em reais) 
 * e o valor de um desconto (em reais). Imprima o
 * valor do produto após a aplicação do desconto.
 */

using System;

namespace ProdutoComDesc
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Aplicar desconto em um produto\n");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
        }

        private static void ObterValores()
        {
            Console.Write("[i] Informe o valor do produto : ");
            double valorProduto = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Informe o valor do desconto: ");
            double valorDesconto = Convert.ToDouble(Console.ReadLine());

            double valorComDesconto = AplicarDesconto(valorProduto, valorDesconto);
            Console.WriteLine($"\n[>] O valor final do produto será {valorComDesconto:C}");
        }

        private static double AplicarDesconto(double valorProd, double valorDesc)
        {
            return valorProd - valorDesc;
        }
    }
}