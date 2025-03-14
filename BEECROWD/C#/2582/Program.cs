/*
 * Objetivo: Ler dois valores de entrada e retornar a música correspondente à soma desses valores.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 31/01/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 2582
 * Nome    : System of a Download
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/2582
 */

using System;
using System.Collections.Generic;

class URI
{
    public static void Main(string[] args)
    {
        int c = int.Parse(Console.ReadLine());
        string[] xy = new string[c];
        int[] armazenaSomas = new int[c];

        for (int i = 0; i < c; i++)
        {
            int soma = 0;

            xy = Console.ReadLine().Trim().Split(' ');
            int x = int.Parse(xy[0]);
            int y = int.Parse(xy[1]);

            soma = x + y;
            armazenaSomas[i] = soma;
        }
        ExibirMusicas(armazenaSomas);
    }

    private static void ExibirMusicas(int[] somasArmazenadas)
    {
        List<String> musicas = new List<String>();

        for (int i = 0; i < somasArmazenadas.Length; i++)
        {
            musicas.Add(RetornarMusica(somasArmazenadas[i]));
        }

        foreach (string musica in musicas)
        {
            Console.WriteLine(musica);
        }
    }

    private static string RetornarMusica(int num)
    {
        Dictionary<int, string> musicas = new Dictionary<int, string>()
        {
            { 0, "PROXYCITY" },
            { 1, "P.Y.N.G." },
            { 2, "DNSUEY!" },
            { 3, "SERVERS" },
            { 4, "HOST!" },
            { 5, "CRIPTONIZE" },
            { 6, "OFFLINE DAY" },
            { 7, "SALT" },
            { 8, "ANSWER!" },
            { 9, "RAR?" },
            { 10, "WIFI ANTENNAS" }
        };

        return musicas[num];
    }
}