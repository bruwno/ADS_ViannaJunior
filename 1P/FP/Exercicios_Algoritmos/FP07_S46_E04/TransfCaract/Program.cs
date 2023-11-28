/* Objetivo : Separar os caracteres de uma frase em vogais e consoantes.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 23/10/2023
 * Material : FP07 (Strings)
 * Slide    : 46
 * Exercício: 04
 */

/* 4) Fazer um programa para ler uma string e transferir as consoantes para uma string e as vogais para outra. 
 * Depois mostre cada uma das strings.
 */

 using System;
 using System.Text;

 namespace TransfCaract
 {
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("Digite um frase: ");
            string str = Console.ReadLine();

            TransferirCaracteres(str);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void TransferirCaracteres(string str)
        {
            Console.WriteLine($"Apenas as vogais    : {JuntarVogais(str)}");
            Console.WriteLine($"Apenas as consoantes: {JuntarConsoantes(str)}");
        }

        private static string JuntarVogais(string str)
        {
            StringBuilder vogais = new StringBuilder();

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];
                if (EhVogal(caractere) == true)
                {
                    vogais.Append(caractere);
                }
            }

            return vogais.ToString();
        }

        private static string JuntarConsoantes(string str)
        {
            StringBuilder consoantes = new StringBuilder();

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];
                if (EhVogal(caractere) == false)
                {
                    consoantes.Append(caractere);
                }
            }

            return consoantes.ToString();
        }

        private static bool EhVogal(char caractere)
        {
            switch(caractere)
            {
                case 'a':
                    return true;
                    break;
                case 'e':
                    return true;
                    break;
                case 'i':
                    return true;
                    break;
                case 'o':
                    return true;
                    break;
                case 'u':
                    return true;
                    break;
                default:
                    return false;
                    break;
            }
        }
    }
 }