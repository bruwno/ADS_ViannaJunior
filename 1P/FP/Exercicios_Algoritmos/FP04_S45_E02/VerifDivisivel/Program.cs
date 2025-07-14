/* Objetivo : Verificar divisibilidade por 2.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 23/08/2023
 * Material : FP04 (Estruturas Condicionais)
 * Slide    : 45
 * Exercício: 02
 */

/* Comando:
 * 2) Ler um número inteiro e informar se ele é divisível por 2.
 */

using System;

namespace VerifDivisivel
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Verificar se um número é divisível por 2");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("\n[i] Digite um número inteiro: ");
            int numero = Convert.ToInt32(Console.ReadLine());
            VerificarDivisibilidade(numero);
        }

        private static void VerificarDivisibilidade(int num)
        {
            if (num % 2 == 0)
            {
                Console.WriteLine($"\n[>] O número {num} digitado é divisível por 2.");
            }
            else
            {
                Console.WriteLine($"\n[>] O número {num} digitado não é divisível por 2.");
            }
        }
    }
}