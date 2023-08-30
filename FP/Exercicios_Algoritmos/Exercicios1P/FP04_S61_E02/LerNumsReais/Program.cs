/* Objetivo : Verificar números reais.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/08/2023
 * Material : FP04
 * Slide    : 61
 * Exercício: 02
 */

/* Comando:
 * 2. Faça um programa para ler dois números reais e verificar se ambos são maiores quezero.
 * Caso positivo, informar “Valores são válidos”. Caso contrário, informar “Valores inválidos”.
 */

using System;

namespace LerNumsReais
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Verificar números reais\n");
            LerNumeros();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerNumeros()
        {
            Console.Write("[i] Digite o primeiro número: ");
            double num1 = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Digite o segundo número : ");
            double num2 = Convert.ToDouble(Console.ReadLine());

            VerificarValores(num1, num2);
        }

        private static void VerificarValores(double num1, double num2)
        {
            if ((num1 > 0.0) && (num2 > 0.0))
            {
                Console.WriteLine("\n[>] Valores são válidos.");
            }
            else
            {
                Console.WriteLine("\n[!] Valores inválidos.");
            }
        }
    }
}