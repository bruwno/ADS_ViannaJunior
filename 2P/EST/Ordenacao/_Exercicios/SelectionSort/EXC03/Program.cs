namespace EXC03;

class Program
{
    public static void Main(string[] args)
    {
        double[] vet = new double[] { 300.4, 6.47, 1001.9, 2.45, 31.7, 675.9, 1.0, 0.85, 3.14 };
        SelectionSort(vet);

        foreach (double n in vet)
        {
            Console.Write($"{n} | ");
        }
    }

    public static void SelectionSort(double[] vet)
    {
        for (int i = 0; i < vet.Length - 1; i++)
        {
            int indiceMenor = i;
            for (int j = i + 1; j < vet.Length; j++)
            {
                if (vet[j] < vet[indiceMenor])
                {
                    indiceMenor = j;
                }
            }

            if (i != indiceMenor)
            {
                Troca(vet, i, indiceMenor);
            }
        }
    }

    public static void Troca(double[] vet, int i, int j)
    {
        double aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }

}
