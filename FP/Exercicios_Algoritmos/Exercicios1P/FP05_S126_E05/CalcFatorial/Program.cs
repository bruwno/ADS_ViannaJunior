/* Objetivo : Calcular a taxa de crescimento.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 09/09/2023
 * Material : FP05
 * Slide    : 126
 * Exercício: 05
 */

/* 5) Escrever um algoritmo que lê um valor N inteiro e positivo e que calcula e
 * escreve o valor de E. E = 1 + 1/1! + 1/2! + 1/3! + ... + 1/N!
 */

using System;

namespace CalcFatorial
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular o valor de E");
            LerValor();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerValor()
        {
            Console.Write("\n[i] Digite um número inteiro: ");
            int numero = Convert.ToInt32(Console.ReadLine());

            double resultado = CalcularFatorial(numero);
            Console.WriteLine($"\nO valor de E é aproximadamente {resultado}");
        }

        private static double CalcularFatorial(int num)
        {
            double e = 1.0, fat = 1.0;

            for (int i = 1; i <= num; i++)
            {
                // fatorial * 1,2,3,4..n (tamanho da contagem do laço).
                fat *= i;
                // Valor de E = 1 + 1 / fatorial
                e += 1.0 / fat;
            }

            return e;
        }
    }
}