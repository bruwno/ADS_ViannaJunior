/* Objetivo : Calcular e exibir a média aritmética.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 17/08/2023
 * Material : FP03 (Subrotinas)
 * Slide    : 78
 * Exercício: 01
 */

/* Comando:
 * 1) Faça um procedimento que receba três valores
 * reais e imprima a média aritmética desses valores.
 */

using System;

namespace MediaAritmetica
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular a média aritmética\n");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("[i] Digite o primeiro valor: ");
            float primValor = float.Parse(Console.ReadLine());
            Console.Write("[i] Digite o segundo valor : ");
            float segValor = float.Parse(Console.ReadLine());
            Console.Write("[i] Digite o terceiro valor: ");
            float tercValor = float.Parse(Console.ReadLine());
            CalcularMediaAritmetica(primValor, segValor, tercValor);
        }

        private static void CalcularMediaAritmetica(float primValor, float segValor, float tercValor)
        {
            float media = (primValor + segValor + tercValor) / 3.0f;
            Console.WriteLine($"[>] A média aritmética dos valores informados é: {media}");
        }
    }
}