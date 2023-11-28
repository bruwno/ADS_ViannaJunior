/* Objetivo : Ler dados de restaurantes e exibir o endereço do mais bem avaliado.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 22/11/2023
 * Material : FP09 (Classes)
 * Slide    : 43
 * Exercício: 09
 */

/* 9) Faça um programa que armazene informações de restaurantes. 
 * Cada restaurante é identificado pelo nome, endereço, o tipo de comida (brasileira, chinesa, francesa, italiana, japonesa, etc.) e uma nota para a cozinha (entre 0 e 5). 
 * O programa deverá ler todas as informações e imprimir ao final a lista de todos os restaurantes, e o endereço do restaurante com maior nota para a cozinha.
 */

using System;
using System.Text;

namespace LerRestaurantes
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("Informe a quantidade de restaurantes: ");
            int qtdRestaurantes = Convert.ToInt32(Console.ReadLine());

            Restaurante[] restaurantes = new Restaurante[qtdRestaurantes];

            for (int i = 0; i < restaurantes.Length; i++)
            {
                Console.WriteLine($"\nRestaurante [{i + 1}] de [{qtdRestaurantes}]");
                restaurantes[i] = ObterDados();
            }

            ImprimirListaRestaurantes(restaurantes);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static Restaurante ObterDados()
        {
            Restaurante restaurante = new Restaurante();
            restaurante.Endereco = new Endereco();

            Console.Write("Nome  : ");
            restaurante.Nome = Console.ReadLine();
            Console.WriteLine("Endereço ---------------");
            Console.Write("Rua   : ");
            restaurante.Endereco.Rua = Console.ReadLine();
            Console.Write("Nº    : ");
            restaurante.Endereco.Numero = Convert.ToInt32(Console.ReadLine());
            Console.Write("Bairro: ");
            restaurante.Endereco.Bairro = Console.ReadLine();
            Console.Write("CEP   : ");
            restaurante.Endereco.Cep = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("---------------------------");
            Console.Write("Tipo de comida: ");
            restaurante.TipoComida = Console.ReadLine();
            Console.Write("Nota: ");
            restaurante.Nota = Convert.ToDouble(Console.ReadLine());

            return restaurante;
        }

        private static void ImprimirListaRestaurantes(Restaurante[] restaurantes)
        {
            StringBuilder exibeLista = new StringBuilder();
            double maiorNota = double.MinValue;
            int indiceMaiorNota = 0;

            for (int i = 0; i < restaurantes.Length; i++)
            {
                if (restaurantes[i].Nota > maiorNota)
                {
                    maiorNota = restaurantes[i].Nota;
                    indiceMaiorNota = i;
                }
            }

            Console.WriteLine("\nExibindo a lista de resturantes");
            for (int j = 0; j < restaurantes.Length; j++)
            {
                if (j == indiceMaiorNota)
                {
                    exibeLista.Append(
                    $"Restaurante: {restaurantes[indiceMaiorNota].Nome}" +
                    $"\nEndereço" +
                    $"\nRua   : {restaurantes[indiceMaiorNota].Endereco.Rua}" +
                    $"\nNº    : {restaurantes[indiceMaiorNota].Endereco.Numero}" +
                    $"\nBairro: {restaurantes[indiceMaiorNota].Endereco.Bairro}" +
                    $"\nCEP   : {restaurantes[indiceMaiorNota].Endereco.Cep}" +
                    $"\nTipo de Comida: {restaurantes[indiceMaiorNota].TipoComida}" +
                    $"\nNota: {restaurantes[indiceMaiorNota].Nota}");

                    Console.WriteLine(exibeLista.ToString());
                }
                else
                {
                    Console.WriteLine($"Restaurante: {restaurantes[j].Nome}\nTipo de comida: {restaurantes[j].TipoComida}\nNota: {restaurantes[j].Nota}");
                    Console.WriteLine();
                }
            }
        }
    }
}