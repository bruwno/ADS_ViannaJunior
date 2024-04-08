/* Autor: William Silva (https://github.com/unclWill) 
 * Data : 07/04/2024
 * 
 * EXERCÍCIO: Implemente o algoritmo InsertionSort e ordene de forma crescente um vetor double de pesos de pessoas e retorne a quantidade de trocas realizadas.
 */

namespace EXC04;

class Program
{
    public static void Main(string[] args)
    {
        double[] vet = new double[] { 70.5, 100.12, 59.78, 67.9, 58.5 };
        Console.WriteLine($"Quantidades de trocas para ordenar o vetor: {InsertionSort(vet)}");

        foreach (double n in vet)
        {
            Console.Write($"{n} | ");
        }
    }

    public static int InsertionSort(double[] vet)
    {
        int contaTrocas = 0;
        for (int i = 1; i < vet.Length; i++)
        {
            double chave = vet[i];
            int j;
            for (j = i - 1; j >= 0 && chave < vet[j]; j--)
            {
                Troca(vet, j, j + 1);
                contaTrocas++;
            }
            vet[j + 1] = chave;
        }
        return contaTrocas;
    }

    public static void Troca(double[] vet, int i, int j)
    {
        double aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }

}
