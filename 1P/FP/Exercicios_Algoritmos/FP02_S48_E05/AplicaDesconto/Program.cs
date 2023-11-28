/* Objetivo : Aplicar desconto sobre um valor e exibí-lo.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 15/08/2023
 * Material : FP02 (E/S de dados)
 * Slide    : 48
 * Exercício: 05
 */

/* Comando:
 * 5. Construa um programa que aplique um
 * desconto de 25% sobre o preço de um
 * produto recebido como entrada e imprima o
 * valor resultante.
 */

using System;

namespace AplicaDesconto
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Aplicar desconto de 25% sobre um valor\n");
            ObterDados();
            Console.Write("Pressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterDados()
        {
            Console.Write("Digite o valor que receberá o desconto: ");
            double valor = Convert.ToDouble(Console.ReadLine().Replace('.', ','));

            double valorComDesconto = AplicarDesconto(valor);
            Console.WriteLine($"\n[>] O valor final é de {valorComDesconto:C}\n");
        }

        private static double AplicarDesconto(double valor)
        {
            return valor - ((valor * 25.0) / 100.0);
        }
    }
}