/* Autor: William Silva (https://github.com/unclWill) 
 * Data : 07/04/2024
 * 
 * EXERCÍCIO: Implemente o algoritmo InsertionSort e ordene de forma decrescente um vetor int de quantidade de peças de uma loja.
 */

namespace EXC02;

class Program
{
    static void Main(string[] args)
    {
        int[] vet = new int[] { 10, 300, 25, 450, 900, 22, 73, 5, 2, 0 };
        InsertionSort(vet);

        foreach (int n in vet)
        {
            Console.Write($"{n} ");
        }
    }

    public static void InsertionSort(int[] vet)
    {
        for (int i = 1; i < vet.Length; i++)
        {
            int chave = vet[i];
            int j;
            for (j = i - 1; (j >= 0) && (chave > vet[j]); j--)
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
