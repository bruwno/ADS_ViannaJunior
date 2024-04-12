/*
 Questão 1) Faça um procedimento que receba um vetor de inteiros por parâmetro e imprima a soma dos números divisíveis por 5 que não são divisíveis por 3 existentes neste vetor. O procedimento deve ser recursivo e nenhum uso de comando de repetição é permitido nesta questão.
*/

namespace Questao1;

class Program
{
    public static void Main(string[] args)
    {
        int[] vet = new int[] { 15, 18, 21, 24, 20, 25};
        ImprimirDivisiveis(vet, 0, 0);
    }

    public static void ImprimirDivisiveis(int[] vet, int soma, int i = 0)
    {
        if (i >= vet.Length)
        {
            Console.WriteLine(soma);
        }
        else
        {
            if (vet[i] % 5 == 0 && vet[i] % 3 != 0)
            {
                soma += vet[i];
            }
            ImprimirDivisiveis(vet, soma, i + 1);
        }
    }
}
