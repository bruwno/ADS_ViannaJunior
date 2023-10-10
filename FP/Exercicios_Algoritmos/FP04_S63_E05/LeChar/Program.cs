/* Objetivo : Determinar o caracetere digitado pelo usuário.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/08/2023
 * Material : FP04 (Estruturas Condicionais)
 * Slide    : 63
 * Exercício: 05
 */

/* 5. Faça um programa para ler um caractere e 
 * imprimir as seguintes mensagens, segundo o caso:
 * • “Sinal de menor”
 * • “Sinal de maior”
 * • “Sinal de igual”
 * • “Outro caractere”
 */

using System;

namespace LeChar
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Determinar caractere digitado");
            LerCaractere();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerCaractere()
        {
            Console.Write("\nDigite um caractere: ");
            char caractereDigitado = Convert.ToChar(Console.ReadLine());

            DeterminarCaractere(caractereDigitado);
        }

        private static void DeterminarCaractere(char caractereDigitado)
        {
            if (caractereDigitado == '<')
            {
                Console.WriteLine("\nSinal de menor.");
            }
            else if (caractereDigitado == '>')
            {
                Console.WriteLine("\nSinal de maior.");
            }
            else if (caractereDigitado == '=')
            {
                Console.WriteLine("\nSinal de igual.");
            }
            else
            {
                Console.WriteLine("\n[i] Outro caractere.");
            }
        }
    }
}