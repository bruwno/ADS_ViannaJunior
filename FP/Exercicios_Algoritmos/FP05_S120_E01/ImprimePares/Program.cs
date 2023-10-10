/* Objetivo : Imprimir os números pares entre 1 e 100.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/08/2023
 * Material : FP05 (Comandos de Repetição)
 * Slide    : 120
 * Exercício: 01
 */

/* 1. Fazer um algoritmo que imprima todos os números 
 * pares no intervalo de 1 a 100.
 */

using System;

namespace ImprimePares
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Imprimir pares");
            ImprimePares();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ImprimePares()
        {
            int contador = 0;

            while (contador <= 100)
            {
                if (contador % 2 == 0)
                {
                    Console.WriteLine($"[>] {contador}");
                }
                contador++;
            }
        }
    }
}