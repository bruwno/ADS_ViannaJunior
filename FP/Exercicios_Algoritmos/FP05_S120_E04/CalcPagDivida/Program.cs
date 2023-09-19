/* Objetivo : Determinar o tempo necessário para pagamento de uma dívida com o rendimento de uma aplicação financeira.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 05/09/2023
 * Material : FP05
 * Slide    : 120
 * Exercício: 04
 *******************************************************************************************************
 * OBS.     : Esta versão permite testar vários números em uma única entrada de dados, utilizando array.
 *            Propositalmente o algoritmo utilizado para testar os números não é o mais performático.
 *            A classe NumerosPrimos contém o algoritmo que realiza os testes com os valores.
 *******************************************************************************************************
 */

/* 4. Dada uma dívida de 10000 reais que cresce a juros de 2,5% ao mês e uma aplicação de 1500 reais com
 * rendimento de 4% ao mês, escrever um algoritmo que determina o número de meses necessários para pagar a dívida.
 */

using System;

namespace CalcPagDivida
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine();
            ObterQtdMeses();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterQtdMeses()
        {
            decimal valorDaDivida = 10000m;
            decimal valorDaAplicacao = 1500m;
            decimal taxaDeJurosDivida = 0.025m;
            decimal taxaDeRendimentoAplic = 0.04m;

            int tempoParaPagamento = CalcularPagamentoDivida(valorDaDivida, taxaDeJurosDivida, valorDaAplicacao, taxaDeRendimentoAplic);
            //double tempoEmAnos = tempoParaPagamento / 12.0;

            Console.WriteLine($"[>] Serão necessários {tempoParaPagamento} meses para quitar o valor devido.");// +
                                                                                                               //$"\nO que equivale a aproximadamente {tempoEmAnos:N1} anos.");
        }

        private static int CalcularPagamentoDivida(decimal valorDivida, decimal taxaJurosDiv, decimal valorAplicacao, decimal taxaRendAplic)
        {
            int qtdMeses = 0;
            decimal valorFinalDivida = valorDivida, valorFinalAplicacao = valorAplicacao;

            while (valorFinalAplicacao <= valorFinalDivida)
            {
                valorFinalDivida += valorFinalDivida * taxaJurosDiv;
                valorFinalAplicacao += valorFinalAplicacao * taxaRendAplic;
                qtdMeses++;
            }

            return qtdMeses;
        }
    }
}