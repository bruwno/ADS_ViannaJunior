/* Objetivo: Determinar quantos participantes acertaram o tipo de chá.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 21/09/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 2006
 * Nome    : Identificando o Chá
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2006
 */

using System;

class URI
{

    static void Main(string[] args)
    {
        int tipoCha = int.Parse(Console.ReadLine());

        string[] respostas = Console.ReadLine().Split(' ');
        int[] respPartic = Array.ConvertAll(respostas, int.Parse);

        int respostasCorretas = 0;
        for (int i = 0; i < respPartic.Length; i++)
        {
            int resposta = respPartic[i];

            if (resposta == tipoCha)
            {
                respostasCorretas++;
            }
        }

        Console.WriteLine(respostasCorretas);
    }
}