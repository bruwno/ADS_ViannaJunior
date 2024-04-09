/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/04/2024
 *
 * Faça um procedimento recursivo que receba um vetor de inteiros e exiba o maior valor e o seu índice.
 */

namespace EXC05;

class Program
{
    public static void Main(string[] args)
    {
        int[] vet = new int[] { 200, 450, 1001, 50, 1, 23, 10, 49, 1000923, 3465, 76543 };
        RetornarMaiorNumeroEIndice(vet);
    }

    public static void RetornarMaiorNumeroEIndice(int[] vet)
    {
        RetornarMaiorNumeroEIndice(vet, 0, int.MinValue, 0);
    }

    public static void RetornarMaiorNumeroEIndice(int[] vet, int indice, int maiorNumero = int.MinValue, int i = 0)
    {
        if (i == vet.Length)
        {
            Console.WriteLine($"Maior número: {maiorNumero} | Índice: {indice}");
        }
        else
        {
            if (vet[i] > maiorNumero)
            {
                maiorNumero = vet[i];
                indice = i;
            }
            RetornarMaiorNumeroEIndice(vet, indice, maiorNumero, i + 1);
        }
    }
}
