using System;

namespace Questao02
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("Informe um valor para X: ");
            int num = Convert.ToInt32(Console.ReadLine());
            AdivinharNumero(num);
            Console.ReadKey();
        }

        internal static void AdivinharNumero(int x)
        {
            int tentativas = 1;

            Console.Write("Adivinhe um inteiro: ");
            int numero = Convert.ToInt32(Console.ReadLine());

            while (numero != x)
            {
                Console.Write($"Você errou! Tente mais uma vez: ");
                numero = Convert.ToInt32(Console.ReadLine());

                tentativas++;
            }

            Console.Write($"Parabéns! você acertou após {tentativas} tentativas.");
        }
    }
}