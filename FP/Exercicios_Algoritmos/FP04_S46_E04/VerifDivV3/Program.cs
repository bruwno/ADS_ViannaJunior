/* Objetivo : Verificar divisibilidade por 2, por 3 e por 5.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 23/08/2023
 * Material : FP04 (Estruturas Condicionais)
 * Slide    : 46
 * Exercício: 04
 */

/* Comando:
 * 4) Altere o algoritmo anterior para que seja informado se o número é divisível 
 * por 2 e por 3, mas que não seja divisível por 5.
 */

using System;

namespace VerifDivV3
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Verificar divisibilidade de um número");
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
            if ((num % 2 == 0) && (num % 3 == 0) && (num % 5 != 0))
            {
                Console.WriteLine($"\n[>] O número {num} é divisível por 2 e por 3, mas não é divisível por 5.");
            }
        }
    }
}