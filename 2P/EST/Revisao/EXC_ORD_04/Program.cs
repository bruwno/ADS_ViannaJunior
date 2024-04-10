/* Autor: William Silva (github.com/unclWill)
 * Data : 10/04/2024
 *
 * Usando os algortimos de ordenação aprendidos ordene um vetor de números reais e retorne a quantidade de trocas
 * feitas em cada um dos processos de ordenação.
 */

namespace EXC_ORD_04;

class Program
{
    public static void Main(string[] args)
    {
        double[] vet = new double[] { 23.4, 500.9, 3.0, 100012.2, 23.0, 456.1, 1093.7, 21.3, 5.1, 23.12 };
        Console.WriteLine($"Quantidade de trocas [BubbleSort]: {BubbleSort(vet)}");

        Console.WriteLine($"\n[InsertionSort]");
        ImprimirVetor(vet);
        Console.WriteLine($"\n[SelectionSort]");
        ImprimirVetor(vet);
    }

    public static int BubbleSort(double[] vet)
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

    public static void InsertionSort(double[] vet)
    {
        for (int i = 1; i < vet.Length; i++)
        {
            double chave = vet[i];
            int j;
            for (j = i - 1; j >= 0 && chave < vet[j]; j--)
            {
                vet[j + 1] = vet[j];
            }
            vet[j + 1] = chave;
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

    public static void ImprimirVetor(double[] vet)
    {
        foreach (var i in vet)
        {
            Console.Write($"{i} | ");
        }
    }
}
