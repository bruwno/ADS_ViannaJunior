/* Objetivo : Imprimir os números pares entre 1 e 100.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 01/08/2023
 * Material : FP05
 * Slide    : 120
 * Exercício: 03
 * OBS.     : Esta versão permite testar vários números com uma única entrada de dados.
 ************ Propositalmente o algoritmo utilizado para testar os números não é o mais performático.
 */

/* 3. Ler um número inteiro e positivo e verificar se este é ou não um número primo.
 */

using System;
using System.Text;
using System.Collections;

namespace VerifPrimos
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Verificar números primos\n");
            ExibirMenu();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ExibirMenu()
        {
            StringBuilder menu = new StringBuilder("\n[1] Testar números" +
                                                   "\n[2] Sair" +
                                                   "\n\n[i] Digite uma opção: ");

            int opcaoSelecionada = 0;
            do
            {
                Console.Write(menu.ToString());
                opcaoSelecionada = int.Parse(Console.ReadLine()!);
            }
            while (opcaoSelecionada < 1 || opcaoSelecionada > 2);

            if (opcaoSelecionada == 1)
            {
                LerNumeros();
            }
            else
            {
                return;
            }
        }

        private static void LerNumeros()
        {
            Console.Clear();
            //
            StringBuilder instrucao = new StringBuilder("Digite os números que deseja testar" +
                                                        "\nSepare cada número por vírgula: ");

            Console.Write(instrucao.ToString());
            string[] valoresDigitados = Console.ReadLine()!.Split(",");

            int[] numeros = Array.ConvertAll(valoresDigitados, int.Parse);

            VerificarNumerosPrimos(numeros);
        }

        private static void VerificarNumerosPrimos(int[] nums)
        {
            for (int i = 0; i < nums.Length; i++)
            {
                int numeroAtual = nums[i];
                int qtdDivisores = 0;

                for (int j = 1; j <= numeroAtual; j++)
                {
                    if (numeroAtual % j == 0)
                    {
                        qtdDivisores++;
                    }
                }

                StatusDoNumeroVerificado(numeroAtual, qtdDivisores);
            }
            ExibirMenu();
        }

        private static void StatusDoNumeroVerificado(int num, int qtdDiv)
        {
            string statusNum = string.Empty;

            switch (qtdDiv)
            {
                case 2:
                    Console.ForegroundColor = ConsoleColor.Green;
                    statusNum = $"[>] O número {num} é primo";
                    break;
                default:
                    Console.ForegroundColor = ConsoleColor.DarkGray;
                    statusNum = $"[>] O número {num} NÃO é primo";
                    break;
            }

            Console.WriteLine(statusNum);
        }
    }
}