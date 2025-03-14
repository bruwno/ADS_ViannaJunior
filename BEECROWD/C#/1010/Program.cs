/* Objetivo: Ler dados de uma venda e retornar o valor total dessa venda.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 24/09/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1010
 * Nome    : Cálculo Simples
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1010
 */

using System;

public class URI
{
    public static void Main(string[] args)
    {
        double total = 0.0;

        for (int i = 0; i < 2; i++)
        {
            string[] dadosVenda = Console.ReadLine().Split(' ');

            int codPeca = Convert.ToInt32(dadosVenda[0]);
            int qtdPecas = Convert.ToInt32(dadosVenda[1]);
            double valorUnit = Convert.ToDouble(dadosVenda[2]);

            double somatorio = (double)qtdPecas * valorUnit;
            total += somatorio;
        }

        Console.WriteLine($"VALOR A PAGAR: R$ {total:F2}");
    }
}