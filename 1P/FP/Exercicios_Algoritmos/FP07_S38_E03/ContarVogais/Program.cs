/* Objetivo : Contar a quantidade de vogais em uma String.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/10/2023
 * Material : FP07 (Strings)
 * Slide    : 38
 * Exercício: 03
 */

/* 3) Fazer um programa para contar o número de vogais em uma string.
 */

using System;

namespace ContarVogais
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            char[] vogais = new char[5] { 'a', 'e', 'i', 'o', 'u' };
            int qtdVogais = 0;
            string str = "Contando a quantidade de vogais nesta string.";
            string strConvMinusc = str.ToLower();

            for (int i = 0; i < strConvMinusc.Length; i++)
            {
                char caractere = strConvMinusc[i];

                for (int j = 0; j < vogais.Length; j++)
                {
                    if (caractere == vogais[j])
                    {
                        qtdVogais++;
                    }
                }
            }

            Console.WriteLine($"A frase: '{str}' possui {qtdVogais} vogais.");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }
    }
}
