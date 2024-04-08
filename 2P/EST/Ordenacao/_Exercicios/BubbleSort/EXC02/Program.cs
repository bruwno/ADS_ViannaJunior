/* Autor: William Silva (https://github.com/unclWill) 
 * Data : 07/04/2024
 * 
 * EXERCÍCIO: Implemente o algoritmo BubbleSort e ordene de forma descrescente um vetor de inteiros com idades.
 */

namespace EXC02;

class Program
{
    static void Main(string[] args)
    {
        int[] vet = new int[] { 20, 13, 9, 45, 12, 67, 23 };
        BubbleSort(vet);

        foreach (int n in vet)
        {
            Console.Write($"{n} ");
        }
    }

    public static void BubbleSort(int[] vet)
    {
        for (int i = vet.Length - 1; i >= 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (vet[j] < vet[j + 1])
                {
                    Troca(vet, j, j + 1);
                }
            }
        }
    }

    public static void Troca(int[] vet, int i, int j)
    {
        int aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }
}
