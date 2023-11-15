using System;

namespace VerificaPrimos
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Verificar números primos");
            LerValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerValores()
        {
            Console.Write("\n[i] Digite os números que deseja verificar\n" +
            "[Separe os números por vírgula]: ");
            string[] valores = Console.ReadLine()!.Split(",");

            int[] nums = Array.ConvertAll(valores, int.Parse);
            VerificarPrimos(nums);
        }

        private static void VerificarPrimos(int[] num)
        {   
            for (int i = 0; i < num.Length; i++) 
            {
                int qtdDiv = 0;
                int numAtual = num[i];
                
                for (int j = 1; j <= numAtual; j++)
                {
                    if (numAtual % j == 0) 
                    {
                        qtdDiv++;
                    }
                }

                if (qtdDiv == 2)
                {
                    Console.WriteLine($"{numAtual} é primo.");
                }
                else
                {
                    Console.WriteLine($"{numAtual} não é primo.");
                }
            }
        }
    }
}
