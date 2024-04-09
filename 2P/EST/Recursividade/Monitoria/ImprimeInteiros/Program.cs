/* Exercício 02
 * Faça um procedimento recursivo que imprima todos os elementos de um vetor de inteiros
 * separados por '-' (traço). Observação: traços só podem ser impressos se estiverem separando elementos
 * do vetor, ou seja, não pode haver traço no início ou no final da impressão.
 */

using System;

namespace ImprimeInteiros
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] vet = new int[] { 1, 2, 3, 4, 5 };
            SeparaPorTraco(vet);
        }

        public static void SeparaPorTraco(int[] vet, int i = 0)
        {
            if (i == vet.Length - 1)
            {
                Console.Write(vet[i]);
            }
            else if (i >= 0 && i < vet.Length - 1)
            {
                Console.Write($"{vet[i]}-");
                SeparaPorTraco(vet, i + 1);
            }
        }

    }

}