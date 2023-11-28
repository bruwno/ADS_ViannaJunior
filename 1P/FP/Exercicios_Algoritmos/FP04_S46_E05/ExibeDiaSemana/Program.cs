/* Objetivo : Exibir o dia da semana e acordo com o número digitado.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 23/08/2023
 * Material : FP04 (Estruturas Condicionais)
 * Slide    : 46
 * Exercício: 05
 */

/* Comando:
 * 5) Desenvolver um algoritmo para ler o número do dia da semana e imprimir o seu respectivo nome por extenso. 
 * Considerar o número 1 como domingo, 2 para segunda etc. Caso o dia da semana não exista (menor do que 1 ou maior do que 7), exibir a mensagem “Dia da semana inválido".
 */

using System;

namespace ExibeDiaSemana
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Exibir dia da semana\n");
            LerEntrada();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerEntrada()
        {
            Console.Write("[i] Digite um número inteiro [de 1 a 7]: ");
            int numeroDia = Convert.ToInt32(Console.ReadLine());
            ExibirDiaDaSemana(numeroDia);
        }

        private static void ExibirDiaDaSemana(int numDia)
        {
            if (numDia == 1)
            {
                Console.WriteLine("\n[>] Domingo");
            }
            else if (numDia == 2)
            {
                Console.WriteLine("\n[>] Segunda-feira");
            }
            else if (numDia == 3)
            {
                Console.WriteLine("\n[>] Terça-feira");
            }
            else if (numDia == 4)
            {
                Console.WriteLine("\n[>] Quarta-feira");
            }
            else if (numDia == 5)
            {
                Console.WriteLine("\n[>] Quinta-feira");
            }
            else if (numDia == 6)
            {
                Console.WriteLine("\n[>] Sexta-Feira");
            }
            else if (numDia == 7)
            {
                Console.WriteLine("\n[>] Sábado");
            }
            else
            {
                Console.WriteLine("\n[!] Dia da semana inválido!");
            }
        }
    }
}