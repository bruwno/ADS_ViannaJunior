/* Objetivo : Contar a quantidade de letras em uma palavra e definir se a mesma é "palavrão" ou "palavrinha".
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 21/12/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 3303
 * Nome     : Palavrão
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/3303
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        string palavra = Console.ReadLine();
        DeterminarPalavra(palavra);
    }

    public static void DeterminarPalavra(string palavra)
    {
        int qtdCaracteres = 0;
        for (int i = 0; i < palavra.Length; i++)
        {
            qtdCaracteres++;
        }

        if (qtdCaracteres >= 10)
        {
            Console.WriteLine("palavrao");
        }
        else
        {
            Console.WriteLine("palavrinha");
        }
    }
}
