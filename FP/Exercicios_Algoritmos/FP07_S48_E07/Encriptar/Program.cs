/* Objetivo : Embaralhar uma mensagem utilizando a cifra de César.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 24/10/2023
 * Material : FP07 (Strings)
 * Slide    : 48
 * Exercício: 07
 */

/* 7) Um dos sistemas de encriptação mais antigos é atribuído a Júlio César: se uma letra a ser encriptada é a letra de
 * número N do alfabeto, substitua-a com a letra (N+K), onde K é um número inteiro constante (César utilizava K = 3).
 * Dessa forma, para K = 1 a mensagem “Ataque ao amanhecer” se torna “bubrfabpabnboifdfs”. 
 * Faça um programa que receba como entrada uma mensagem e um valor de K e retorne a mensagem criptografada pelo código de César.
 */

using System;
using System.Text;

namespace Encriptar
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("Digite a mensagem  : ");
            string str = ConverterParaMinusculas(Console.ReadLine());
            Console.Write("Digite o valor de K: ");
            int k = Convert.ToInt32(Console.ReadLine());

            CifrarMensagem(str, k);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void CifrarMensagem(string str, int k)
        {
            string strSemEspacos = RemoverEspacos(str);
            StringBuilder strEncript = new StringBuilder();

            for (int i = 0; i < strSemEspacos.Length; i++)
            {
                char caractere = strSemEspacos[i];

                strEncript.Append(Convert.ToChar(caractere + k));
            }

            Console.WriteLine($"Mensagem cifrada: {strEncript.ToString()}");
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

        private static string RemoverEspacos(string str)
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

            return strSemEspacos.ToString();
        }
    }
}