/* Objetivo : Verificar valores.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 23/08/2023
 * Material : FP04 (Estruturas Condicionais)
 * Slide    : 45
 * Exercício: 01
 */

/* Comando:
 * 1) Ler dois números inteiros e informar se o 
 * primeiro valor lido é maior, menor ou igual ao segundo.
 */

using System;

namespace VerificaValor
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Compara dois valores");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("\n[i] Digite o primeiro valor: ");
            int pValor = Convert.ToInt32(Console.ReadLine());
            Console.Write("\n[i] Digite o segundo valor : ");
            int sValor = Convert.ToInt32(Console.ReadLine());

            VerificarValores(pValor, sValor);
        }

        private static void VerificarValores(int val1, int val2)
        {
            if (val1 > val2)
            {
                Console.WriteLine("\n[>] O primeiro valor é maior que o segundo valor.");
            }
            else if (val1 < val2)
            {
                Console.WriteLine("\n[>] O primeiro valor é menor que o segundo valor.");
            }
            else
            {
                Console.WriteLine("\n[>] O primeiro valor é igual ao segundo valor.");
            }
        }
    }
}