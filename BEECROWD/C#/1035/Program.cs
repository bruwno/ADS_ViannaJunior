/* Objetivo: Ler valores, realizar avaliações lógicas e determinar se é válido ou não.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 22/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1035
 * Nome    : Teste de Seleção 1
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1035
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        string[] valores = Console.ReadLine().Trim().Split(' ');
        int A = int.Parse(valores[0]);
        int B = int.Parse(valores[1]);
        int C = int.Parse(valores[2]);
        int D = int.Parse(valores[3]);
        int somaAB = A + B;
        int somaCD = C + D;

        Console.WriteLine((B > C) && (D > A) && (somaCD > somaAB) && (C > 0 && D > 0) && (ehPar(A)) ? "Valores aceitos" : "Valores nao aceitos");

    }

    private static bool ehPar(int num)
    {
        return (num % 2 == 0) ? true : false;
    }
}