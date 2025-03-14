/* Objetivo: Ler um vetor de 100 posições e retornar todos as posições onde os valores armazenados forem menores ou iguais a 10.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 26/09/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1174
 * Nome    : Seleçao em Vetor I
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1174
 */

using System;

class URI
{
    static void Main(string[] args)
    {
        double[] valores = new double[100];
        int[] indiceDoValor = new int[100];

        for (int i = 0; i < valores.Length; i++)
        {
            valores[i] = double.Parse(Console.ReadLine());
            indiceDoValor[i] = i;
        }

        for (int j = 0; j < indiceDoValor.Length; j++)
        {
            if (valores[j] <= 10)
            {
                Console.WriteLine($"A[{indiceDoValor[j]}] = {valores[j]:F1}");
            }
        }
    }
}