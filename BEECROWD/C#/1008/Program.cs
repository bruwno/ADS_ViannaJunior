/* Objetivo: Ler dados de um funcionário e retornar o seu salário.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 21/09/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1008
 * Nome    : Salário
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1008
 */

using System;

class URI
{
    static void Main(string[] args)
    {
        int numFuncionario = int.Parse(Console.ReadLine());
        int numHorasTrab = int.Parse(Console.ReadLine());
        double valorHora = double.Parse(Console.ReadLine());

        double salario = numHorasTrab * valorHora;

        Console.WriteLine($"NUMBER = {numFuncionario}");
        Console.WriteLine("SALARY = U$ {0}", salario.ToString("F2"));
    }
}
