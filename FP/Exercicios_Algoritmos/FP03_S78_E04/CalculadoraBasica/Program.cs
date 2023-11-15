/* Objetivo : A partir de dois valores, realizar as operações básicas e obter o resto da divisão.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 17/08/2023
 * Material : FP03 (Subrotinas)
 * Slide    : 78
 * Exercício: 04
 */

/* Comando:
 * 4) Escreva um procedimento que recebe dois
 * números inteiros e imprime, a soma, o produto, a
 * diferença, o quociente e o resto entre esses dois números.
 */

using System;

namespace CalculadoraBasica
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Operações básicas com valores inteiros\n");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("[i] Digite o primeiro número: ");
            int pValor = Convert.ToInt32(Console.ReadLine());
            Console.Write("[i] Digite o segundo número : ");
            int sValor = Convert.ToInt32(Console.ReadLine());

            Calcular(pValor, sValor);
        }

        private static void Calcular(int pValor, int sValor)
        {
            int resultSoma = pValor + sValor;
            int resultMult = pValor * sValor;
            int resultSub = pValor - sValor;
            int resultDiv = pValor / sValor;
            int resultMod = pValor % sValor;

            Console.WriteLine("\n[>] Resultados das operações\n");
            Console.Write($"{pValor} + {sValor} = {resultSoma}\n");
            Console.Write($"{pValor} x {sValor} = {resultMult}\n");
            Console.Write($"{pValor} - {sValor} = {resultSub}\n");
            Console.Write($"{pValor} ÷ {sValor} = {resultDiv}\n");
            Console.Write($"Resto da divisão de {pValor} por {sValor} = {resultMod}\n");
        }
    }
}