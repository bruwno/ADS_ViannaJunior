namespace EXC02;

class Program
{
    static void Main(string[] args)
    {
        int[] vet = new int[] { 200, 4567, 20, 7, 2065, 4, 0, 25 };
        SelectionSort(vet);

        foreach (int n in vet)
        {
            Console.Write($"{n} ");
        }
    }

    public static void SelectionSort(int[] vet)
    {
        for (int i = 0; i < vet.Length - 1; i++)
        {
            int indiceMenor = i;
            for (int j = i + 1; j < vet.Length; j++)
            {
                if (vet[j] > vet[indiceMenor])
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

    public static void Troca(int[] vet, int i, int j)
    {
        int aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }
}
