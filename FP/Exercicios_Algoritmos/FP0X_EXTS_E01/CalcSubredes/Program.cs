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
            Console.Title = "Converter IP";
            Console.WriteLine("Converter endereço IPv4 para binário\n");
            Menu.ExibirMenu();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        internal static void LerEnderecoIP()
        {
            Console.Clear();
            Console.WriteLine("(i) Dica: Separe cada octeto utilizando o caractere ponto '.'", Console.ForegroundColor = ConsoleColor.DarkGray);
            Console.ForegroundColor = ConsoleColor.Gray;
            Console.Write("[i] Digite o endereço IPv4 que deseja converter: ");

            try
            {
                string[] enderecoDigitado = Console.ReadLine()!.Trim().Split(".");
                int[] enderecoIPv4 = Array.ConvertAll(enderecoDigitado, int.Parse);

                foreach (int octeto in enderecoIPv4)
                {

                    if (Validacoes.ValidarQtdDigitosIP(octeto) == false)
                    {
                        Erro.QtdDigitosDoOctetoInvalida();
                        LerEnderecoIP();
                    }
                    if (Validacoes.ValidarIPDigitado(octeto) == false)
                    {
                        Erro.ValorDoOctetoInvalido();
                        LerEnderecoIP();
                    }
                    else if ((Validacoes.ValidarQtdDigitosIP(octeto) == true) && (Validacoes.ValidarIPDigitado(octeto) == true))
                    {
                        // Converte para binário.
                        List<string> enderecoConvertido = EnderecoIP.ConverterParaBin(octeto);
                        // União dos itens da lista em uma única String.
                        string enderecoBinario = string.Join("", enderecoConvertido);

                        Console.WriteLine($"\n[>] O octeto {octeto} em binário: {enderecoBinario}");
                    }
                }

                EnderecoIP.ExibirClasseDoIPDigitado(enderecoIPv4);
                Menu.ExibirRetornarAoMenu();
            }
            catch (Exception)
            {
                Erro.CaractereDigitadoInvalido();
                LerEnderecoIP();
            }
        }

        internal static void Encerrar()
        {
            Console.WriteLine(@"[\o/] Até a próxima meu consagrado...", Console.ForegroundColor = ConsoleColor.Blue);
            Console.ForegroundColor = ConsoleColor.Gray;
            return;
        }
    }
}