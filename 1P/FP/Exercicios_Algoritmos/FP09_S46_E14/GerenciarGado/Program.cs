/* Objetivo : Gerenciar dados sobre as cabeças de gado de uma fazenda.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 11/12/2023
 * Material : FP09 (Classes)
 * Slide    : 46
 * Exercício: 14
 */

/* 14) Elabore um programa que auxilie no controle de uma fazenda de gado que possua um total de 100 cabeças de gado.
 * O programa deverá conter uma classe que comporte:
 * - código: código da cabeça de gado;
 * - leite: número de litros de leite produzido por semana;
 * - alimento: quantidade de alimento ingerida por semana (kg);
 * - mês de nascimento;
 * - ano de nascimento;
 * - abate: ‘N”(não) ou ‘S’ (sim).
 *
 * O seu programa deverá conter um menu com as seguintes funcionalidades:
 * (a) Ler a base de dados (código, leite, alimento, nascimento) informados pelo usuário e armazenar em um vetor de estruturas.
 * (b) Preencher o campo abate, considerando que a cabeça de gado irá para o abate caso:
 * - tenha mais de 5 anos, ou;
 * - produza menos de 40 litros de leite por semana, ou;
 * - produza entre 50 e 70 litros de leite por semana e ingira mais de 50 quilos de alimento por semana.
 * (c) Imprimir a quantidade total de leite produzida por semana na fazenda.
 * (d) Imprimir a quantidade total de alimento consumido por semana na fazenda.
 * (e) Imprimir a quantidade total de leite que vai ser produzido por semana na fazenda, após o abate
 * (f) Imprimir a quantidade total de alimento que vai ser consumido por semana na fazenda, após o abate
 * (g) Imprimir número de cabeças de gado que irão para o abate.
 * (h) Inclua uma opção para sair do menu.
 */

using System;
using System.Text;

namespace GerenciarGado
{
    internal class Program
    {
        const int qtdCabecasGado = 100;
        internal static void Main(string[] args)
        {
            Gado[] gados = new Gado[qtdCabecasGado];

            // Iniciar o array preenchido.
            /*gados = new Gado[qtdCabecasGado]
            {
                new Gado { Codigo = 1, Leite = 20.0, Alimento = 40.0, MesNascimento = 12, AnoNascimento = 2021, Abate = 'N' },
                new Gado { Codigo = 2, Leite = 40.0, Alimento = 45.0, MesNascimento = 10, AnoNascimento = 2019, Abate = 'S' }
            };*/

            ExibirMenu(gados);
        }

        private static void ExibirMenu(Gado[] gados)
        {
            StringBuilder exibeMenu = new StringBuilder("1 - Cadastrar dados\n" +
                                                        "2 - Imprimir quantidade total de leite produzido por semana\n" +
                                                        "3 - Imprimir quantidade total de alimento consumido por semana\n" +
                                                        "4 - Imprimir quantidade total de leite produzido após abate\n" +
                                                        "5 - Imprimir quantidade total de alimento consumido após abate\n" +
                                                        "6 - Imprimir quantidade de cabeças de gado que irão para o abate\n" +
                                                        "7 - SAIR\n" +
                                                        "[>] Digite uma opção: ");
            Console.Write(exibeMenu.ToString());
            int opcDigitada = Convert.ToInt32(Console.ReadLine());

            switch (opcDigitada)
            {
                case 1:
                    Console.Clear();
                    CadastrarDados(gados);
                    break;
                case 2:
                    Console.Clear();
                    TotalLeiteProdSemana(gados);
                    break;
                case 3:
                    Console.Clear();
                    TotalAlimentoConsumidoSemana(gados);
                    break;
                case 4:
                    Console.Clear();
                    TotalLeiteProdAposAbate(gados);
                    break;
                case 5:
                    Console.Clear();
                    TotalAlimentoConsumidoAposAbate(gados);
                    break;
                case 6:
                    Console.Clear();
                    QtdCabecasGadoParaAbate(gados);
                    break;
                case 7:
                    Console.Clear();
                    Console.WriteLine("Você escolheu sair...");
                    return;
            }
        }

        private static void CadastrarDados(Gado[] gados)
        {
            Console.WriteLine("Digite os dados dos animais");
            for (int i = 0; i < gados.Length; i++)
            {
                Console.WriteLine($"\nDados da {i + 1}ª cabeça de gado");
                gados[i] = LerERetornarDados();
            }

            ExibirMenu(gados);
        }

