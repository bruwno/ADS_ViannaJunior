/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/04/2024
 *
 * Escreva uma função recursiva que determine quantas vezes um dígito K ocorre
 * em um número natural N. Por exemplo, o dígito 2 ocorre 3 vezes em 762021192.
 */

namespace EXC_REC_04;

class Program
{
    static void Main(string[] args)
    {
        int k = 2;
        int n = 762021192;
        Console.WriteLine($"Quantidade de ocorrências do dígito {k} no número {n}: {ContarDigitos(n, k)}");
    }

    public static int ContarDigitos(int n, int k)
    {
        if (n == 0)
        {
            return 0;
        }
        else
        {
            if (n % 10 == k)
            {
                return 1 + ContarDigitos(n / 10, k);
            }
            else
            {
                return ContarDigitos(n / 10, k);
            }
        }
    }
}
