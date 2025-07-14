/* Objetivo : Realizar as quatro operações básicas com dois valores.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 16/08/2023
 * Material : FP02 (E/S de dados)
 * Slide    : 69
 * Exercício: 01
 */

/* Comando:
 * 1. Escreva um programa para efetuar as quatro operações
 * matemáticas básicas (adição, subtração, produto e divisão)
 * sobre dois valores informados.
 */

using System;

namespace Calculadora
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calculadora básica\n");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("[i] Digite o primeiro valor: ");
            double pValor = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Digite o segundo valor : ");
            double sValor = Convert.ToDouble(Console.ReadLine());
            Calcular(pValor, sValor);
        }

        private static void Calcular(double pValor, double sValor)
        {
            double resultAdic = pValor + sValor;
            double resultSub = pValor - sValor;
            double resultMult = pValor * sValor;
            double resultDiv = pValor / sValor;

            Console.WriteLine("\n[>] Resultados das operações\n");
            Console.Write($"{pValor} + {sValor} = {resultAdic}\n");
            Console.Write($"{pValor} - {sValor} = {resultSub}\n");
            Console.Write($"{pValor} x {sValor} = {resultMult}\n");
            Console.Write($"{pValor} ÷ {sValor} = {resultDiv}\n");
        }
    }
}
