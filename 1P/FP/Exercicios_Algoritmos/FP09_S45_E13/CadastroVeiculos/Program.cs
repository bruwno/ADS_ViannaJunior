
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
        }

        private static void VerificarPlaca(Veiculo[] veiculos)
        {

        }

        private static void ImprimirPorAno(Veiculo[] veiculos)
        {

        }

        private static void PesquisarVeiculoPorPlaca(Veiculo[] veiculos)
        {

        }

        private static void ImprimirVeiculosCadastrados(Veiculo[] veiculos)
        {

        }
    }
}
