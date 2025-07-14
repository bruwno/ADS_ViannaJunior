/* Objetivo : Calcular a raíz quadrada de a e b.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 22/08/2023
 * Material : FP03 (Subrotinas)
 * Slide    : 101
 * Exercício: 04
 */

/* Comando:
 * 4) Faça uma função que receba dois números reais, a e b, e retorne o valor de (A² + B²)¹/².
 * Observação: para calcular a raiz quadrada será preciso utilizar a função Math.Sqrt().
 */

using System;

namespace CalculaExpressao
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular expressão");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("[i] Digite o valor de A: ");
            double numA = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Digite o valor de B: ");
            double numB = Convert.ToDouble(Console.ReadLine());

            double resultado = Calcular(numA, numB);
            Console.WriteLine($"\nO resultado é {resultado}");
        }

        private static double Calcular(double a, double b)
        {
            return Math.Sqrt((Math.Pow(a, 2) + Math.Pow(b, 2)));
        }
    }
}