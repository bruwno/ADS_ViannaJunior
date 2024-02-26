using System;

namespace Fibonacci_Recursivo
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine(fib(8));
        }

        public static int fib(int n)
        {
            if (n <= 2)
                return 1;
            else
                return fib(n - 1) + fib(n - 2);
        }
    }

}