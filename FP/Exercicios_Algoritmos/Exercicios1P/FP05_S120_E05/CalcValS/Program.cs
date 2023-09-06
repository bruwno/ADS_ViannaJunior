/* Objetivo : Calcular o valor de S.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 05/08/2023
 * Material : FP05
 * Slide    : 120
 * Exercício: 05
 */

/* 5. Calcular o valor de S.
 */

 using System;

 namespace CalcValS
 {
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("");
            CalcularValor();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void CalcularValor()
        {
            double s = 0.0, acm = 0.0;
            int proxVal = 50;

            for (int valExp = 1; valExp <= 25; valExp++) 
            {
            acm = s;
            
            s = acm + (Math.Pow(2, valExp) / proxVal);

            proxVal = proxVal - 2;
            }

            Console.WriteLine($"O valor de S é {s:N1}");
        }
    }
 }
