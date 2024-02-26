using System;

namespace Fibonacci_Iterativo
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Fibonacci(8);
        }

        private static void Fibonacci(int n)
        {
            int numAnterior = 1, numAtual = 1;

            for (int i = 3; i <= n; i++)
            {
                int aux = numAtual;
                numAtual = numAtual + numAnterior;
                numAnterior = aux;
            }
            Console.Write(numAtual);
        }
    }
}
