
/* Objetivo: Encontrar entre 100 números e maior valor e a sua posição.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 19/12/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1080
 * Nome    : Maior e Posição
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1080
 */

using System;

class URI
{
    const int dimArray = 100;
    public static void Main(string[] args)
    {
        int[] nums = new int[dimArray];

        for (int i = 0; i < nums.Length; i++)
        {
            nums[i] = int.Parse(Console.ReadLine());
        }

        int maior = 0, posicao = 0;
        for (int i = 0; i < nums.Length; i++)
        {
            if (nums[i] > maior)
            {
                maior = nums[i];
                posicao = i + 1;
            }
        }
        Console.WriteLine($"{maior}\n{posicao}");
    }
}