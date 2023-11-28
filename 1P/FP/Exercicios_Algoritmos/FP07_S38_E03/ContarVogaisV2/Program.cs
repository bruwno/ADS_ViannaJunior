/* Objetivo : Contar a quantidade de vogais em uma String.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/10/2023
 * Material : FP07 (Strings)
 * Slide    : 38
 * Exercício: 03 (v2)
 */

/* 3) Fazer um programa para contar o número de vogais em uma string.
 */

using System;
using System.Text;

namespace ContarVogais
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            int qtdVogais = 0;
            string str = "CONTANDO A QUANTiDADE dE vogais nEstA String.";

            string strConvMinusc = ConverterParaMinuscula(str);

            for (int i = 0; i < strConvMinusc.Length; i++)
            {
                char caractere = strConvMinusc[i];

                if (caractere == 'a' || caractere == 'e' || caractere == 'i' || caractere == 'o' || caractere == 'u')
                {
                    qtdVogais++;
                }
            }

            Console.WriteLine($"A frase: '{str}' possui {qtdVogais} vogais.");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static string ConverterParaMinuscula(string str)
        {
            StringBuilder strConvertida = new StringBuilder();

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];

                if (caractere >= 'A' && caractere <= 'Z')
                {
                    strConvertida.Append(Convert.ToChar(caractere - 'A' + 'a'));
                }
                else
                {
                    strConvertida.Append(caractere);
                }
            }

            return strConvertida.ToString();
        }
    }
}