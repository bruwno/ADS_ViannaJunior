/* Objetivo : Converter o primeiro caractere de uma String para maíúscula.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/10/2023
 * Material : FP07 (Strings)
 * Slide    : 39
 * Exercício: 05
 */

/* 5) Escreva um programa para ler uma string (com mais de uma palavra) e imprimi-la de forma que a primeira letra de
 * cada palavra fique em maiúscula. Para isso, basta subtrair 32 do elemento que deseja alterar para maiúsculo.
 */

using System;
using System.Text;

namespace ConvertParaMaiusc
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            StringBuilder strConvertida = new StringBuilder();
            string str = "lab. de linguagem de programacao";

            for (int i = 0; i < str.Length; i++)
            {
                if (i == 0 || str[i - 1] == ' ')
                {
                    strConvertida.Append(Convert.ToChar(str[i] - 'a' + 'A'));
                }
                else
                {
                    strConvertida.Append(str[i]);
                }
            }

            Console.WriteLine(strConvertida.ToString());

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }
    }
}