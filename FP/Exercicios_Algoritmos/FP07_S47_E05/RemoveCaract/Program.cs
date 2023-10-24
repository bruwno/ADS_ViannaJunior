/* Objetivo : Separar os caracteres de uma frase em vogais e consoantes.
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
            string str = Console.ReadLine();

            switch (ContarQtdCaracteres(str))
            {
                case false:
                    Console.WriteLine("Limite de 20 caracteres excedido.");
                    break;
                case true:
                    Console.Write("Digite o caractere que deseja remover: ");
                    char caractereParaRemover = Convert.ToChar(Console.ReadLine());
                    Console.WriteLine($"{RemoverCaractere(str, caractereParaRemover)}");
                    break;
            }

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
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

            return $"Nova frase: {novaFrase.ToString()}\n" +
                   $"O caractere '{caractParaRemover}' foi removido : {qtdVezesRemovido} vezes";
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