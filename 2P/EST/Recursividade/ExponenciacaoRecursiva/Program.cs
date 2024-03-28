using System;

namespace ExponenciacaoRecursiva
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Exponenciacao exp = new Exponenciacao();
            Console.WriteLine($"Resultado = {exp.Potencia(5, 2)}");
        }
    }
}