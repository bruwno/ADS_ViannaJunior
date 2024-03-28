namespace EXC01;

class Program
{
    static void Main(string[] args)
    {
        //Imprime(1, 5);
        Imprime(5);
    }

    static void Imprime(int atual, int qtdVezes)
    {
        if (atual > qtdVezes)
        {
            return;
        }
        Console.WriteLine("Estude ESTRUTURA DE DADOS!");
        Imprime(atual + 1, qtdVezes);
    }

    static void Imprime(int qtdVezes)
    {
        if (qtdVezes == 0) {
            return; 
        }
        Imprime(qtdVezes - 1);
        Console.WriteLine($"{qtdVezes} Estude estrutura de dados!");
    }
}
