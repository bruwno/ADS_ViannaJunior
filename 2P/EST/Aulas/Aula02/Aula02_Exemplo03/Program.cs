using System;

namespace Aula02_Exemplo02
{
    class Program
    {
        public static void Main(string[] args) 
        {
            Console.WriteLine(RetornSomaIntervalo(3, 5));
        }

        public static int RetornSomaIntervalo(int menor, int maior)
        {
            if (menor > maior)
                return 0;

            return menor + RetornSomaIntervalo(menor + 1, maior);
        }
    }
}