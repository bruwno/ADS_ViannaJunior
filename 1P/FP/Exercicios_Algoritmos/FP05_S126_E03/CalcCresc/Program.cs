/* Objetivo : Calcular a taxa de crescimento.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 06/09/2023
 * Material : FP05 (Comandos de Repetição)
 * Slide    : 126
 * Exercício: 03
 */

/* 3) Chico tem 1,50 metros e cresce 2 centímetros por ano, enquanto Zé tem 1,40 
metros e cresce 3 centímetros por ano. Construa um algoritmo que calcule e 
imprima quantos anos serão necessários para que Zé seja maior que Chico.
 */

using System;

namespace CalcCresc
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular taxa de crescimento");
            CalcularTaxaCresc();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();

        }

        private static void CalcularTaxaCresc()
        {
            double estaturaChico = 1.50;
            double estaturaZe = 1.40;
            int tempoDecorrido = 0;

            while (estaturaZe <= estaturaChico)
            {
                estaturaChico += 0.02;
                estaturaZe += 0.03;

                tempoDecorrido++;
            }

            Console.WriteLine($"\nSerão necessários {tempoDecorrido} anos para que Zé seja maior que Chico.\nChico terá {estaturaChico:N2}m e Zé terá {estaturaZe:N2}m");
        }
    }
}