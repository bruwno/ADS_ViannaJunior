using System;

namespace ExponenciacaoRecursiva
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Exponenciacao exp = new Exponenciacao();
            Console.WriteLine($"Resultado = {exp.Exponencial(5, 2)}");
        }
    }
}