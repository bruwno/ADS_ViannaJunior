/* Exercício 02
 * Faça um procedimento recursivo que imprima todos os elementos de um vetor de inteiros separados por '-' (traço). 
 * Observação: traços só podem ser impressos se estiverem separando elementos do vetor, ou seja, não pode haver traço no início ou no final da impressão.
 */

using System;

namespace ImprimeSemTraco
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] vet = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
            Imprimir(vet);
        }

        public static void Imprimir(int[] vet)
        {
            Imprimir(vet, 0);
        }

        public static void Imprimir(int[] vet, int i)
        {
            if (i == vet.Length - 1)
            {
                Console.Write(vet[i]); // O último elemento é impresso fora da chama recursiva, logo o traço não é impresso.
            }
            else if (i >= 0 && i < vet.Length - 1) // -1 porque eu não quero imprimir o traço depois do último elemento.
            {
                Console.Write($"{vet[i]}- ");
                Imprimir(vet, i + 1);
            }
        }
    }
}
