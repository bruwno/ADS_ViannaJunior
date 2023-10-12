/* Objetivo : .
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 11/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 114
 * Exercício: 08
 */

/* 8) Faça um programa que leia um vetor G[13] que é o gabarito de um teste da loteria esportiva, contendo os valores 1 quando for coluna 1, 
 * 0 quando for coluna do meio e 2 quando for coluna 2.
 * Ler a seguir, para 5 apostadores, seu cartão de apostas (R[13]) e depois da leitura imprimir quantos acertos o apostador teve.
 * Faça o teste através de funções.
 */

 using System;

 namespace LerCartaoLoteria
 {
        internal class Program
        {
            internal static void Main(string[] args)
            {
                Console.WriteLine();
                int[] g = new int[13];
                int[] apostador1 = new int[13];
                int[] apostador2 = new int[13];
                int[] apostador3 = new int[13];
                int[] apostador4 = new int[13];
                int[] apostador5 = new int[13];

                Console.WriteLine("Preencha o gabarito: ");
                for (int i = 0, j = 1; i < g.Length; i++, j++) 
                {
                    Console.Write($"Digite o {j}º valor: ");
                    g[i] = Convert.ToInt32(Console.ReadLine());
                }

                Console.WriteLine("Preencha o cartão de apostas: ");
                Console.WriteLine("\nCartão do apostador 1:");
                for (int i = 0; i < apostador1.Length; i++)
                {
                    Console.Write($"Digite o {j}º valor: ");
                    g[i] = Convert.ToInt32(Console.ReadLine());
                }

                Console.WriteLine("\nCartão do apostador 2:");
                for (int i = 0; i < apostador2.Length; i++) 
                {

                }

                Console.WriteLine("\nCartão do apostador 3:");
                for (int i = 0; i < apostador3.Length; i++) 
                {

                }

                Console.WriteLine("\nCartão do apostador 4:");
                for (int i = 0; i < apostador4.Length; i++)
                {

                }

                Console.WriteLine("\nCartão do apostador 5:");
                for (int i = 0; i < apostador5.Length; i++) 
                {

                }

            }

            private static int ContabilizarAcertos(int[] vet)
            {

            }
        }
 }