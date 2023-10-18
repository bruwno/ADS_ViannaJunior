/* Objetivo : Contar a quantidade de espaços em uma String.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 17/10/2023
 * Material : FP07 (Strings)
 * Slide    : 38
 * Exercício: 01
 */

/* 1) Fazer um programa para contar o número de espaços em branco de uma string.
 */

 using System;

 namespace ContarEspacos
 {
    internal class Program
    {
        internal static void Main(string[] args)
        {
            string str = "Ler string e contar os espaços em branco.";
            int qtdEspacos = 0;

            Console.WriteLine($"String lida: {str}");

            for (int i = 0; i < str.Length; i++) 
            {
                char caractere = str[i];

                if (caractere == ' ')
                {
                    qtdEspacos++;
                }
            }

            Console.WriteLine($"Quantidade de espaços na String = {qtdEspacos}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }
    }    
 }