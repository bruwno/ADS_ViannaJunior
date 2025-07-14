/* Objetivo : Guardar dados de contato.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 01/11/2023
 * Material : FP09 (Classes)
 * Slide    : 21
 * Exercício: 04
 */

/* 4) Faça um programa (método principal) para leitura, via teclado, dos dados de um contato de telefone.
 * Os dados a serem guardados na classe Contato são os seguintes: nome, endereço (logradouro, número, complemento, bairro, cidade,
 * UF), telefone e e-mail. Ao final, imprima estas informações na tela.
 */

using System;

namespace GuardarContatos
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Contato contato = new Contato();
            contato.Endereco = new Endereco();
            // Leitura.
            Console.Write("Informe o nome do contato: ");
            contato.Nome = Console.ReadLine();
            //
            Console.WriteLine("\nInforme o endereço");
            Console.Write("Digite seu logradouro: ");
            contato.Endereco.Logradouro = Console.ReadLine();
            Console.Write("Digite o número      : ");
            contato.Endereco.Numero = Convert.ToInt32(Console.ReadLine());
            Console.Write("Digite o complemento : ");
            contato.Endereco.Complemento = Console.ReadLine();
            Console.Write("Digite o bairro      : ");
            contato.Endereco.Bairro = Console.ReadLine();
            Console.Write("Digite a cidade      : ");
            contato.Endereco.Cidade = Console.ReadLine();
            Console.Write("Digite o UF          : ");
            contato.Endereco.UF = Console.ReadLine();
            //
            Console.WriteLine("Dados de contato");
            Console.Write("Digite o número de telefone: ");
            contato.Telefone = Convert.ToInt64(Console.ReadLine());
            Console.Write("Digite o endereço de email : ");
            contato.Email = Console.ReadLine();

            // Exibindo.
            Console.WriteLine("\nDados do contato");
            Console.WriteLine("\nNOME -------");
            Console.WriteLine($"Nome: {contato.Nome}");
            Console.WriteLine("\nENDEREÇO ---");
            Console.WriteLine($"Logradouro : {contato.Endereco.Logradouro}");
            Console.WriteLine($"Número     : {contato.Endereco.Numero}");
            Console.WriteLine($"Complemento: {contato.Endereco.Complemento}");
            Console.WriteLine($"Bairro     : {contato.Endereco.Bairro}");
            Console.WriteLine($"Cidade     : {contato.Endereco.Cidade}");
            Console.WriteLine($"UF         : {contato.Endereco.UF}");
            Console.WriteLine("\nCONTATOS ---");
            Console.WriteLine($"Telefone   : {contato.Telefone}");
            Console.WriteLine($"Email      : {contato.Email}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }
    }
}
