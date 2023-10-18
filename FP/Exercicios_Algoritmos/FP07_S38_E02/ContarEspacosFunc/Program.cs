/* Objetivo : Contar a quantidade de espaços em uma String e retonar utilizando uma função.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 17/10/2023
 * Material : FP07 (Strings)
 * Slide    : 38
 * Exercício: 02
 */

/* 2) Refaça o programa anterior criando uma função que receberá como parâmetro a string e retornará o número de 
 * espaços em branco que a string contém.
 */

 using System;

 namespace ContarEspacosFunc
 {
    internal class Program
    {
        internal static void Main(string[] args)
        {
            string str = "Contar e retonar a quantidade de espaços em branco desta String.";
            Console.WriteLine("Quantidade de espaços na String = " + ContarEspacos(str));

            Console.Write("\nPressione qualquer tecla para finalizar..."); 
            Console.ReadKey();
        }

        private static int ContarEspacos(string str)
        {
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

            return qtdEspacos;
        }
    }
 }
