namespace EXC_Arvores;

class Program
{
    static void Main(string[] args)
    {
        Arvore<char> arvore = new Arvore<char>();
        
        arvore.Raiz = new No<char>('A');
        arvore.Raiz.Esquerda = new No<char>('B');
        arvore.Raiz.Direita = new No<char>('C');
        arvore.Raiz.Direita.Esquerda = new No<char>('D');
        arvore.Raiz.Direita.Direita = new No<char>('E');
        arvore.Raiz.Direita.Esquerda.Esquerda = new No<char>('G');
        arvore.Raiz.Direita.Esquerda.Direita = new No<char>('H');
        arvore.Raiz.Direita.Direita.Esquerda = new No<char>('I');

        Console.WriteLine("Pré-ordem: ");
        PreOrdem(arvore.Raiz);
        Console.WriteLine();

        Console.WriteLine("In-ordem: ");
        InOrdem(arvore.Raiz);
        Console.WriteLine();

        Console.WriteLine("Pós-ordem: ");
        PosOrdem(arvore.Raiz);
        Console.WriteLine();
    }

    public static void PreOrdem(No<char> no)
    {
        if (no == null)
        {
            return;
        }

        Console.Write($"{no.Valor} ");
        PreOrdem(no.Esquerda);
        PreOrdem(no.Direita);
    }

    public static void InOrdem(No<char> no)
    {
        if (no == null)
        {
            return;
        }

        InOrdem(no.Esquerda);
        Console.Write($"{no.Valor} ");
        InOrdem(no.Direita);
    }

    public static void PosOrdem(No<char> no)
    {
        if (no == null)
        {
            return;
        }

        PosOrdem(no.Esquerda);
        PosOrdem(no.Direita);
        Console.Write($"{no.Valor} ");
    }
}
