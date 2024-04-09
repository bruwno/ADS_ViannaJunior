namespace EXC07_Apostila;

internal class Program
{
    public static void Main(string[] args)
    {
        Produto[] vet = new Produto[]
        {
            new Produto(006, "Star Wars EP VII", 199.0),
            new Produto(004, "Matrix", 99.80),
            new Produto(050, "O Senhor dos Anéis: A Sociedade do Anel", 299.0),
            new Produto(145, "Carros", 80.0),
            new Produto(600, "Superbad: É hoje", 100.0),
            new Produto(007, "V de Vingança", 75.0),
            new Produto(106, "Monty Python: Em busca do cálice sagrado", 35.0),
            new Produto(056, "Space Jam: O jogo do século", 150.0),
            new Produto(008, "O Livro de Eli", 86.99),
            new Produto(001, "O Pica-Pau e sua Turma", 25.40)
        };

        SelectionSort(vet);

        foreach (var item in vet)
        {
            Console.WriteLine(item.ToString());
        }
    }

    public static void SelectionSort(Produto[] vet)
    {
        for (int i = 0; i < vet.Length - 1; i++)
        {
            int indiceMenor = i;
            for (int j = i + 1; j < vet.Length; j++)
            {
                if (vet[j].Preco < vet[indiceMenor].Preco)
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

    public static void Troca(Produto[] vet, int i, int j)
    {
        Produto aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }
}