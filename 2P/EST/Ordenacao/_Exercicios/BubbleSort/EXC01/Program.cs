/* Autor: William Silva (https://github.com/unclWill) 
 * Data : 07/04/2024
 * 
 * EXERCÍCIO: Implemente o algoritmo BubbleSort e ordene de forma crescente um vetor double de preços de produtos.
 */

namespace Ord_BubbleSort;

class Program
{
    static void Main(string[] args)
    {
        double[] vet = new double[] { 200.0, 10.50, 50.99, 3.75, 97.00, 0.90, 14.25 };
        BubbleSort(vet);

        foreach (double num in vet)
        {
            Console.Write($"{num} | ");
        }
    }

    public static void BubbleSort(double[] vet)
    {
        for (int i = vet.Length - 1; i >= 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (vet[j] > vet[j + 1])
                {
                    Troca(vet, j, j + 1);
                }
            }
        }
    }

    public static void Troca(double[] vet, int i, int j)
    {
        double aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }
}
