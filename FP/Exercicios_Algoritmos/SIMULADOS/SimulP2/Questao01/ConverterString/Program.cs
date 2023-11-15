/* Objetivo : Listar nomes da menor para a maior idade.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 07/11/2023
 * Material : Simulado
 * Slide    : 00
 * Exercício: 01
 */

/* Questão 1: Faça uma função que receba por parâmetro uma string. 
 * Se a primeira letra da string for uma vogal, a função deve retornar a string convertida para letras maiúsculas. 
 * Caso contrário, a função deve retornar a string convertida para letras minúsculas
 * Exemplos: 
 * - Para a string “Teste 123” deve ser retornado “teste 123”
 * - Para a string “Este 123” deve ser retornado “ESTE 123”
 */

using System;
using System.Text;

namespace ConverterString
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("Digite uma frase: ");
            string str = Console.ReadLine();
            string strConvertida = ConverterCaractere(str);
            Console.WriteLine($"Frase convertida: {strConvertida}");

            Console.Write("\nPressioen qualquer tecla para finalizar...");
            Console.ReadLine();
        }

        private static bool EhVogal(char caractere)
        {
            const string vogais = "aeiouAEIOU";

            for (int i = 0; i < vogais.Length; i++)
            {
                if (vogais[i] == caractere)
                {
                    return true;
                }
            }

            return false;
        }

        private static string ConverterCaractere(string str)
        {
            StringBuilder strConv = new StringBuilder();

            char letraInicial = str[0];

            if (EhVogal(letraInicial) == true)
            {
                for (int i = 0; i < str.Length; i++)
                {
                    if (str[i] >= 'a' && str[i] <= 'z')
                    {
                        strConv.Append(Convert.ToChar(str[i] - 'a' + 'A'));
                    }
                    else
                    {
                        strConv.Append(Convert.ToChar(str[i]));
                    }
                }
            }
            else
            {
                for (int i = 0; i < str.Length; i++)
                {
                    if (str[i] >= 'A' && str[i] <= 'Z')
                    {
                        strConv.Append(Convert.ToChar(str[i] - 'A' + 'a'));
                    }
                    else
                    {
                        strConv.Append(Convert.ToChar(str[i]));
                    }
                }
            }

            return strConv.ToString();
        }
    }
}