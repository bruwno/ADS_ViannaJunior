/* Objetivo : Imprimir apenas os caracteres minpusculos de uma string.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 12/10/2023
 * Material : FP07 (Strings)
 * Slide    : 114
 * Exercício: 01
 */

/* 1) Imprimir apenas os caracteres minpusculos da string "Exemplo de Cadeia de Caracteres".
 */

using System;

namespace ImprimirMinusc
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            string str = "Exemplo de Cadeia de Caracteres";

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];

                if (caractere >= 'a' && caractere <= 'z' || caractere == ' ')
                {
                    Console.Write(caractere);
                }
            }
        }
    }
}