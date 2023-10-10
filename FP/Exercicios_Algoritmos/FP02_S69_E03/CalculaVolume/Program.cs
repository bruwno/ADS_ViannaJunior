/* Objetivo : Calcular o volume de uma caixa.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 17/08/2023
 * Material : FP02 (E/S de dados)
 * Slide    : 69
 * Exercício: 03
 */

/* Comando:
 * 3. Elaborar um programa que calcule e apresente o volume de uma
 * caixa retangular, por meio da fórmula: volume = comprimento * largura * altura.
 */

using System;

namespace CalculaVolume
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular o volume de uma caixa\n");
            ObterDados();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterDados()
        {
            Console.Write("[i] Digite o comprimento da caixa (ex: 45) : ");
            double comprimento = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Digite a largura da caixa     (ex: 30) : ");
            double largura = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Digite a altura da caixa      (ex: 20) : ");
            double altura = Convert.ToDouble(Console.ReadLine());

            CalcularVolume(comprimento, largura, altura);
        }

        private static void CalcularVolume(double comprimento, double largura, double altura)
        {
            double volume = comprimento * largura * altura;
            Console.WriteLine($"\n[>] O volume da caixa é de {volume} cm³");
        }
    }
}