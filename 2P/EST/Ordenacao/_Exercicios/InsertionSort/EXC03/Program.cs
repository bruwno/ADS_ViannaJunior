/* Autor: William Silva (https://github.com/unclWill) 
 * Data : 07/04/2024
 * 
 * EXERCÍCIO: Implemente o algoritmo InsertionSort e ordene de forma crescente um vetor double de pesos de pessoas.
 */

namespace EXC03;

class Program
{
    static void Main(string[] args)
    {
        double[] vet = new double[] { 100.99, 58.67, 76.40, 89.0, 99.05, 102.94, 60.8 };
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
