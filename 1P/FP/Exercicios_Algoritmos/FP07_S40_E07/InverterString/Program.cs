/* Objetivo : Inverter uma String.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/10/2023
 * Material : FP07 (Strings)
 * Slide    : 40
 * Exercício: 07
 */

/* 7) Crie um procedimento que receba uma string e imprima a string invertida.
 * Exemplo:
 * Entrada: Teste
 * Saída: etseT
 */

 using System;
 using System.Text;

 namespace InverterString
 {
    internal class Program
    {
        internal static void Main(string[] args)
        {
            string str = "Teste";
            InverteString(str);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void InverteString(string str)
        {
            StringBuilder strInvertida = new StringBuilder();

            for (int i = str.Length - 1; i >= 0; i--) 
            {
                char caractere = str[i];
                strInvertida.Append(caractere); 
            }

            Console.WriteLine($"String original: {str} - String invertida: {strInvertida.ToString()}");
        }
    }
 }