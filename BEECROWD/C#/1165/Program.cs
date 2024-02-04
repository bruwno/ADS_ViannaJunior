/* Objetivo: Verificar se um número é primo.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 04/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1165
 * Nome    : Número Primo
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1165
 */

using System;
using System.Collections.Generic;

class URI
{
    public static void Main(string[] args)
    {
        List<int> numeros = new List<int>();
        int n = int.Parse(Console.ReadLine());
        for (int i = 0; i < n; i++)
        {
            numeros.Add(int.Parse(Console.ReadLine()));
        }

        foreach (int numero in numeros)
        {
            if (ehPrimo(numero))
            {
                Console.WriteLine($"{numero} eh primo");
            }
            else
            {
                Console.WriteLine($"{numero} nao eh primo");
            }
        }
    }

    public static bool ehPrimo(int num)
    {
        if (num <= 1)
        {
            return false;
        }

        if (num == 2 || num == 3)
        {
            return true;
        }

        if (num % 2 == 0 || num % 3 == 0)
        {
            return false;
        }

        for (int i = 5; i * i <= num; i += 6)
        {
            if (num % i == 0 || num % (i + 2) == 0)
            {
                return false;
            }
        }

        return true;
    }
}