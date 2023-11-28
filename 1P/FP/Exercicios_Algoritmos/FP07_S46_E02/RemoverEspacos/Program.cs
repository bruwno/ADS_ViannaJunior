/* Objetivo : Remover os espaços em branco de uma String.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/10/2023
 * Material : FP07 (Strings)
 * Slide    : 46
 * Exercício: 02
 */

/* 2) Fazer um procedimento para imprimir uma string recebida como parâmetro sem os espaços em branco.
 */

using System;
using System.Text;

namespace RemoverEspacos
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            string str = "Imprimindo String sem os espaços em branco.";
            RemoveEspacosEmBranco(str);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void RemoveEspacosEmBranco(string str)
        {
            StringBuilder strSemEspacos = new StringBuilder();

            for (int i = 0; i < str.Length; i++) 
            {
                char caractere = str[i];

                if (caractere == ' ')
                {
                    strSemEspacos.Append(Convert.ToChar(caractere - ' '));
                }
                else
                {
                    strSemEspacos.Append(caractere);
                }
            }

            Console.WriteLine($"String original: {str} \nString sem espaços: {strSemEspacos.ToString()}");
        }
    }
}