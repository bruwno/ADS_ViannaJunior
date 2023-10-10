/* Objetivo : Calcular fatorial de um número N.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 10/09/2023
 * Material : FP05 (Comandos de Repetição)
 * Slide    : 127
 * Exercício: 08
 */

/* Comando:
 * 8) Elabore um programa que calcule N! (fatorial de N), sendo que o valor inteiro de
 * N é fornecido pelo usuário. Sabendo que:
 * N! = N x (N-1) x (N-2) x ... x 3 x 2 x 1;
 * 0! = 1, por definição.
 */

using System;

namespace CalcFatorial
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Caclular fatorial\n");
            LerValor();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerValor()
        {
            Console.Write("[i] Digite um valor inteiro: ");
            int valor = Convert.ToInt32(Console.ReadLine());
            double fatorial = CalcularFatorial(valor);

            Console.WriteLine($"O fatorial de {valor}! é = {fatorial}");
        }

        private static double CalcularFatorial(int n)
        {
            double fat = 1.0;

            if (n == 0)
            {
                return 1.0;
            }

            for (int i = n; i > 1; i--)
            {
                // O mesmo que fat = fat * i
                fat *= i;
            }

            return fat;
        }
    }
}