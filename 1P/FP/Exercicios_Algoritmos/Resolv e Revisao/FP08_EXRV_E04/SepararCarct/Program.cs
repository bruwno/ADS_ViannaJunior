using System;
using System.Text;

namespace SepararCarct
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("Digite uma string: ");
            string str = Console.ReadLine();

            Console.WriteLine(SepararCaracteresNumericos(str));
        }

        public static string SepararCaracteresNumericos(string str)
        {
            StringBuilder strConv = new StringBuilder();

            for (int i = 0; i < str.Length; i++)
            {
                if (EhDigito(str[i]) == true)
                {
                    strConv.Append(str[i]);
                }
            }

            return strConv.ToString();
        }

        public static bool EhDigito(char digito)
        {
            const string numeros = "0123456789";

            for (int i = 0; i < numeros.Length; i++)
            {
                if (numeros[i] == digito)
                {
                    return true;
                }
            }

            return false;
        }
    }
}