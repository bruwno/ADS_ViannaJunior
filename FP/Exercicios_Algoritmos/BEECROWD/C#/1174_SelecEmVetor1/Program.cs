/* Objetivo : Ler um vetor de 100 posições e retornar todos as posições onde os valores armazenados forem menores ou iguais a 10.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 26/09/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 1174
 * Nome     : Seleçao em Vetor I
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/1174
 */

using System;
using System.Collections.Generic;

class URI
{
    static void Main(string[] args)
    {
        double[] valores = new double[100];
        double[] menoresQue10 = new double[100];

        int cont = 0;

        for (int i = 0; i <= 100; i++)
        {
            valores[i] = double.Parse(Console.ReadLine());

            if (valores[i] <= 10.0)
            {
                while (true)
                {
                    menoresQue10[i] += valores[i];
                }

                //CapturarValoresMenoresQue10(menoresQue10, i);
            }


        }

        ExibirMenoresQue10(valores);
    }

    private static void CapturarValoresMenoresQue10(double[] nums, int posic)
    {

        for (int j = 0; j < nums.Length; j++)
        {
        }
    }

    private static void ExibirMenoresQue10(double[] nums)
    {
        for (int k = 0; k < nums.Length; k++)
        {
            double numero = nums[k];

            Console.WriteLine($"A[{k}] = {numero}");
        }
    }
}