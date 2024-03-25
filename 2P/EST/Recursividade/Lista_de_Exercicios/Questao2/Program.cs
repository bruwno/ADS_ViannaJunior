using System;

namespace Questao2
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] vet = new int[] { -2, 3, -5, 7, -4, 10 };
            Console.WriteLine(RetornaQtdNegativos(vet));
        }

        public static int RetornaQtdNegativos(int[] vet, int i = 0, int qtdNegativos = 0)
        {
            if (i >= vet.Length)
            {
                return qtdNegativos;
            }
            else
            {
                if (vet[i] < 0)
                {
                    vet[i] *= -1;
                    qtdNegativos++;
                }
            }
            return RetornaQtdNegativos(vet, i + 1, qtdNegativos);
        }
    }
}