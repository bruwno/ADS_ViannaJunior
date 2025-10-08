/*
 * QUESTÃO 2 - Faça um programa que leia 10 números inteiros. Os cinco primeiros números estão
 * ordenados entre si e o mesmo ocorre  com os cinco últimos números. Imprima os números informados
 * pelo usuário em ordem ascendente, porém elementos repetidos devem ser impressos uma única vez.
 *
 */

using System;
using System.Linq;

namespace Desafio02
{

    class Program
    {
        public static void Main(string[] args)
        {
            // Ler 10 números int
            List<int> nums = PreencherLista();
            if (nums.Count == 0) return;
            // Remover repetidos
            // Ordenar lista
            // Imprimir lista
            ImprimirLista(OrdenarLista(RemoverRepeticoes(nums)));
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

        private static List<int> RemoverRepeticoes(List<int> nums)
        {
            return nums.Distinct().ToList();
        }

        private static List<int> OrdenarLista(List<int> nums)
        {
            return nums.OrderBy(x => x).ToList();
        }

        private static void ImprimirLista(List<int> nums)
        {
            foreach (int num in nums)
            {
                Console.WriteLine(num);
            }
        }
    }
}