        private static void TotalLeiteProdSemana(Gado[] gados)
        {
            double totalLitros = 0.0;

            for (int i = 0; i < gados.Length; i++)
            {
                totalLitros += gados[i].Leite;
            }

            Console.WriteLine($"\nSÃO PRODUZIDOS {totalLitros} litros DE LEITE POR SEMANA.\n");

            ExibirMenu(gados);
        }

        private static void TotalAlimentoConsumidoSemana(Gado[] gados)
        {
            double totalKilos = 0.0;

            for (int i = 0; i < gados.Length; i++)
            {
                totalKilos += gados[i].Alimento;
            }

            Console.WriteLine($"\nSÃO CONSUMIDOS {totalKilos} kg DE ALIMENTO POR SEMANA.\n");

            ExibirMenu(gados);
        }

        private static void TotalLeiteProdAposAbate(Gado[] gados)
        {
            double totalLitrosAposAbate = 0.0;

            for (int i = 0; i < gados.Length; i++)
            {
                if (gados[i].Abate == 'N')
                {
                    totalLitrosAposAbate += gados[i].Leite;
                }
            }

            Console.WriteLine($"\nSERÃO PRODUZIDOS {totalLitrosAposAbate} litros DE LEITE POR SEMANA APÓS OS ABATES.\n");

            ExibirMenu(gados);
        }

        private static void TotalAlimentoConsumidoAposAbate(Gado[] gados)
        {
            double totalKilosAposAbate = 0.0;

            for (int i = 0; i < gados.Length; i++)
            {
                if (gados[i].Abate == 'N')
                {
                    totalKilosAposAbate += gados[i].Alimento;
                }
            }

            Console.WriteLine($"\nSERÃO CONSUMIDOS {totalKilosAposAbate} kg DE ALIMENTO POR SEMANA APÓS OS ABATES.\n");

            ExibirMenu(gados);
        }

        private static void QtdCabecasGadoParaAbate(Gado[] gados)
        {
            int qtdCabecasParaAbate = 0;

            for (int i = 0; i < gados.Length; i++)
            {
                if (gados[i].Abate == 'S')
                {
                    qtdCabecasParaAbate++;
                }
            }

            Console.WriteLine($"\n{qtdCabecasParaAbate} CABEÇAS DE GADO QUE IRÃO PARA O ABATE.\n");

            /*
            // Exibe os códigos das cabeças de gado que serão abatidas.
            for (int j = 0; j < gados.Length; j++)
            {
                if (gados[j].Abate == 'S')
                {
                    Console.Write($"Códigos: {gados[j].Codigo}");
                }
            }
            */

            ExibirMenu(gados);
        }

        // Métodos de suporte.
        private static Gado LerERetornarDados()
        {
            Gado gado = new Gado();
            Console.Write("  CÓDIGO: ");
            gado.Codigo = Convert.ToInt32(Console.ReadLine());
            Console.Write("  LEITE (litros p/sem) : ");
            gado.Leite = Convert.ToDouble(Console.ReadLine());
            Console.Write("  ALIMENTO (kg p/sem)  : ");
            gado.Alimento = Convert.ToDouble(Console.ReadLine());
            Console.Write("  MÊS NASCIMENTO : ");
            gado.MesNascimento = Convert.ToInt32(Console.ReadLine());
            Console.Write("  ANO NASCIMENTO : ");
            gado.AnoNascimento = Convert.ToInt32(Console.ReadLine());

            //
            double idadeGado = CalcularIdade(gado.MesNascimento, gado.AnoNascimento);

            if ((idadeGado > 5.0) || (gado.Leite < 40.0) || (gado.Leite >= 50.0 && gado.Leite <= 70.0 && gado.Alimento > 50.0))
            {
                gado.Abate = Convert.ToChar('S');
            }
            else
            {
                gado.Abate = Convert.ToChar('N');
            }

            return gado;
        }

        private static double CalcularIdade(int mesNasc, int anoNasc)
        {
            double meses = DateTime.Now.Month - mesNasc;
            double anos = DateTime.Now.Year - anoNasc;

            double idadeMeses = (anos + meses) * 12;
            double idade = idadeMeses / 12;

            return idade;
        }
    }
}