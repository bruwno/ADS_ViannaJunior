/* Objetivo : Calcular o valor de S.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 05/09/2023
 * Material : FP05 (Comandos de Repetição)
 * Slide    : 120
 * Exercício: 05
 */

/* 5. Calcular o valor de S. Onde o valor do expoente (iniciado em 1) incrementa, a cada passagem no laço, 1 até chegar a 25,
 * e o valor do divisor (iniciado em 50) decrementa 2 até chegar a 2.
 */

using System;

namespace CalcValS
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular o valor de S");
            CalcularValor();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void CalcularValor()
        {
            double s = 0.0;

            for (int proxExp = 1, proxDiv = 50; proxExp <= 25; proxExp++, proxDiv -= 2)
            {
                s += Math.Pow(2, proxExp) / proxDiv;
            }

            Console.WriteLine($"\nO valor de S é {s}");
        }
    }
}