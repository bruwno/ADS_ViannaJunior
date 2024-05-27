/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/04/2024
 * 
 * Crie um programa em C# que receba um vetor de números reais com 100 elementos.
 * Escreva uma função recursiva que inverta ordem dos elementos presentes no vetor.
 */

namespace EXC_REC_02;

class Program
{
    public static void Main(string[] args)
    {
        int[] vet = new int[] { 10, 200, 3, 400, 5, 600, 7, 800 };

        int[] vetorInvertido = InverterVetor(vet, 0, vet.Length - 1);
        foreach (var num in vetorInvertido)
        {
            Console.Write($"{num} ");
        }
    }

    // Função:
    public static int[] InverterVetor(int[] vet, int i, int j)
    {
        if (i < j)
        {
            int aux = vet[i];
            vet[i] = vet[j];
            vet[j] = aux;

            return InverterVetor(vet, i + 1, j - 1);
        }
        return vet;
    }

    // Procedimento:
    public static void InverterVetor(int[] vet, int i = 0)
    {
        if (i == vet.Length)
        {
            return;
        }
        else
        {
            InverterVetor(vet, i + 1);
            Console.WriteLine(vet[i]);
        }
    }
}
