/* Objetivo : Ler dados de lojas e exibir a média dos preços praticados.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/11/2023
 * Material : FP09 (Classes)
 * Slide    : 44
 * Exercício: 12
 */

/* 12) Faça um programa que avalie o preço de um eletrodoméstico em diferentes lojas. 
 * Faça a leitura das informações das lojas, que contenham os seguintes campos: nome da loja, telefone e preço do eletrodoméstico. 
 * Ao final, informe os dados de todas as lojas. Informe também a média dos preços cadastrados e uma relação contendo o nome e o telefone das lojas cujo preço estava abaixo da média. 
 * Utilize funções para realizar operações de leitura e escrita e faça um menu que possibilite ler todas as informações das lojas, ler uma loja com um endereço específico, 
 * caso ela esteja cadastrada, e imprimir as informações citadas anteriormente
 */

using System;

namespace DadosLojas
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Loja[] lojas = new Loja[3];

            for (int i = 0, j = 1; i < lojas.Length; i++, j++)
            {
                Console.WriteLine($"\nInforme os dados para a {j}ª loja");
                lojas[i] = LerDados();
            }

            ExibirDadosLojas(lojas);
            ExibirLojasComPrecosAbaixoDaMedia(lojas);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static Loja LerDados()
        {
            Loja loja = new Loja();

            Console.WriteLine("Dados da loja");

            Console.Write("  Nome    : ");
            loja.Nome = Console.ReadLine();
            Console.Write("  Telefone: ");
            loja.Telefone = Convert.ToInt64(Console.ReadLine());
            Console.Write("  Preço  $: ");
            loja.Preco = Convert.ToDouble(Console.ReadLine());

            return loja;
        }

        private static void ExibirDadosLojas(Loja[] lojas)
        {
            Console.WriteLine("Dados das lojas cadastradas\n");
            for (int i = 0; i < lojas.Length; i++)
            {
                Console.WriteLine($"Nome: {lojas[i].Nome}\nTelefone: {lojas[i].Telefone}\nPreço: {lojas[i].Preco:C2}\n");
            }
        }

        private static double CalcularPrecoMedio(Loja[] lojas)
        {
            double somaPrecos = 0.0;
            double mediaPrecos = 0.0;

            for (int i = 0; i < lojas.Length; i++)
            {
                somaPrecos += lojas[i].Preco;
            }

            return mediaPrecos = somaPrecos / lojas.Length;
        }

        private static void ExibirLojasComPrecosAbaixoDaMedia(Loja[] lojas)
        {
            double mediaPrecos = CalcularPrecoMedio(lojas);
            Console.WriteLine($"Preço médio do eletrodoméstico: {mediaPrecos:C2}\n");

            Console.WriteLine("Lojas com preços abaixo da média");
            for (int i = 0; i < lojas.Length; i++)
            {
                if (lojas[i].Preco < mediaPrecos)
                {
                    Console.WriteLine($"Nome: {lojas[i].Nome}\nTelefone: {lojas[i].Telefone}\n");
                }
            }
        }

    }
}