/* Objetivo : Calcular o valor de E.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 05/09/2023
 * Material : FP05
 * Slide    : 126
 * Exercício: 01
 */

/* 1. Escrever um algoritmo que lê um valor N inteiro e positivo e que calcula  
 * e escreve o valor de E. E = 1 + 1/2 + 1/3 + ... + 1/N
 */

using System;

namespace CalcValE
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Calcular o valor de E");
            ObterValor();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValor()
        {
            Console.Write("\n[i] Digite o valor de N: ");
            int n = Convert.ToInt32(Console.ReadLine());
            Calcular(n);
        }

        private static void Calcular(int n)
        {
            double e = 0.0, cont = 1.0;

            while (cont <= n)
            {
                e += 1.0 / cont;
                cont++;
            }

            Console.WriteLine($"[>] O valor de E é: {e:F3}");
        }
    }
}