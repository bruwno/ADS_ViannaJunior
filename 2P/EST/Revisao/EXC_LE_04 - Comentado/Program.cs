namespace EXC_LE_04;

class Program
{
    static void Main(string[] args)
    {
        System.Console.WriteLine("FILA");
        Fila fila = new Fila();
        fila.Adicionar(10);
        fila.Adicionar(20);
        fila.Adicionar(30);
        fila.Adicionar(40);
        fila.Remover();
        fila.ParaCada(x => Console.WriteLine(x));

        System.Console.WriteLine("PILHA");
        Pilha pilha = new Pilha();
        pilha.Empilhar(100);
        pilha.Empilhar(200);
        pilha.Empilhar(300);
        pilha.Empilhar(400);
        pilha.ParaCada(x => Console.WriteLine(x));

        pilha.Desempilhar();
        pilha.ParaCada(x => Console.WriteLine(x));

        System.Console.WriteLine("LISTA");
        Lista lista = new Lista();
        lista.AdicionarNoInicio(1000);
        lista.AdicionarNoInicio(2000);
        lista.ParaCada(x => Console.WriteLine(x));

        // REMOVENDO NO FINAL
        lista.RemoverNoFinal();
        lista.ParaCada(x => Console.WriteLine(x));

        // ORDENANDO
        lista.Ordenar();
        lista.ParaCada(x => Console.WriteLine(x));
    }
}
