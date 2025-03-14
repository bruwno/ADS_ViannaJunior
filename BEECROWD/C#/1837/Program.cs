/* Objetivo: Imprimir o quociente q seguido pelo resto r da divisão de a por b.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 30/01/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1837
 * Nome    : Prefácio
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1837
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        string[] entrada = Console.ReadLine()!.Trim().Split(' ');
        int a = Convert.ToInt32(entrada[0]);
        int b = Convert.ToInt32(entrada[1]);
        int q, r;

        if (a >= 0)
        {
            q = a / b;
            r = a % b;
        }
        else
        {
            int c, d = 0;

            c = RetornarNumeroPositivo(b);

            for (r = 0; r < c; r++)
            {
                d = a - r;

                if (d % b == 0)
                {
                    break;
                }
            }

            q = d / b;
        }
        Console.WriteLine($"{q} {r}");
    }

    private static int RetornarNumeroPositivo(int num)
    {
        if (num < 0)
        {
            return num * -1;
        }
        else
        {
            return num;
        }
    }
}