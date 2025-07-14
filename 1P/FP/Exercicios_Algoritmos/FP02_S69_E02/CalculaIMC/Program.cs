/* Objetivo : Calcular o IMC.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 16/08/2023
 * Material : FP02 (E/S de dados)
 * Slide    : 69
 * Exercício: 02
 */

/* Comando:
 * 2. Elaborar um programa que calcule o índice de massa corporal
 * (IMC) de um usuário qualquer, sabendo-se que o IMC é
 * determinado pela divisão da massa do indivíduo (em
 * quilogramas) pelo quadrado de sua altura (em metros).
 */

using System;

namespace CalculaIMC
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular o IMC\n");
            ObterPesoAltura();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterPesoAltura()
        {
            Console.Write("[i] Digite o seu peso em kg (ex.: 75): ");
            double peso = Convert.ToDouble(Console.ReadLine().Replace('.', ','));
            Console.Write("[i] Digite a sua altura   (ex.: 1,83): ");
            double altura = Convert.ToDouble(Console.ReadLine().Replace('.', ','));

            double resultado = CalcularIMC(peso, altura);
            Console.WriteLine($"\n[>] Seu IMC aproximado é {resultado:N1}");
        }

        private static double CalcularIMC(double peso, double altura)
        {
            return peso / Math.Pow(altura, 2.0);
        }
    }
}