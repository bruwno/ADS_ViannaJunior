/* Objetivo : Calcular idade em dias.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 22/08/2023
 * Material : FP03 (Subrotinas)
 * Slide    : 101
 * Exercício: 05
 */

/* Comando:
 * 5) Considere as equações de movimento para calcular a posição (s) e velocidade (v) de uma partícula em * um determinado instante t, dado sua aceleração a,
 * posição inicial s0 e velocidade inicial v0, de acordo com as fórmulas: s = s0 + v0*t + (a * t * t)/2 | v = v0 + a*t
 * Escreva um programa C# completo que capture os valores de s0, v0, a e t, fornecidos pelo usuário via teclado, e calcule e imprima os valores de s e v.
 */

using System;

namespace CalcMov
{
    public class programa
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular posição e velocidade de uma partícula");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("[i] Informe o valor da posição incial    (s0): ");
            double posIncial = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Informe o valor da velocidade incial (v0): ");
            double velInicial = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Informe o valor da aceleração (a): ");
            double aceleracao = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Informe o valor do tempo      (t): ");
            double tempo = Convert.ToDouble(Console.ReadLine());

            double posicao = CalcularPosicao(posIncial, velInicial, aceleracao, tempo);
            double velocidade = CalcularVelocidade(velInicial, aceleracao, tempo);

            Console.Write($"\n[>] Posição da partícula   : {posicao}");
            Console.Write($"\n[>] Velocidade da partícula: {velocidade}\n");
        }

        private static double CalcularPosicao(double s0, double v0, double a, double t)
        {
            return s0 + v0 * t + (a * (t * t)) / 2.0;
        }

        private static double CalcularVelocidade(double v0, double a, double t)
        {
            return v0 + a * t;
        }
    }
}