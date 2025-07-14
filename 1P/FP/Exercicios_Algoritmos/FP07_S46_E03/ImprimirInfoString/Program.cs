/* Objetivo : Ler uma String e retornar uam estatística do conteúdo da mesma.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/10/2023
 * Material : FP07 (Strings)
 * Slide    : 46
 * Exercício: 03
 */

/* 3) Fazer um procedimento para receber uma string do usuário e imprimir uma estatística dos caracteres digitados.
 * Isto é, imprimir o número de vogais, consoantes e outros caracteres.
 */

using System;
using System.Text;

namespace ImprimirInfoString
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("Digite um texto: ");
            string str = Console.ReadLine();
            string strConvertida = ConverterParaMinusculas(str);

            ExibeDadosString(strConvertida);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ExibeDadosString(string str)
        {
            Console.WriteLine("\n[Estatísticas do texto digitado]", Console.ForegroundColor = ConsoleColor.Blue);
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.WriteLine($"Quantidade de vogais nesta string: {ContarVogais(str)}");
            Console.WriteLine($"Quantidade de consoantes nesta string: {ContarConsoantes(str)}");
            Console.WriteLine($"Quantidade de outros caracteres nesta string: {ContarOutrosCaracteres(str)}");
        }

        private static string ConverterParaMinusculas(string str)
        {
            StringBuilder strConvertMinusc = new StringBuilder();

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];

                if (caractere >= 'A' && caractere <= 'Z')
                {
                    strConvertMinusc.Append(Convert.ToChar(caractere - 'A' + 'a'));
                }
                else
                {
                    strConvertMinusc.Append(caractere);
                }
            }

            return strConvertMinusc.ToString();
        }

        private static bool EhVogal(char caractere)
        {
            bool ehVogal;

            switch (caractere)
            {
                case 'a':
                    ehVogal = true;
                    break;
                case 'e':
                    ehVogal = true;
                    break;
                case 'i':
                    ehVogal = true;
                    break;
                case 'o':
                    ehVogal = true;
                    break;
                case 'u':
                    ehVogal = true;
                    break;
                default:
                    ehVogal = false;
                    break;
            }

            return ehVogal;
        }

        private static int ContarVogais(string str)
        {
            int qtdVogais = 0;

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];

                if (EhVogal(caractere) == true)
                {
                    qtdVogais++;
                }
            }

            return qtdVogais;
        }

        private static int ContarConsoantes(string str)
        {
            int qtdConsoantes = 0;

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];

                if (caractere >= 'b' && caractere <= 'z')
                {
                    if (EhVogal(caractere) == false)
                    {
                        qtdConsoantes++;
                    }
                }
            }

            return qtdConsoantes;
        }

        private static int ContarOutrosCaracteres(string str)
        {
            int qtdOutrosCaracteres = 0;

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];

                if (!(caractere >= 'a' && caractere <= 'z'))
                {
                    qtdOutrosCaracteres++;
                }
            }
            return qtdOutrosCaracteres;
        }
    }
}