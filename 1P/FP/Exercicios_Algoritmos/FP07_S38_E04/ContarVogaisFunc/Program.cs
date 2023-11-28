/* Objetivo : Contar a quantidade de vogais em uma String e retornar em uma função.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/10/2023
 * Material : FP07 (Strings)
 * Slide    : 38
 * Exercício: 04
 */

/* 4) Refaça o programa anterior criando uma função que receberá como parâmetro a string 
 * e retornará o número de vogais que a string contem.
 */

using System;
using System.Text;

namespace ContarVogaisFunc
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            string str = "Contar A quantidade de vogais nesta String.";
            int qtdVogais = ContarVogais(str);

            Console.WriteLine($"A frase '{str}' possui {qtdVogais} vogais.");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static int ContarVogais(string str)
        {
            string strConvertida = ConverterParaMinusculas(str);
            int qtdVogais = 0;

            for (int i = 0; i < strConvertida.Length; i++)
            {
                char caractere = strConvertida[i];

                if (caractere == 'a' || caractere == 'e' || caractere == 'i' || caractere == 'o' || caractere == 'u')
                {
                    qtdVogais++;
                }
            }

            return qtdVogais;
        }

        private static string ConverterParaMinusculas(string str)
        {
            StringBuilder strConv = new StringBuilder();

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];

                if (caractere >= 'A' && caractere <= 'Z')
                {
                    strConv.Append(Convert.ToChar(caractere - 'A' + 'a'));
                }
                else
                {
                    strConv.Append(caractere);
                }
            }

            return strConv.ToString();
        }
    }
}