namespace Questao2;

class Program
{
    public static void Main(string[] args)
    {
        double[] vet = new double[] { 10.5, 49.7, 57.2, 1.7, 450.9, 8.2 };
        InsertionSort(vet);

        foreach (var i in vet)
        {
            System.Console.Write($"{i} ");
        }
    }

    public static void InsertionSort(double[] vet)
    {
        for (int i = 1; i < vet.Length; i++)
        {
            double chave = vet[i];
            int j;
            for (j = i - 1; j >= 0 && chave < vet[j]; j--)
            {
                vet[j +1] = vet[j];
            }
            vet[j+1] = chave;
        }
    }
}