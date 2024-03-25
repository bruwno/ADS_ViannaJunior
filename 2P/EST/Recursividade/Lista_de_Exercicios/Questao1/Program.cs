
using System;

namespace Questao1
{
    public class Program
    {
        public static void Main(string[] args)
        {
            ImprimirDivisores(32);
        }

        public static void ImprimirDivisores(int n)
        {
            if (n == 0)
            {
                return;
            }
            else
            {
                ImprimirDivisores(n - 1);
                if (n % 2 == 0 && n % 3 == 0)
                {
                    Console.Write($"{n} ");
                }
            }
        }
    }
}