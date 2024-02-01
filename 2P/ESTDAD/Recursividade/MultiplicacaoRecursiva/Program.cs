using System;

namespace MultiplicacaoRecursiva
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Multiplicacao mult = new Multiplicacao();
            Console.Write($"Resultado = {mult.Multiplicar(7, 5)}");
        }
    }
}