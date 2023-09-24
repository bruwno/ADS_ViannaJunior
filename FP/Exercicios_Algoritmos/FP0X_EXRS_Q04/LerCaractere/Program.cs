/* Objetivo : Ler um caractere enquanto não for digitada uma vogal.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 24/09/2023
 * Material : FP0X
 * Slide    : EXRS (Exercícios Resolvidos)
 * Exercício: 04
 */

/* Comando:
 * 4) Faça uma função que leia caracteres informados pelo usuário enquanto o caractere não for uma vogal.
 * Assim que for lida uma vogal, a função deve retorná-la. 
 * Note que esta função não recebe parâmetros. No método Main, use a sua função para ler uma vogal.
 */

using System;

namespace LerCaractere
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            char vogalDigitada = LerCaractere();
            Console.WriteLine($"\nVocê digitou a vogal {vogalDigitada}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static char LerCaractere()
        {
            Console.Write("Digite uma vogal: ");
            char caractere = Convert.ToChar(Console.ReadLine().ToLower());

            while ((caractere != 'a') && (caractere != 'e') && (caractere != 'i') && (caractere != 'o') && (caractere != 'u'))
            {
                Console.WriteLine("O caractere digitado não é uma vogal! Tente novamente.");
                Console.Write("Digite uma vogal: ");
                caractere = Convert.ToChar(Console.ReadLine().ToLower());
            }

            return caractere;
        }
    }
}