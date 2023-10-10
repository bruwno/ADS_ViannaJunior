/* Objetivo : Calcular volume de uma esfera.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 22/08/2023
 * Material : FP03 (Subrotinas)
 * Slide    : 100
 * Exercício: 02
 */

/* Comando:
 * 2) Faça uma função que receba por parâmetro o raio de uma esfera e calcule o seu volume: v = (4 * PI * R3) /3.
 */

using System;

namespace CalculaRaio
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular volume da esfera\n");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("[i] Digite o valor do raio: ");
            double valorRaio = Convert.ToDouble(Console.ReadLine());

            double volumeEsfera = CalcularRaio(valorRaio);
            Console.WriteLine($"\n[>] O volume da esfera é igual a {volumeEsfera:N1} cm³");
        }

        private static double CalcularRaio(double raio)
        {
            const double pi = 3.1415;
            return (4.0 * pi * Math.Pow(raio, 3.0)) / 3.0;
        }
    }
}