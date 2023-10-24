/* Objetivo : Remover um caractere de uma String.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 23/10/2023
 * Material : FP07 (Strings)
 * Slide    : 47
 * Exercício: 05
 */

/* 5) Faça uma função que receba uma string do usuário (máx.20 caracteres) e um caractere qualquer. 
 * A função deverá criar uma nova string onde terão sido removidas todas as ocorrências do caractere da string. 
 * A função deve retornar o número de remoções.
 */

using System;
using System.Text;

namespace RemoveCaract
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("Digite uma frase (máx. 20 caracteres): ");
            string str = ConverterParaMinusculas(Console.ReadLine());

            switch (ContarQtdCaracteres(str))
            {
                case false:
                    Console.WriteLine("Limite de 20 caracteres excedido.");
                    break;
                case true:
                    Console.Write("Digite o caractere que deseja remover: ");
                    char caractereParaRemover = ConverterParaMinusculas(Convert.ToChar(Console.ReadLine()));
                    Console.WriteLine($"{RemoverCaractere(str, caractereParaRemover)}");
                    break;
            }

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static string ConverterParaMinusculas(string str)
        {
            StringBuilder convMinusc = new StringBuilder();

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];
                if (caractere >= 'A' && caractere <= 'Z')
                {
                    convMinusc.Append(Convert.ToChar(caractere - 'A' + 'a'));
                }
                else
                {
                    convMinusc.Append(caractere);
                }
            }

            return convMinusc.ToString();
        }

        private static char ConverterParaMinusculas(char caractere)
        {
            char caractereConv;

            if (caractere >= 'A' && caractere <= 'Z')
            {
                return caractereConv = Convert.ToChar(caractere - 'A' + 'a');
            }
            else
            {
                return caractere;
            }
        }

        private static string RemoverCaractere(string str, char caractParaRemover)
        {
            StringBuilder novaFrase = new StringBuilder();
            int qtdVezesRemovido = 0;

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];

                if (caractere == caractParaRemover)
                {
                    qtdVezesRemovido++;
                }
                else
                {
                    novaFrase.Append(caractere);
                }
            }

            //string frase = CapitalizarString(novaFrase.ToString());

            return $"Nova frase: {novaFrase.ToString()}\n" +
                   $"O caractere '{caractParaRemover}' foi removido : {qtdVezesRemovido} vezes";
        }

        private static string CapitalizarString(string str)
        {
            StringBuilder stringCapitalizada = new StringBuilder();

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];
                if (i == 0 || str[i - 1] == ' ')
                {
                    stringCapitalizada.Append(Convert.ToChar(caractere - 'a' + 'A'));
                }
                else
                {
                    stringCapitalizada.Append(caractere);
                }
            }

            return stringCapitalizada.ToString();
        }

        private static bool ContarQtdCaracteres(string str)
        {
            int qtdCaracteres = 0;

            for (int i = 0; i < str.Length; i++)
            {
                qtdCaracteres++;
            }

            if (qtdCaracteres > 20)
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