/* Objetivo : Verificar se uma String é um palíndromo.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 24/10/2023
 * Material : FP07 (Strings)
 * Slide    : 47
 * Exercício: 06
 */

/* 6) Escreva uma função que receba uma cadeia de caracteres de tamanho máximo 100, e retorne true se esta cadeia é uma palíndrome e false caso contrário. 
 * Uma palavra é dita ser palíndrome se a sequência de seus caracteres da esquerda para a direita é igual à seqüência de seus caracteres da direita para a esquerda. 
 * Ex.: arara, asa.
 */

using System;
using System.Text;

namespace VerifPalindromo
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("Digite uma palavra ou frase: ");
            string str = ConverterParaMinusculas(Console.ReadLine());

            switch (VerifQtdCaracteres(str))
            {
                case false:
                    Console.WriteLine("Limite de 100 caracteres excedido.");
                    break;
                case true:
                    VerifSeEhPalindromo(str);
                    break;
            }

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void VerifSeEhPalindromo(string strOriginal)
        {
            string strInvertida = InverterString(strOriginal);

            //Console.WriteLine($"Texto de entrada: {strOriginal}");
            //Console.WriteLine($"Texto invertido : {strInvertida}");

            if (strOriginal == strInvertida)
            {
                Console.WriteLine("\nO texto digitado é um palíndromo!", Console.ForegroundColor = ConsoleColor.Green);
            }
            else
            {
                Console.WriteLine("\nO texto digitado não é um palíndromo.", Console.ForegroundColor = ConsoleColor.DarkRed);
            }
            // Resetando a cor da fonte do terminal.
            Console.ForegroundColor = ConsoleColor.Gray;
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

            string strSemEspacos = RemoverEspacos(strConv.ToString());
            // Só interpreta letras. Pode ser um problema, dependendo da situação.
            string strMod = RemoverOutrosCaracteres(strSemEspacos);

            return strMod;
        }

        private static string RemoverOutrosCaracteres(string str)
        {
            StringBuilder strApenasLetras = new StringBuilder();

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];

                if ((caractere >= 'a' && caractere <= 'z'))
                {
                    strApenasLetras.Append(caractere);
                }
            }

            return strApenasLetras.ToString();
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

        private static string InverterString(string str)
        {
            StringBuilder strInvertida = new StringBuilder();

            for (int i = str.Length - 1; i >= 0; i--)
            {
                char caractere = str[i];

                strInvertida.Append(Convert.ToChar(caractere));
            }

            return strInvertida.ToString();
        }

        private static bool VerifQtdCaracteres(string str)
        {
            int qtdCaracteres = 0;

            for (int i = 0; i < str.Length; i++)
            {
                qtdCaracteres++;
            }

            if (qtdCaracteres > 100)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
    }
}