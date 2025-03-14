/* Objetivo: Ler um número, que representa uma senha, e exibir o número que vem depois dele.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 27/09/2023
 * Tipo    : 5 (MATEMÁTICA)
 * ID      : 3104
 * Nome    : Resto 2.0
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/3104
 */

/*******************************************************************************
****************************** ESTE PROBLEMA AINDA *****************************
******************************  NÃO FOI RESOLVIDO. *****************************
********************************************************************************/

using System;
using System.Numerics;

class URI
{
    static void Main()
    {
        BigInteger a = new BigInteger();
        a = BigInteger.Parse(Console.ReadLine());

        long b = long.Parse(Console.ReadLine());

        long result = (long)a % b;

        Console.WriteLine(result);
    }
}