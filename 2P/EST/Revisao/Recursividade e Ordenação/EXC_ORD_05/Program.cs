/* Autor: William Silva (https://github.com/unclWill)
 * Data : 10/04/2024
 *
 * Faça um programa que ordene um objeto do tipo Livro.
 * O Livro possui Código (int), Nome (string), Autor (string), Ano de Lancamento (int) e Preço (double).
 * O Código deverá ser ordenado pelo método InsertionSort, o ano pelo método BubbleSort e o Preço pelo método SelectionSort.
 * Ao fim exibe os dois resultados.
 */

namespace EXC_ORD_05;

class Program
{
    public static void Main(string[] args)
    {
        Livro[] vet = new Livro[]
        {
            new Livro(345, "Sistemas Orientados a Objetos: Teoria e Prática com UML e Java", "Pablo Rangel", 2021, 73.10),
            new Livro(009, "Organização Estruturada de Computadores", "Andrew Tanenbaum", 2013, 330.50),
            new Livro(120, "Entendendo Algoritmos", "Aditya Y. Bhargava",2017 , 63.80),
            new Livro(003, "O Senhor dos Anéis: As duas Torres", "J.R.R. Tolkien", 1954, 52.43),
            new Livro(001, "Java, Guia do Programador", "Peter Jandl Junior", 2021, 120.95)
        };

        System.Console.WriteLine("VETOR DESORDENADO", Console.ForegroundColor = ConsoleColor.Yellow);
        ImprimirVetor(vet);

        System.Console.WriteLine("ORDENADO PELO CÓDIGO (InsertionSort)", Console.ForegroundColor = ConsoleColor.Red);
        InsertionSort(vet);
        ImprimirVetor(vet);

        System.Console.WriteLine("ORDENADO PELO ANO DE LANÇAMENTO (BubbleSort)", Console.ForegroundColor = ConsoleColor.Cyan);
        BubbleSort(vet);
        ImprimirVetor(vet);

        System.Console.WriteLine("ORDENADO PELO PREÇO (SelectionSort)", Console.ForegroundColor = ConsoleColor.Green);
        SelectionSort(vet);
        ImprimirVetor(vet);
    }

    public static void BubbleSort(Livro[] vet)
    {
        for (int i = vet.Length - 1; i >= 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (vet[j].AnoDeLancamento > vet[j + 1].AnoDeLancamento)
                {
                    Troca(vet, j, j + 1);
                }
            }
        }
    }

    public static void InsertionSort(Livro[] vet)
    {
        for (int i = 1; i < vet.Length; i++)
        {
            Livro chave = vet[i];
            int j;
            for (j = i - 1; j >= 0 && chave.Codigo < vet[j].Codigo; j--)
            {
                vet[j + 1] = vet[j];
            }
            vet[j + 1] = chave;
        }
    }

    public static void SelectionSort(Livro[] vet)
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

    public static void Troca(Livro[] vet, int i, int j)
    {
        Livro aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }

    public static void ImprimirVetor(Livro[] livros)
    {
        foreach (var livro in livros)
        {
            Console.WriteLine($"#{livro.Codigo.ToString("D3")} | {livro.Nome} | AUTOR: {livro.Autor} | ANO: {livro.AnoDeLancamento} | PREÇO: {livro.Preco:C}\n",
            Console.ForegroundColor = ConsoleColor.Gray
            );
        }
    }
}
