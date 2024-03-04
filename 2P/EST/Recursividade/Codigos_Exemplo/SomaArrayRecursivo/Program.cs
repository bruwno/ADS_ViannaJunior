using System;

namespace SomaArrayRecursivo
{
    public class Program
    {
        public static void Main(string[] args)
        {
            double[] valores = new double[] { 1.0, 2.0, 3.0, 4.0, 5.1, 6.0, 7.0 };
            SomaArray somaArray = new SomaArray();
            // Passa como argumentos o array de reais e a dimensão do array.
            Console.Write($"Resultado = {somaArray.Somar(valores, 7)}");
        }
    }
}
