namespace EXC_REC_06;

class Program
{
    static void Main(string[] args)
    {
        int[] vet = new int[] { 23, -45, 6, -4, -33, 98, 452, -12 };

        int qtdNegativos = InverterNegativos(vet);
        Console.WriteLine($"Haviam {qtdNegativos} números negativos no vetor.");

        Console.WriteLine($"Vetor com os {qtdNegativos} valores negativos invertidos:");
        foreach (int i in vet)
        {
            Console.Write($"{i} ");
        }
    }

    public static int InverterNegativos(int[] vet, int i = 0, int qtdNegativos = 0)
    {
        if (i >= vet.Length)
        {
            return qtdNegativos;
        }
        else
        {
            if (vet[i] < 0)
            {
                vet[i] *= -1;
                qtdNegativos++;
            }
        }
        return InverterNegativos(vet, i + 1, qtdNegativos);
    }
}
