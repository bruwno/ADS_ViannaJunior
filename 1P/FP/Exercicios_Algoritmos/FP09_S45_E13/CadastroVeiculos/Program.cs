
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
            ExibirMenu();
        }

        private static void ExibirMenu()
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
                    LerDadosVeiculo();
                    break;
                case 2:
                    VerificarPlaca();
                    break;
                case 3:
                    ImprimirPorAno();
                    break;
                case 4:
                    PesquisarVeiculoPorPlaca();
                    break;
                case 5:
                    ImprimirVeiculosCadastrados();
                    break;
                case 6:
                    return;
            }
        }

        private static void LerDadosVeiculo()
        {

        }

        private static void VerificarPlaca()
        {

        }

        private static void ImprimirPorAno()
        {

        }

        private static void PesquisarVeiculoPorPlaca()
        {

        }

        private static void ImprimirVeiculosCadastrados()
        {

        }
    }
}
