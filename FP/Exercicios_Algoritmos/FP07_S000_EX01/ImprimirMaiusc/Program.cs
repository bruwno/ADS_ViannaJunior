/* Objetivo : Imprimir apenas os caracteres maiúsculos de uma string.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 13/10/2023
 * Material : FP07 (Strings)
 * Slide    : 000 | Aula: https://www.youtube.com/watch?v=tciSBkZvklg
 * Exercício: 01 (Exemplo)
 */

/* 1) Imprimir apenas os caracteres maíúsculos da string "Exemplo de Cadeia de Caracteres".
 */

using System;

namespace ImprimirMaiusc
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            string str = "Exemplo de Cadeia de Caracteres";

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];

                if (caractere >= 'A' && caractere <= 'Z')
                {
                    Console.Write(caractere);
                }
            }

            Console.Write("\n\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }
    }
}