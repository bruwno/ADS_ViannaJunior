/* Objetivo : Verificar divisibilidade por 2e por 3.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 23/08/2023
 * Material : FP04 (Estruturas Condicionais)
 * Slide    : 45
 * Exercício: 03
 */

/* Comando:
 * 3) Altere o algoritmo anterior para que seja informado se o número 
 * é divisível por 2 e por 3 simultaneamente.
 */

using System;

namespace VerifDivV2
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Verifica divisibilidade por 2 e por 3");
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
            if ((num % 2 == 0) && (num % 3 == 0))
            {
                Console.WriteLine($"\n[>] O número {num} é divisivel por 2 e por 3.");
            }
        }
    }
}