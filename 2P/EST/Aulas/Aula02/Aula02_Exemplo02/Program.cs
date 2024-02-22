using System;

namespace Aula02_Exemplo02
{
    class Program
    {
        public static void Main(string[] args) 
        {
            ImprimeSomaIntervalo(3,5,0);
        }

        public static void ImprimeSomaIntervalo(int menor, int maior, int soma)
        {
            if (menor > maior)
            {
                Console.WriteLine(soma);
                return;
            }
            else
            {
                soma += menor;
                ImprimeSomaIntervalo(menor + 1, maior, soma);
            }
        }

    }
}