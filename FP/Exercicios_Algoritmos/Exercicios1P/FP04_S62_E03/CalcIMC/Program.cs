/* Objetivo : Calcular IMC com base no gênero do usuário.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/08/2023
 * Material : FP04
 * Slide    : 62
 * Exercício: 03
 */

/* Comando:
 * 3. Tendo como dados de entrada a altura e o sexo de uma pessoa, construa um programa que calcule seu peso ideal,
 * utilizando as seguintes fórmulas: para homens: (72.7*h)-58 e para mulheres: (62.1*h)-44.7
 */

using System;

namespace CalcIMC
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular IMC");
            ObterDados();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterDados()
        {
            Console.Write("[i] Informe o seu gênero | (M) ou (F) : ");
            char genero = Convert.ToChar(Console.ReadLine());
            Console.Write("[i] Informe a sua altura | (ex.: 1,80): ");
            double altura = Convert.ToDouble(Console.ReadLine());

            double imc = CalcularIMC(genero, altura);
            Console.WriteLine($"\nO seu peso ideal é {imc:N2} kg");
        }

        private static double CalcularIMC(char genero, double altura)
        {
            double imc = 0.0;

            if (genero == 'M' || genero == 'm')
            {
                imc = (72.7 * altura) - 58.0;
            }
            if (genero == 'F' || genero == 'f')
            {
                imc = (62.1 * altura) - 44.7;
            }

            return imc;
        }
    }
}
