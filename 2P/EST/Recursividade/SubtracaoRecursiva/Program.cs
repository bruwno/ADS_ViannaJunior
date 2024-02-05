
using System;

namespace SubtracaoRecursiva
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Subtracao sub = new Subtracao();
            Console.WriteLine($"Resultado = {sub.Subtrair(50, 10)}");
        }
    }
}
