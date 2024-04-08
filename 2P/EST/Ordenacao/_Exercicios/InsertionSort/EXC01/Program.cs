/* Autor: William Silva (https://github.com/unclWill) 
 * Data : 07/04/2024
 * 
 * EXERCÍCIO: Implemente o algoritmo InsertionSort e ordene de forma crescente um vetor double de preços de produtos.
 */

namespace EXC01;

class Program
{
    public static void Main(string[] args)
    {
        double[] vet = new double[] { 200.99, 50.75, 15.90, 4.75, 1500.0, 345.25, 199.90 };
        InsertionSort(vet);

        foreach (double n in vet)
        {
            Console.Write($"{n} ");
        }
    }

    public static void InsertionSort(double[] vet)
    {
        for (int i = 1; i < vet.Length; i++)
        {
            double chave = vet[i];
            int j;
            for (j = i - 1; (j >= 0) && (chave < vet[j]); j--)
            {
                Troca(vet, j, j + 1);
            }
            vet[j + 1] = chave;
        }
    }

    public static void Troca(double[] vet, int i, int j)
    {
        double aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }

}
