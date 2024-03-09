/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/03/2024
 *
 * Exercício 5) Crie uma função recursiva que receba um número inteiro positivo N e calcule o somatório dos números de 1 a N.
 */

using System;

namespace Exercicio05
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine(Somar(5));
        }

        public static int Somar(int n)
        {
            if (n == 0)
            {
                return 0;
            }
            else
            {
                return n + Somar(n - 1);
            }
        }
    }
}