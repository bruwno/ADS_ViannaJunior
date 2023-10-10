/* Objetivo : Ler 10 valores e armazenar na mesma variável | Nesta versão: utilizando array.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 07/09/2023
 * Material : FP05 (Comandos de Repetição)
 * Slide    : 126
 * Exercício: 02
 */

/* 2) Escreva um algoritmo que leia 10 valores (usando a mesma variável) e 
 * encontre o maior e o menor deles. Mostre o resultado.
 */

using System;
using System.Text;
using LeValoresArr.Utils;

namespace LeValoresArr
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Ler valores e exibir menor e maior");
            LerValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerValores()
        {
            StringBuilder instrucao = new StringBuilder("\n[i] Digite 10 valores" +
                                                        "\n(i) Separe cada valor por vírgula | Para encerrar digite: sair" +
                                                        "\n[>] ");
            Console.Write(instrucao.ToString());
            // Captura dos valores.
            string[] valoresDigitados = Console.ReadLine()!.Trim().Split(",");

            if (valoresDigitados[0] == "sair")
            {
                EncerrarExecucao();
            }
            else
            {
                // Conversão dos dados.
                int[] valores = Array.ConvertAll(valoresDigitados, int.Parse);
                // Validação do tamanho do array.
                bool qtdEhValida = Validacoes.ValidarQtdValores(valores);

                switch (qtdEhValida)
                {
                    case true:
                        DeterminarMenorEMaior(valores);
                        break;
                    case false:
                        Validacoes.ExibirMsgQtdInvalida(valores);
                        LerValores();
                        break;
                }
            }
        }

        private static void DeterminarMenorEMaior(int[] val)
        {
            int menor = 0, maior = 0;

            for (int i = 0; i < 10; i++)
            {
                if (menor == 0 || val[i] < menor)
                {
                    menor = val[i];
                }
                else if (val[i] > maior)
                {
                    maior = val[i];
                }
            }

            Console.WriteLine($"\n[>] Menor valor: {menor}" +
                              $"\n[>] Maior valor: {maior}");
        }

        private static void EncerrarExecucao()
        {
            return;
        }
    }
}
