/* Objetivo : Imprimir os números pares entre 1 e 100.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 13/09/2023
 * Material : FP05 (Comandos de Repetição)
 * Slide    : 120
 * Exercício: 01
 */

/* 1. Fazer um algoritmo que imprima todos os números 
 * pares no intervalo de 1 a 100.
 */

using System;

namespace ImprimeParesV2
{
    public class Program
    {
        internal static void Main(string[] args)
        {
            Console.WriteLine("[i] Imprimir todos os pares entre 1 e 100");
            ImprimirPares();
            Console.Write("\nPressione qualquer tecla para finalizar...");
        }

        private static void ImprimirPares()
        {
            for (int i = 0; i <= 100; i++)
            {
                if (i % 2 == 0)
                {
                    Console.WriteLine("O número {0} é par.", i);
                }
            }
        }

    }
}
