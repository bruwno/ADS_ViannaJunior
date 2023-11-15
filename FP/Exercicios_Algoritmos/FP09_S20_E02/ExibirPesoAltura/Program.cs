/* Objetivo : Representar o peso e altura de uma pessoa.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 31/10/2023
 * Material : FP09 (Classes)
 * Slide    : 20
 * Exercício: 02
 */

/* 2) Defina uma classe para representar o peso e a altura de uma pessoa. 
 * Crie um programa que pergunte ao usuário o seu peso e a sua altura, atribuindo-os aos respectivos atributos de um objeto da classe criada. 
 * Imprima os atributos da classe criada.
 */

using System;

namespace ExibirPesoAltura
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Pessoa pessoa1 = new Pessoa();

            Console.Write("Digite o seu peso  : ");
            double peso = Convert.ToDouble(Console.ReadLine());

            Console.Write("Digite a sua altura: ");
            double altura = Convert.ToDouble(Console.ReadLine());

            pessoa1.Peso = peso;
            pessoa1.Altura = altura;

            pessoa1.ExibirPesoEAltura();

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }
    }
}