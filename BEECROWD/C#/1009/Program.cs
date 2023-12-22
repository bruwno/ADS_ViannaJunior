/* Objetivo: Ler dados de vendas e retornar o salário do vendedor com bônus.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 21/09/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1009
 * Nome    : Salário com Bônus
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1009
 */

using System;

class URI
{
    static void Main(string[] args)
    {
        string nomeVend = Console.ReadLine();
        double salario = double.Parse(Console.ReadLine());
        double totalVendasMes = double.Parse(Console.ReadLine());

        double comissao = (totalVendasMes * 15.0) / 100.0;
        double total = salario + comissao;

        Console.WriteLine("TOTAL = R$ {0}", total.ToString("F2"));
    }
}
