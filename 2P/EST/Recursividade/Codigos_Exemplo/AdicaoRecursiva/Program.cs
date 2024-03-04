using System;

namespace AdicaoRecursiva
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Adicao adc = new Adicao();
            Console.Write($"Resultado = {adc.Somar(5)}");
        }
    }
}