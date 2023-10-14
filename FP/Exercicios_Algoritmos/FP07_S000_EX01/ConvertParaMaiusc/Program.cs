/* Objetivo : Converter os caracteres de uma string para maiúsculas.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 13/10/2023
 * Material : FP07 (Strings)
 * Slide    : 000 | Aula: https://www.youtube.com/watch?v=tciSBkZvklg
 * Exercício: 01 (Exemplo)
 */

/* 1) Faça um procedimento que receba uma string por parâmetro e imprima-a convertida para maiúsculas.
 */

using System;
using System.Text;

namespace ConvertParaMaiusc
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            string str = "exemplo de cadeia de Caracteres";

            ConverterParaMaiuscula(str);

            Console.Write("\n\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ConverterParaMaiuscula(string str)
        {
            StringBuilder strConvertida = new StringBuilder();

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];

                if (caractere >= 'a' && caractere <= 'z')
                {
                    strConvertida.Append(Convert.ToChar(caractere - 'a' + 'A'));
                }
                else
                {
                    // Preserva os espaços e as letras que já estão maíúsculas (se houverem).
                    strConvertida.Append(caractere);
                }
            }

            Console.WriteLine(strConvertida.ToString());
        }
    }
}
