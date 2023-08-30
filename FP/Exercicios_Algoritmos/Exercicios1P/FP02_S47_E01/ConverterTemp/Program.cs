/* Objetivo : Converter um valor de entrada de graus Celsius para graus Fahrenheit.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 15/08/2023
 * Material : FP02
 * Slide    : 47
 * Exercício: 01
 */

/* Comando:
 * 1. Faça um programa que lê uma temperatura em
 * graus Celsius e apresenta-a convertida em graus
 * Fahrenheit. A fórmula de conversão: F ← (9*C+160)/5
 */

using System;

namespace ConverterTemp
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Conversor de temperatura - Celsius para Fahrenheit\n");
            ObterDadosParaConversao();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterDadosParaConversao()
        {
            double resultadoConversao;
            Console.Write("[i] Informe a temperatura em graus Celsius (apenas dígitos numéricos): ");
            double temperatura = Convert.ToDouble(Console.ReadLine());

            resultadoConversao = ConverterParaFahrenheit(temperatura);
            Console.WriteLine($"\n[>] {temperatura} ºC equivale(m) a {resultadoConversao} ºF");
        }

        private static double ConverterParaFahrenheit(double temperatura)
        {
            return (9.0 * temperatura + 160.0) / 5.0;
        }
    }
}
