/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/03/2024
 *
 * Exercício 1) Faça uma função recursiva que calcule e retorne o fatorial de um número inteiro N.
 */

using System;

namespace Exercicio01
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine(Fatorial(5));
        }

        public static int Fatorial(int n)
        {
            if (n == 0)
            {
                return 1;
            }
            else
            {
                return n * Fatorial(n - 1);
            }
        }
    }
}