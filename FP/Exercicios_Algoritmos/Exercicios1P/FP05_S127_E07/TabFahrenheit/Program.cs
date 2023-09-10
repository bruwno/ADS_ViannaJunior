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
<<<<<<< HEAD
            for (int i = 50; i <= 150; i++)
            {
                double tempCelsius = (5.0 / 9.0) * (i - 32.0);
                Console.WriteLine($"{i}ºF equivalem a {tempCelsius:N2}ºC");
            }
=======

>>>>>>> 15df0f949e30f4cfa981f8db2df52a60aa435400
        }
    }
}