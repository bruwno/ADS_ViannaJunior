/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/03/2024
 *
 * Exercício 2) Faça uma função recursiva que calcule e retorne o N-ésimo termo da sequência
 * Fibonacci. Alguns números desta sequência são: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
 */

using System;

namespace Exercicio02
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine(Fibonacci(8));
        }

        public static int Fibonacci(int n)
        {
            if (n <= 2)
            {
                return 1;
            }
            else
            {
                return Fibonacci(n - 1) + Fibonacci(n - 2);
            }
        }
    }
}
