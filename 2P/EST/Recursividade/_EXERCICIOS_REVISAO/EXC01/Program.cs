/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/04/2024
 *
 * Faça um procedimento recursivo que imprima todos os números de 0 (inclusive) a n, sendo n informado pelo usuário.
 */

namespace EXC01;

class Program
{
    static void Main(string[] args)
    {
        Console.Write("Digite o valor de n: ");
        int n = int.Parse(Console.ReadLine());

        ImprimirInteiros(n);
    }

    public static void ImprimirInteiros(int n, int i = 0)
    {
        if (i >= n + 1)
        {
            return;
        }
        else
        {
            Console.Write($" {i} ");
            ImprimirInteiros(n, i + 1);
        }
    }
}
