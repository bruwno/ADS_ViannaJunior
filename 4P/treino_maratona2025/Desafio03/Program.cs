/*
 * QUESTÃO 3 - Faça um programa que leia 10 números inteiros. Após a leitura do vetor, imprima a 
 * soma dos inteiros no intervalo fechado [1, 99] que não fazem parte do conjunto dos 100 inteiros lidos.
 *
 */

using System;
using System.Linq;

namespace Desafio03
{

    class Program
    {
        public static void Main(string[] args)
        {
            // Preencher o vetor
            List<int> nums = PreencherLista();
            if (nums.Count == 0) return;
            // Somar valores no intervalo [1, 99] que não fazem parte da lista
            Imprimir(SomarNumeros(nums));
        }

        private static List<int> PreencherLista()
        {
            List<int> nums = new List<int>();

            int num;
            for (int i = 0; i < 10; i++)
            {
                num = int.Parse(Console.ReadLine());
                nums.Add(num);
            }

            return nums;
        }

        private static int SomarNumeros(List<int> nums)
        {
            List<int> allNums = new List<int>();
            for (int i = 1; i <= 99; i++)
            {
                allNums.Add(i);
                Console.Write($"{i} ");
            }

            Console.WriteLine($"TOTAL (allNums): {allNums.Sum()}");

            Console.WriteLine($"TOTAL (nums): {nums.Sum()}");

            var sum = allNums.Select(x => x)
                             .Where(x => x != nums.Select(x => x).Sum());

            // foreach (int num in allNums)
            // {
            //     if (num != nums.ElementAt(0))
            //     {
            //         sum += allNums.ElementAt(i);
            //     }
            // }

            int result = sum.Sum();

            return result;
        }

        private static void Imprimir(int num)
        {
            Console.WriteLine(num);
        }

    }
}