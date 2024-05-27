namespace EXC_ORD_06;

class Program
{
    public static void Main(string[] args)
    {
        int[] vet = new int[] { 1111, 233, 313, 54234, 53, 63309, 73, 8, 934, 45, 11, 1232, 113, 14, 12345, -1096, 1327, 18, 1922, 2 };

        BubbleSort(vet);
        ImprimirVetor(vet);

        InsertionSort(vet);
        ImprimirVetor(vet);

        SelectionSort(vet);
        ImprimirVetor(vet);
    }

    public static void ImprimirVetor(int[] vet)
    {
        Console.WriteLine();
        foreach (var i in vet)
        {
            Console.Write($"{i} | ");
        }
    }

    public static void BubbleSort(int[] vet)
    {
        for (int i = vet.Length - 1; i >= 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (vet[j] > vet[j + 1])
                {
                    Troca(vet, j, j + 1);
                }
            }
        }
    }

    public static void InsertionSort(int[] vet)
    {
        for (int i = 1; i < vet.Length; i++)
        {
            int chave = vet[i];
            int j;
            for (j = i - 1; j >= 0 && chave < vet[j]; j--)
            {
                vet[j + 1] = vet[j];
            }
            vet[j + 1] = chave;
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
