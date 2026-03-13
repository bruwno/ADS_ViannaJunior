/*
 * QUESTÃO 1 - Faça um programa que leia números inteiros enquanto o número lido for diferente de
 * zero. Imprima ao final a média de números palíndromes informados. Um número palíndrome
 * permanece o mesmo quando lido de trás para a diante. Para esta questão, o zero é flag e, dessa forma,
 * não deve ser considerado um dado de entrada. Será informado ao menos um número palíndrome nos dados de entrada. 
 *
 */

using System;
using System.Linq;

namespace Desafio01
{
    class Program
    {
        public static void Main(string[] args)
        {
            // Preencher uma lista de inteiros
            List<int> numsList = PreencheLista();
            if (numsList.Count == 0) return;

            // Determinar quais números são palíndromes

            // Calcular a média de palíndromes

            // Imprimir resultado
            ImprimirResultado(CalcularMediaPalindromes(SepararPalindromes(numsList)));
        }

        private static List<int> PreencheLista()
        {
            List<int> nums = new List<int>();

            int num;
            do
            {
                num = int.Parse(Console.ReadLine());
                if (num == 0) break;
                nums.Add(num);
            } while (num != 0);

            return nums;
        }

        private static List<int> SepararPalindromes(List<int> nums)
        {
            List<string> palindromes = new List<string>();

            foreach (int num in nums)
            {
                palindromes.Add(num.ToString());
            }

            List<string> palindromesToInt = new List<string>();

            foreach (string palindrome in palindromes)
            {
                if (palindrome.SequenceEqual(palindrome.Reverse()))
                {
                    palindromesToInt.Add(palindrome);
                }
            }

            return palindromesToInt.Select(int.Parse).ToList();
        }

        private static double CalcularMediaPalindromes(List<int> palindromes)
        {
            return palindromes.Average(x => x);
        }

        private static void ImprimirResultado(double media)
        {
            Console.WriteLine(media);
        }
    }
}