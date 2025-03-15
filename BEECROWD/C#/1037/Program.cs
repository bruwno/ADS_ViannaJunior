/* Objetivo: Ler um valor de ponto flutuante e retornar o intervalo ao qual ele pertence.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 14/03/2025
 * Tipo    : 1 (INICIANTE)
 * ID      : 1037
 * Nome    : Intervalo
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1037
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        double entrada = double.Parse(Console.ReadLine());
        Console.WriteLine(VerificarIntervalo(entrada));
    }

    public static string VerificarIntervalo(double valor)
    {
        if (valor >= 0.00 && valor <= 25.00)
        {
            return "Intervalo [0,25]";
        }
        else if (valor >= 25.01 && valor <= 50.00)
        {
            return "Intervalo (25,50]";
        }
        else if (valor >= 50.01 && valor <= 75.00)
        {
            return "Intervalo (50,75]";
        }
        else if (valor >= 75.01 && valor <= 100.00)
        {
            return "Intervalo (75,100]";
        }
        else
        {
            return "Fora de intervalo";
        }
    }
}