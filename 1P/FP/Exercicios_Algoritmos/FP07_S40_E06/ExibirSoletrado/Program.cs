/* Objetivo : Converter o primeiro caractere de uma String para maíúscula.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/10/2023
 * Material : FP07 (Strings)
 * Slide    : 40
 * Exercício: 05
 */

/* 6) Crie um procedimento que receba uma frase e a exiba na tela de forma soletrada, 
 * ou seja, cada letra deve ser exibida na tela separada por hífen.
 */

using System;
using System.Text;

namespace ExibirSoletrado
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            StringBuilder strConcat = new StringBuilder();
            string str = "Programacao";

            for (int i = 0; i < str.Length; i++) 
            {
                char caractere = str[i];
                strConcat.Append(caractere + "-");
            }

            Console.WriteLine(strConcat.ToString());

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }
    }
}