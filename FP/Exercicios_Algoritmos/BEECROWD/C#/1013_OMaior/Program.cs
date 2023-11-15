/* Objetivo : Ler três valores e retornar o maior.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 29/09/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 1013
 * Nome     : O Maior
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/1013
 */

using System;
class URI
{
    static void Main(string[] args)
    {
        string[] valoresDigitados = Console.ReadLine().Split(' ');
        int[] nums = Array.ConvertAll(valoresDigitados, int.Parse);

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        int maior = (a + b + Math.Abs(a - b)) / 2;

        if (c > maior)
        {
            maior = c;
        }

        Console.WriteLine($"{maior} eh o maior");
    }
}