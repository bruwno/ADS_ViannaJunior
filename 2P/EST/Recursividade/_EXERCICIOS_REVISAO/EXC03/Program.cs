/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/04/2024
 *
 * Faça uma função recursiva que retorne o maior valor existente em um vetor de números reais.
 */

namespace EXC03;

class Program
{
    public static void Main(string[] args)
    {
        double[] vet = new double[] { 100.8, 560.5, 1001.99, 345.6, -2048.1 };

        Console.WriteLine($"Maior valor do vetor: {RetornaMaiorValor(vet)}");
    }

    public static double RetornaMaiorValor(double[] vet)
    {
        return RetornaMaiorValor(vet, double.MinValue, 0);
    }

    public static double RetornaMaiorValor(double[] vet, double maiorValor = double.MinValue, int i = 0)
    {
        if (i == vet.Length)
        {
            return maiorValor;
        }
        else
        {
            if (vet[i] > maiorValor)
            {
                maiorValor = vet[i];
            }
            return RetornaMaiorValor(vet, maiorValor, i + 1);
        }
    }
}
