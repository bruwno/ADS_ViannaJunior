/* Objetivo : Informar uma idade e determinar a classificação do nadador.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/08/2023
 * Material : FP04 (Estruturas Condicionais)
 * Slide    : 64
 * Exercício: 05
 */

/* 6. Elabore um programa que, dada a idade de um nadador, classifique-o
 * em uma das seguintes categorias:
 * • infantil A = 5 – 7 anos
 * • infantil B = 8 – 10 anos
 * • juvenil A = 11 – 13 anos
 * • juvenil B = 14 – 17 anos
 * • adulto = 18 – 30 anos
 * • sênior = maiores de 30 anos
 */

using System;

namespace ClassifNadador
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("");
            LerIdade();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerIdade()
        {
            Console.Write("[i] Digite a idade do nadador: ");
            int idadeNadador = Convert.ToInt32(Console.ReadLine());

            ClassificaNadador(idadeNadador);
        }

        private static void ClassificaNadador(int idade)
        {
            if ((idade >= 5) && (idade <= 7))
            {
                Console.WriteLine("\nInfantil A");
            }
            else if ((idade >= 8) && (idade <= 10))
            {
                Console.WriteLine("\nInfantil B");
            }
            else if ((idade >= 11) && (idade <= 13))
            {
                Console.WriteLine("\nJuvenil A");
            }
            else if ((idade >= 14) && (idade <= 17))
            {
                Console.WriteLine("\nJuvenil B");
            }
            else if ((idade >= 18) && (idade <= 30))
            {
                Console.WriteLine("\nAdulto");
            }
            else if (idade > 30)
            {
                Console.WriteLine("\nSênior.");
            }
        }
    }
}
