
/* Objetivo : Ler dados de veículos e exibir informações.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/11/2023
 * Material : FP09 (Classes)
 * Slide    : 45
 * Exercício: 13
 */

/* 13) Faça um programa que permita o cadastro de veículos. A classe veículo deverá conter os campos placa, marca, modelo e ano.
 * O programa deverá ter as seguintes características:
 * - No primeiro item, peça inicialmente o índice do vetor que deseja alterar.
 * - No terceiro item, peça o ano mínimo e máximo e imprima os veículos que estão nesse intervalo.
 * Faça funções para realizar as operações de cada um dos itens do menu.
 */

using System;
using System.Text;

namespace CadastroVeiculos
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Veiculo[] veiculos = new Veiculo[5];
            veiculos = new Veiculo[5]
            {
                new Veiculo { Placa = "YKB2001", Marca = "Volkswagen", Modelo = "Gol", Ano = 2012 },
                new Veiculo { Placa = "HDH9578", Marca = "Fiat", Modelo = "Uno Mille", Ano = 2006 },
                new Veiculo { Placa = "JDF7961", Marca = "Renault", Modelo = "Sandero", Ano = 2010 },
                new Veiculo { Placa = "GHJ7896", Marca = "Toyota", Modelo = "Corolla", Ano = 2015 },
                new Veiculo { Placa = "TDK7963", Marca = "GM", Modelo = "S10", Ano = 2007 }
            };

            ExibirMenu(veiculos);
        }

        private static void ExibirMenu(Veiculo[] veiculos)
        {
            StringBuilder exibeMenu = new StringBuilder("\nMenu:" +
                                                        "\n1 - Ler as informações de um veículo" +
                                                        "\n2 - Verificar se uma placa está no formato correto (AAADDDD)" +
                                                        "\n3 - Imprimir por ano" +
                                                        "\n4 - Pesquisar veículo por placa" +
                                                        "\n5 - Imprimir todos os veículos cadastrados" +
                                                        "\n6 - SAIR" +
                                                        "\n Digite uma opção: ");

            Console.Write(exibeMenu.ToString());
            int opcSelecionada = Convert.ToInt32(Console.ReadLine());

            switch (opcSelecionada)
            {
                case 1:
                    LerDadosVeiculo(veiculos);
                    break;
                case 2:
                    VerificarPlaca(veiculos);
                    break;
                case 3:
                    ImprimirPorAno(veiculos);
                    break;
                case 4:
                    PesquisarVeiculoPorPlaca(veiculos);
                    break;
                case 5:
                    ImprimirVeiculosCadastrados(veiculos);
                    break;
                case 6:
                    return;
            }
        }

        private static void LerDadosVeiculo(Veiculo[] veiculos)
        {
            Console.WriteLine("LER INFO DE UM VEÍCULO");
            Console.Write("Digite o índice que deseja consultar: ");
            int indiceBusca = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("INFORMAÇÕES CADASTRADAS");
            for (int i = 0; i < veiculos.Length; i++)
            {
                if (i == indiceBusca)
                {
                    Console.WriteLine($"PLACA : {veiculos[i].Placa}\n" +
                                      $"MARCA : {veiculos[i].Marca}\n" +
                                      $"MODELO: {veiculos[i].Modelo}\n" +
                                      $"ANO   : {veiculos[i].Ano}\n");
                }
            }

            Console.WriteLine("DIGITE AS NOVAS INFORMAÇÕES PARA O VEÍCULO");
            Console.Write("PLACA : ");
            veiculos[indiceBusca].Placa = Console.ReadLine();
            Console.Write("MARCA : ");
            veiculos[indiceBusca].Marca = Console.ReadLine();
            Console.Write("MODELO: ");
            veiculos[indiceBusca].Modelo = Console.ReadLine();
            Console.Write("ANO   : ");
            veiculos[indiceBusca].Ano = Convert.ToInt32(Console.ReadLine());

            ExibirMenu(veiculos);
        }

        private static void VerificarPlaca(Veiculo[] veiculos)
        {
            Console.WriteLine("VERIFICAR FORMATO DE PLACA");
            Console.Write("Digite o índice do veículo que deseja verificar: ");
            int indiceVerif = Convert.ToInt32(Console.ReadLine());

            for (int i = 0; i < veiculos.Length; i++)
            {
                if (i == indiceVerif)
                {
                    string placaVerificada = veiculos[i].Placa;

                    Console.WriteLine($"PLACA: {placaVerificada}");
                    // Verificar comprimento.
                    if (placaVerificada.Length < 7 || placaVerificada.Length > 7)
                    {
                        Console.WriteLine("[FORMATO INCORRETO] Comprimento inválido!");
                        break;
                    }

                    // Verificar a sequência de caracteres alfabéticos.
                    if (EhCaractereAlfabetico(placaVerificada[0]) && EhCaractereAlfabetico(placaVerificada[1]) && EhCaractereAlfabetico(placaVerificada[2]) == true)
                    {
                        // Verificar a sequência de caracteres numéricos.
                        if (EhCaractereNumerico(placaVerificada[3]) && EhCaractereNumerico(placaVerificada[4]) && EhCaractereNumerico(placaVerificada[5]) == true)
                        {
                            Console.WriteLine($"A placa {placaVerificada} está no formato correto.");
                        }
                        else
                        {
                            Console.WriteLine("[FORMATO INCORRETO] Os quatro últimos dígitos devem ser números.");
                        }
                    }
                    else
                    {
                        Console.WriteLine("[FORMATO INCORRETO] Os três primeiros caracteres devem ser letras maiúsculas.");
                    }
                }
            }

            ExibirMenu(veiculos);
        }

        private static void ImprimirPorAno(Veiculo[] veiculos)
        {
            Console.WriteLine("");
        }

        private static void PesquisarVeiculoPorPlaca(Veiculo[] veiculos)
        {

        }

        private static void ImprimirVeiculosCadastrados(Veiculo[] veiculos)
        {

        }

        // Métodos que fornecem funcionalidades para os métodos principais.
        private static bool EhCaractereAlfabetico(char caractere)
        {
            if (caractere >= 'A' && caractere <= 'Z')
            {
                return true;
            }

            return false;
        }

        private static bool EhCaractereNumerico(char caractere)
        {
            string caracteresNumericos = "0123456789";

            for (int i = 0; i < caracteresNumericos.Length; i++)
            {
                if (caracteresNumericos[i] == caractere)
                {
                    return true;
                }
            }

            return false;
        }
    }
}
