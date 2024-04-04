/*
Questão 1) Faça uma função recursiva que receba um número inteiro por parâmetro e retorne true se o número for um número perfeito ou false caso contrário. Um número perfeito é um número natural para o qual a soma de todos os seus divisores naturais próprio é igual ao próprio número. Esta função não pode utilizar comandos de repetição.
Alguns números perfeitos: 6 28 496 8128
*/

using System;

namespace Questao01
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine(ehPerfeito(33550336));
        }

        public static bool ehPerfeito(int n)
        {
            return ehPerfeito(n, 1, 0);
        }

        public static bool ehPerfeito(int n, int divisor = 1, int somaDivisores = 0)
        {
            if (somaDivisores == n)
            {
                return true;
            }
            else
            {
                if (n % divisor == 0)
                {
                    somaDivisores += divisor;

                    if (somaDivisores >= n + 1)
                    {
                        return false;
                    }
                }
                return ehPerfeito(n, divisor + 1, somaDivisores);
            }
        }
    }
}