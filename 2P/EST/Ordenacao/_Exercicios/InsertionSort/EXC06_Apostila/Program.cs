namespace EXC06_Apostila;

class Program
{
    public static void Main(string[] args)
    {
        Produto[] vet = new Produto[] {
            new Produto (10, "Massa de Pizza", 35.99),
            new Produto (2, "Massa de Pastel", 100.95),
            new Produto (31, "Catupiry Original", 45.20),
            new Produto (100, "Manteiga Natural", 35.99),
            new Produto (5, "Farinha de Milho", 100.95),
            new Produto (39, "Feijão Carioca", 45.20),
            new Produto (1, "Polvilho amargo", 35.99),
            new Produto (300, "Chocolate amargo", 100.95),
            new Produto (95, "Refrigerante de Cola", 45.20)
        };

        InsertionSort(vet);

        foreach (var item in vet)
        {
            Console.WriteLine($"{item.ToString()}");
        }
    }

    public static void InsertionSort(Produto[] vet)
    {
        for (int i = 1; i < vet.Length; i++)
        {
            var chave = vet[i];
            int j;
            for (j = i - 1; j >= 0 && chave.Codigo < vet[j].Codigo; j--)
            {
                Troca(vet, j, j + 1);
            }
            vet[j + 1] = chave;
        }
    }

    public static void Troca(Produto[] vet, int i, int j)
    {
        Produto aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }
}
