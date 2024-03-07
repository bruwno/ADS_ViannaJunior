using System;

namespace DivisaoRecursiva
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Divisao div = new Divisao();
            Console.WriteLine($" Resultado = {div.Dividir(10, 2)}");
        }
    }
}
