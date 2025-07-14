/* Objetivo : Determinar o menor valor de um conjunto de inteiros.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 10/09/2023
 * Material : FP05 (Comandos de Repetição)
 * Slide    : 127
 * Exercício: 06
 */

/* Comando:
 * 6) Faça um programa que, dado um conjunto de valores inteiros e positivos
 * (fornecidos um a um pelo usuário), determine qual o menor valor do conjunto.
 * O final do conjunto de valores é conhecido através do valor zero, que não deve ser considerado.
 */

using System;

namespace LeValCnjt
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Determinar menor valor do conjunto\n");
            LerValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerValores()
        {
            Console.WriteLine("(i) Para interromper a leitura dos valores digite 0\n");
            int menorValor = DeterminarMenorValor();

            switch (menorValor)
            {
                case 0:
                    Console.WriteLine("[>] Nenhum valor foi digitado.");
                    break;
                default:
                    Console.WriteLine("(i) Leitura de valores interrompida.");
                    Console.WriteLine($"[>] O menor valor digitado foi: {menorValor}");
                    break;
            }
        }

        private static int DeterminarMenorValor()
        {
            int menor = 0, valorDigitado;

            Console.Write("[i] Digite um valor inteiro: ");
            valorDigitado = Convert.ToInt32(Console.ReadLine());

            while (valorDigitado != 0)
            {
                if (menor == 0 || valorDigitado < menor && valorDigitado != 0)
                {
                    menor = valorDigitado;
                }

                Console.Write("[i] Digite um valor inteiro: ");
                valorDigitado = Convert.ToInt32(Console.ReadLine());
            }
            /*
            do
            {

            } while (valorDigitado != 0);*/

            return menor;
        }
    }
}