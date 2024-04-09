/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/04/2024
 *
 * Faça uma função recursiva que retorne o menor valor existente em um vetor de números reais. 
 * Faça uma função empacotadora para simplificar a utilização da função.
 */

namespace EXC04;

class Program
{
    public static void Main(string[] args)
    {
        double[] vet = new double[] { 1001.47, 876.5, 23456.98, 34, 209, 0.219, 321, -0.415 };

        Console.WriteLine($"Menor número existente no vetor: {RetornaMenorValor(vet)}");
    }

    public static double RetornaMenorValor(double[] vet)
    {
        return RetornaMenorValor(vet, double.MaxValue, 0);
    }

    public static double RetornaMenorValor(double[] vet, double menorValor = double.MaxValue, int i = 0)
    {
        if (i == vet.Length)
        {
            return menorValor;
        }
        else
        {
            if (vet[i] < menorValor)
            {
                menorValor = vet[i];
            }
            return RetornaMenorValor(vet, menorValor, i + 1);
        }
    }
}
