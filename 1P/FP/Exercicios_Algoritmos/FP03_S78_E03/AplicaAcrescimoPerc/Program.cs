/* Objetivo : Calcular e exibir valor após aplicação de acréscimo percentual.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 17/08/2023
 * Material : FP03 (Subrotinas)
 * Slide    : 78
 * Exercício: 03
 */

/* Comando:
 * 3) Faça uma função que receba o valor de um produto
 * e um percentual de acréscimo. A função deve retornar
 * o valor do produto após a aplicação do acréscimo.
 */

using System;

namespace AplicaAcrescimoPerc
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Aplicar acréscimo no valor de um produto\n");
            ObterValores();
            Console.Write("Pressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("[i] Informe o valor do produto        (ex.: 50): ");
            double valorProduto = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Informe o percentual de acréscimo (ex.: 15): ");
            double percAcrescimo = Convert.ToDouble(Console.ReadLine());

            double valorComAcrescimo = AplicarAcrescimo(valorProduto, percAcrescimo);
            Console.WriteLine($"\n[>] O valor final com o acréscimo de {percAcrescimo}% é de {valorComAcrescimo:C}");
        }

        private static double AplicarAcrescimo(double valorProduto, double percAcrescimo)
        {
            return valorProduto + ((valorProduto * percAcrescimo) / 100.0);
        }
    }
}
