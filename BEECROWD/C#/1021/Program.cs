/* Objetivo: Decompor um valor monetário em notas e moedas.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 22/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1021
 * Nome    : Notas e Moedas
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1021
 */

/*******************************************************************************
****************************** ESTE PROBLEMA AINDA *****************************
******************************  NÃO FOI RESOLVIDO. *****************************
********************************************************************************/

using System;

class URI
{
    const int Nota100 = 100, Nota50 = 50, Nota20 = 20, Nota10 = 10, Nota5 = 5, Nota2 = 2;
    const double Moeda1 = 1, Moeda50 = 0.50, Moeda25 = 0.25, Moeda10 = 0.10, Moeda5 = 0.05, Moeda01 = 0.01;

    public static void Main(string[] args)
    {
        int[] notas = { Nota100, Nota50, Nota20, Nota10, Nota5, Nota2 };
        double[] moedas = { Moeda1, Moeda50, Moeda25, Moeda10, Moeda5, Moeda01 };

        string[] valorInicial = Console.ReadLine().Trim().Split('.');
        double valorNotas = double.Parse(valorInicial[0]);
        double valorMoedas = double.Parse(valorInicial[1]);

        int[] qtdNotas = new int[notas.Length];
        double[] qtdMoedas = new double[moedas.Length];

        for (int i = 0; i < notas.Length; i++)
        {
            qtdNotas[i] = (int)valorNotas / notas[i];
            valorNotas %= notas[i];
        }

        for (int i = 0; i < moedas.Length; i++)
        {
            qtdMoedas[i] = valorMoedas / moedas[i];
            valorMoedas %= moedas[i];
        }

        Console.WriteLine("NOTAS:");
        for (int i = 0; i < notas.Length; i++)
        {
            Console.WriteLine($"{qtdNotas[i]} nota(s) de R$ {notas[i]}.00");
        }
        Console.WriteLine("MOEDAS:");
        for (int i = 0; i < moedas.Length; i++)
        {
            Console.WriteLine($"{qtdMoedas[i]} moeda(s) de R$ {moedas[i]}");
        }
    }
}