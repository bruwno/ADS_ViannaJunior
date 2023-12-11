
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
                new Veiculo { Placa = "HDH9575", Marca = "Fiat", Modelo = "Uno Mille", Ano = 2006 },
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
                    Console.Clear();
                    LerDadosVeiculo(veiculos);
                    break;
                case 2:
                    Console.Clear();
                    VerificarPlaca(veiculos);
                    break;
                case 3:
                    Console.Clear();
                    ImprimirPorAno(veiculos);
                    break;
                case 4:
                    Console.Clear();
                    PesquisarVeiculoPorPlaca(veiculos);
                    break;
                case 5:
                    Console.Clear();
                    ImprimirVeiculosCadastrados(veiculos);
                    break;
                case 6:
                    Console.Clear();
                    Console.WriteLine("Você escolheu sair...");
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
        DigitarPlaca:
            Console.Write("PLACA : ");
            string placa = Console.ReadLine();
            if (PlacaEhValida(placa) == true)
            {
                veiculos[indiceBusca].Placa = placa;
            }
            else
            {
                goto DigitarPlaca;
            }

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

                    PlacaEhValida(placaVerificada);
                }
            }

            ExibirMenu(veiculos);
        }

        private static void ImprimirPorAno(Veiculo[] veiculos)
        {
            Console.WriteLine("IMPRIMIR VEÍCULOS POR ANO");
            Console.WriteLine("Digite o intervalo que deseja exibir: ");
            Console.Write("  Ano inicial: ");
            int anoInicial = Convert.ToInt32(Console.ReadLine());
            Console.Write("  Ano final  : ");
            int anoFinal = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine($"VEÍCULOS CADASTRADOS COM ANOS ENTRE {anoInicial} e {anoFinal}");
            for (int i = 0; i < veiculos.Length; i++)
            {
                if (veiculos[i].Ano >= anoInicial && veiculos[i].Ano <= anoFinal)
                {
                    Console.WriteLine($"PLACA : {veiculos[i].Placa}\n" +
                                      $"MARCA : {veiculos[i].Marca}\n" +
                                      $"MODELO: {veiculos[i].Modelo}\n" +
                                      $"ANO   : {veiculos[i].Ano}\n");
                }
            }

            ExibirMenu(veiculos);
        }

        private static void PesquisarVeiculoPorPlaca(Veiculo[] veiculos)
        {
            Console.WriteLine("PESQUISAR VEÍCULO POR PLACA");
            Console.Write("Digite a placa para exibir os dados do veículo: ");
            string placa = Console.ReadLine();

            int indiceVeiculo = VerificarSeVeiculoEstaCadastrado(veiculos, placa);

            Console.WriteLine("\nDADOS DO VEÍCULO");
            if (indiceVeiculo != -1)
            {
                Console.WriteLine($"PLACA : {veiculos[indiceVeiculo].Placa}\n" +
                                  $"MARCA : {veiculos[indiceVeiculo].Marca}\n" +
                                  $"MODELO: {veiculos[indiceVeiculo].Modelo}\n" +
                                  $"ANO   : {veiculos[indiceVeiculo].Ano}\n");
            }
            else
            {
                Console.WriteLine("A placa digitada não está associada a nenhum dos veículos cadastrados.");
            }


            ExibirMenu(veiculos);
        }

        private static void ImprimirVeiculosCadastrados(Veiculo[] veiculos)
        {
            Console.WriteLine("EXIBIR VEÍCULOS CADASTRADOS");
            for (int i = 0; i < veiculos.Length; i++)
            {
                Console.WriteLine($"PLACA : {veiculos[i].Placa}\n" +
                                  $"MARCA : {veiculos[i].Marca}\n" +
                                  $"MODELO: {veiculos[i].Modelo}\n" +
                                  $"ANO   : {veiculos[i].Ano}\n");

            }

            ExibirMenu(veiculos);
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

        private static bool PlacaEhValida(string placa)
        {
            // Verificar comprimento.
            if (placa.Length < 7 || placa.Length > 7)
            {
                Console.WriteLine("[FORMATO INCORRETO] Comprimento inválido!");
                return false;
            }

            // Verificar a sequência de caracteres alfabéticos.
            if (EhCaractereAlfabetico(placa[0]) && EhCaractereAlfabetico(placa[1]) && EhCaractereAlfabetico(placa[2]) == true)
            {
                // Verificar a sequência de caracteres numéricos.
                if (EhCaractereNumerico(placa[3]) && EhCaractereNumerico(placa[4]) && EhCaractereNumerico(placa[5]) == true)
                {
                    Console.WriteLine($"A placa {placa} está no formato correto.");
                    return true;
                }
                else
                {
                    Console.WriteLine("[FORMATO INCORRETO] Os quatro últimos dígitos devem ser números.");
                    return false;
                }
            }
            else
            {
                Console.WriteLine("[FORMATO INCORRETO] Os três primeiros caracteres devem ser letras maiúsculas.");
                return false;
            }
        }

        private static int VerificarSeVeiculoEstaCadastrado(Veiculo[] veiculos, string placa)
        {
            int indiceOcorrencia = -1;

            for (int i = 0; i < veiculos.Length; i++)
            {
                if (veiculos[i].Placa == placa)
                {
                    indiceOcorrencia = i;
                }
            }

            return indiceOcorrencia;
        }
    }
}
