/* Objetivo: Simular o jogo do PIM.
 * Autor : William Silva (https://github.com/unclWill)
 * Data : 23/12/2023
 * Tipo : 9 (SQL)
 * ID : 1142
 * Nome : PUM
 * Link : https://www.beecrowd.com.br/judge/pt/problems/view/1142
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int cont = 1;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= 3; j++)
            {
                if (j == 3)
                {
                    Console.WriteLine("PUM");
                }
                else
                {
                    Console.Write($"{cont} ");
                }
                cont++;
            }
        }
    }
}