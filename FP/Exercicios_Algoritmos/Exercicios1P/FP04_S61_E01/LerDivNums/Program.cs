/* Objetivo : Divisão de números inteiros.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/08/2023
 * Material : FP04
 * Slide    : 61
 * Exercício: 01
 */

/* 1. Faça um programa que leia dois números inteiros e faça 
 * a divisão do primeiro pelo segundo (se o segundo for diferente de zero).
 */

using System;

namespace LerDivNums
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Divisão de números inteiros");
            LerNumeros();
            Console.Write("\nPressione qualquer tecla para finaizar...");
            Console.ReadKey();
        }

        private static void LerNumeros()
        {
            Console.Write("\n[i] Digite o primeiro número: ");
            int num1 = Convert.ToInt32(Console.ReadLine());
            Console.Write("\n[i] Digite o segundo número : ");
            int num2 = Convert.ToInt32(Console.ReadLine());

            if (num2 != 0)
            {
                int result = Calcular(num1, num2);
                Console.WriteLine($"\n[>] Resultado {num1} ÷ {num2} = {result}");
            }
            else
            {
                Console.WriteLine("\n[!] Divisão por zero impossível.");
            }
        }

        private static int Calcular(int num1, int num2)
        {
            return num1 / num2;
        }
    }
}