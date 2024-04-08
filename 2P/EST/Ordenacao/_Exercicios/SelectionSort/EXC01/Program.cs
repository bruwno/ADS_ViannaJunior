/* Autor: William Silva (https://github.com/unclWill) 
 * Data : 07/04/2024
 * 
 * EXERCÍCIO: Implemente o algoritmo SelectionSort e ordene de forma crescente um vetor double de preços de produtos.
 */

namespace EXC01;

class Program
{
    public static void Main(string[] args)
    {
        double[] vet = new double[] { 100.5, 50.9, 45.7, 90.8, 49.99, 25.45, 37.75 };
        SelectionSort(vet);

        foreach (double n in vet)
        {
            Console.Write($"{n} ");
        }
    }

    public static void SelectionSort(double[] vet)
    {
        for (int i = 0; i < vet.Length - 1; i++)
        {
            int indiceMenor = i;
            for (int j = i + 1; j < vet.Length; j++)
            {
                if (vet[j] < vet[indiceMenor])
                {
                    indiceMenor = j;
                }
            }

            if (i != indiceMenor)
            {
                Troca(vet, i, indiceMenor);
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
