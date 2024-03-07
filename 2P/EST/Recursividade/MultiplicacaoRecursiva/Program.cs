/* Autor: William Silva (https://github.com/unclWill)
 * Data : 01/02/2024
 */

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