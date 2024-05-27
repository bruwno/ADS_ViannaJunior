/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/04/2024
 * 
 * Crie uma função recursiva que receba um número inteiro positivo N e produza um vetor a partir do resto da divisão dos índices pelo tamanho do vetor,
 * assim como a combinação da multiplicação desse valor com a sua multiplicação pelo índice atual do vetor.
 * depois utilize o método InsertionSort para ordenar de forma decrescente os números desse vetor.
 */

namespace EXC_ORD_02;

class Program
{
    static void Main(string[] args)
    {
        int[] vet = new int[10];
        int[] novoVet = RetornaVetorPreenchido(vet, vet.Length, 0);

        Console.WriteLine("VETOR ORIGINAL:");
        foreach (int num in vet)
        {
            Console.Write($"{num} ");
        }

        InsertionSort(novoVet);

        Console.WriteLine("\nVETOR ORDENADO:");
        foreach (int num in novoVet)
        {
            Console.Write($"{num} ");
        }
    }

    public static int[] RetornaVetorPreenchido(int[] vet, int n, int i = 0)
    {
        if (i < n)
        {
            vet[i] = (i % n) * (n * i);
            return RetornaVetorPreenchido(vet, n, i + 1);
        }
        return vet;
    }

    public static void InsertionSort(int[] vet)
    {
        for (int i = 0; i < vet.Length; i++)
        {
            int chave = vet[i];
            int j;
            for (j = i - 1; j >= 0 && chave > vet[j]; j--)
            {
                Troca(vet, j, j + 1);
            }
            vet[j + 1] = chave;
        }
    }

    public static void Troca(int[] vet, int i, int j)
    {
        int aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }
}
