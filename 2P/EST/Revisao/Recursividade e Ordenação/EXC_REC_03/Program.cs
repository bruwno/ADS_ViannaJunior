/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/04/2024
 * 
 * Crie uma função recursiva que receba um número inteiro positivo N e calcule o
 * somatório dos números de 1 a N.
 */

namespace EXC_REC_03;

class Program
{
    public static void Main(string[] args)
    {
        int n = 5;
        Console.WriteLine($"Resultado da soma de 1 até {n} = {RetornaSoma(n)}");
    }

    public static int RetornaSoma(int n, int i = 1, int soma = 0)
    {
        if (i == n + 1)
        {
            return soma;
        }
        else
        {
            return RetornaSoma(n, i + 1, soma + i);
        }
    }
}

/* // SOLUÇÃO CLÁSSICA:
    public static int RetornaSoma(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        else
        {
            return n + RetornaSoma(n - 1);
        }
    }
*/