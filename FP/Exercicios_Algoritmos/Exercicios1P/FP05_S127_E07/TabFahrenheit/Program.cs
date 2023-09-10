/* Objetivo : Escrever tabela de graus Fahrenheit..
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 10/09/2023
 * Material : FP05
 * Slide    : 127
 * Exercício: 07
 */

/* Comando:
 * 7) A conversão de graus Fahrenheit para Centígrados é obtida pela fórmula
 * C = 5/9(F – 32). Escreva um programa que calcule e escreva uma tabela de
 * graus centígrados em função de graus Fahrenheit que variem de 50 a 150 de 1 em 1.
 */

using System;

namespace TabFahrenheit
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine();
            ExibirTabela();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ExibirTabela()
        {

        }
    }
}