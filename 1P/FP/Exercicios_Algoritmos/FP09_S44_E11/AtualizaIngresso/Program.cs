/* Objetivo : Ler atualizar os valores de um ingresso.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/11/2023
 * Material : FP09 (Classes)
 * Slide    : 44
 * Exercício: 11
 */

/* 11) Utilizando a classe definida no exercício anterior.
 * Faça um procedimento que recebe um parâmetro do tipo ingresso e outro contendo um novo preço que atualiza o preço do ingresso para o novo valor. 
 * E um procedimento que recebe um parâmetro do tipo ingresso e mostra na tela os valores de seus campos.
 */

using System;

namespace AtualizaIngresso
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Ingresso[] ingressos = new Ingresso[3];

            for (int i = 0; i < ingressos.Length; i++)
            {
                Console.WriteLine($"Digite os dados do {i + 1}º ingresso:");
                ingressos[i] = LerDadosDeIngressos();
            }

            Console.Write("Digite o novo valor deste ingresso  R$: ");
            double novoValor = Convert.ToDouble(Console.ReadLine());

            AtualizarValorIngresso(ingressos, novoValor);
            ExibirDadosIngresso(ingressos);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static Ingresso LerDadosDeIngressos()
        {
            Ingresso ingresso = new Ingresso();

            Console.Write("Atração: ");
            ingresso.Atracao = Console.ReadLine();
            Console.Write("Local  : ");
            ingresso.Local = Console.ReadLine();
            Console.Write("Preço  : ");
            ingresso.Preco = Convert.ToDouble(Console.ReadLine());

            return ingresso;
        }

        private static void AtualizarValorIngresso(Ingresso[] ingresso, double novoPreco)
        {
            Console.Write("Digite o ingresso que deseja modificar: ");
            int posicaoIngresso = Convert.ToInt32(Console.ReadLine());

            posicaoIngresso = posicaoIngresso - 1;

            ingresso[posicaoIngresso].Preco = novoPreco;
        }

        private static void ExibirDadosIngresso(Ingresso[] ingresso)
        {
            for (int i = 0; i < ingresso.Length; i++)
            {
                Console.Write($"\n\nAtração: {ingresso[i].Atracao}\nLocal: {ingresso[i].Local}\nPreço: {ingresso[i].Preco:C2}");
            }
        }
    }
}