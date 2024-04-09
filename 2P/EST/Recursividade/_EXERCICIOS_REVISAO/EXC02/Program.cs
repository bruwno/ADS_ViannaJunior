/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/04/2024
 *
 * Faça uma função recursiva que imprima todos os números de 0 (inclusive) a n, sendo n informado pelo usuário.
 */

namespace EXC02;

class Program
{
    public static void Main(string[] args)
    {
        Console.Write("Digite o valor de n: ");
        int n = Convert.ToInt32(Console.ReadLine());

        Console.WriteLine(ImprimeInteiros(n));
    }

    public static int ImprimeInteiros(int n, int i = 0)
    {
        if (i == n)
        {
            return n;
        }
        else
        {
            Console.Write($"{i} ");
            return ImprimeInteiros(n, i + 1);
        }
    }
}
