/* Objetivo : Concatenar duas Strings.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/10/2023
 * Material : FP07 (Strings)
 * Slide    : 46
 * Exercício: 01
 */

/* 1) Faça um programa que leia duas strings e crie uma terceira string que será a concatenação das duas outras strings lidas.
 */

using System;
using System.Text;

namespace ConcatString
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            StringBuilder strConcat = new StringBuilder();

            Console.Write("Digite a primeira String: ");
            string str1 = Console.ReadLine();
            Console.Write("Digite a segunda String : ");
            string str2 = Console.ReadLine();

            strConcat.Append(str1);
            strConcat.Append(str2);
            
            System.Console.WriteLine(strConcat.ToString());

            Console.WriteLine("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }
    }
}