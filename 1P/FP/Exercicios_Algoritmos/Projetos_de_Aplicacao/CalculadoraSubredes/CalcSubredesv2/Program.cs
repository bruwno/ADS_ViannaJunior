/* Objetivo : Converter um endereço IPv4 em binário.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 12/09/2023
 * Material : FP0X
 * Slide    : EXTS (Exercício de extensão)
 * Exercício: 01
 */

/* Comando:
 * 1) Fazer um algoritmo que recebe uma sequência de 4 octetos (endereço IP) e 
 * converte para o seu equivalente em binário.
 */

using System;
using System.Collections.Generic;

namespace CalcSubredesv2
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Converter endereço IPv4 para binário");
            LerEndereco();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerEndereco()
        {
            Console.WriteLine("(i) Dica: Separe cada octeto utilizando o caractere ponto '.'");
            Console.Write("[i] Digite o endereço IPv4 que deseja converter: ");
            string[] enderecoDigitado = Console.ReadLine().Trim().Split(".");

            ConverterParaBin(enderecoDigitado);
        }

        private static void ConverterParaBin(string[] endereco)
        {
            int[] enderecoIP = Array.ConvertAll(endereco, int.Parse);
            int restoDivisao = 0;
            int[] octetoConv = new int[8];


            for (int i = 0; i <= enderecoIP.Length; i++)
            {
                int divisaoAtual = enderecoIP[i];

                for (int j = 0; enderecoIP[i] / 2 != 0; j++)
                {
                    // Divide o octeto por 2 até o quociente ser 0.
                    divisaoAtual /= 2;

                    restoDivisao = divisaoAtual % 2;

                    octetoConv[j] += restoDivisao;

                    Console.WriteLine(octetoConv[j]);
                }
            }
        }
    }
}