/* Objetivo: Ler 5 valores inteiros e retornar quantos são pares.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 26/09/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1065
 * Nome    : Pares entre Cinco Números
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1065
 */

using System;
class URI
{
    static void Main(string[] args)
    {
        int[] valores = new int[5];

        for (int i = 0; i <= 4; i++)
        {
            valores[i] = int.Parse(Console.ReadLine());
        }

        int qtdPares = VerificarPares(valores);

        Console.WriteLine($"{qtdPares} valores pares");
    }

    private static int VerificarPares(int[] nums)
    {
        int qtdDivisores = 0;

        for (int j = 0; j < nums.Length; j++)
        {
            int num = nums[j];

            if (num % 2 == 0)
            {
                qtdDivisores++;
            }
        }

        return qtdDivisores;
    }
}