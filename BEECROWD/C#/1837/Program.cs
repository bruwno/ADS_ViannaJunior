/* Objetivo: .
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 30/01/2024
 * Tipo    : 7 (INICIANTE)
 * ID      : 1837
 * Nome    : Prefácio
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1837
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        string[] entrada = Console.ReadLine().Trim().Split(' ');
        int a = Convert.ToInt32(entrada[0]);
        int b = Convert.ToInt32(entrada[1]);

        int q = 0, r = 0;

        if (a >= 0)
        {
            q = a / b;
            r = a % b;
        }
        else
        {
            int c = 0, d = 0;

            c = TransformarEmPositivo(b);

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

    private static int TransformarEmPositivo(int num)
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