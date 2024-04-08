/* Autor: William Silva (https://github.com/unclWill) 
 * Data : 07/04/2024
 * 
 * EXERCÍCIO: Implemente o algoritmo BubbleSort e ordene de forma crescente um vetor inteiro de números e retorne a quantidade de trocas que foram efetuadas.
 */

namespace EXC03;

class Program
{
    public static void Main(string[] args)
    {
        int[] vet = new int[] { 200, 50, 80, 800, 6, 0, 6000, 750, 4, 2, 1 };
        Console.WriteLine($"Foram efetuadas {BubbleSort(vet)} trocas para ordenar o vetor");

        foreach (int n in vet)
        {
            Console.Write($"{n} | ");
        }
    }

    public static int BubbleSort(int[] vet)
    {
        int contaTrocas = 0;
        for (int i = vet.Length - 1; i >= 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (vet[j] > vet[j + 1])
                {
                    Troca(vet, j, j + 1);
                    contaTrocas++;
                }
            }
        }
        return contaTrocas;
    }

    public static void Troca(int[] vet, int i, int j)
    {
        int aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }
}
