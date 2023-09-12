/* Objetivo : Converter um endereço IPv4 em binário..
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

namespace CalcSubredes
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Converter endereço IPv4 para binário\n");
            LerEndereco();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerEndereco()
        {
            Console.WriteLine("(i) Dica: Separe cada octeto utilizando o caractere ponto '.'");
            Console.Write("[i] Digite o endereço IPv4 que deseja converter: ");

            string[] enderecoDigitado = Console.ReadLine()!.Trim().Split(".");
            int[] enderecoIPv4 = Array.ConvertAll(enderecoDigitado, int.Parse);

            foreach (int octeto in enderecoIPv4)
            {
                // Conversão.
                List<string> enderecoConvertido = ConverterParaBin(octeto);
                // União dos itens da lista em uma única String.
                string enderecoBinario = string.Join("", enderecoConvertido);

                Console.WriteLine($"[>] O octeto {octeto} em binário: {enderecoBinario}");
            }
        }

        private static List<string> ConverterParaBin(int octeto)
        {
            string octetoBin = Convert.ToString(octeto, 2).PadLeft(8, '0');
            List<string> listaDigitosBin = new List<string>();

            foreach (char bit in octetoBin)
            {
                listaDigitosBin.Add(bit.ToString());
            }

            return listaDigitosBin;
        }
    }
}