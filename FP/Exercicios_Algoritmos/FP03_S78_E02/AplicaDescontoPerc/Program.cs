/* Objetivo : Calcular e exibir valor após aplicação de desconto percentual.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 17/08/2023
 * Material : FP03
 * Slide    : 78
 * Exercício: 02
 */

/* Comando:
 * 2) Faça uma função que receba o valor de um produto
 * e um percentual de desconto. A função deve retornar
 * o valor do produto após a aplicação do desconto.
 */

using System;

namespace AplicaDescontoPerc
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Aplicar desconto sobre o valor de um produto\n");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("[i] Informe o valor do produto       (ex.: 50): ");
            double valorProduto = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Informe o percentual de desconto (ex.: 15): ");
            double percDesconto = Convert.ToDouble(Console.ReadLine());

            double valorComDesconto = AplicarDesconto(valorProduto, percDesconto);
            Console.WriteLine($"\n[>] O valor final com o desconto de {percDesconto}% é de {valorComDesconto:C}");
        }

        private static double AplicarDesconto(double valorProduto, double percDesconto)
        {
            return valorProduto - ((valorProduto * percDesconto) / 100.0);
        }
    }
}