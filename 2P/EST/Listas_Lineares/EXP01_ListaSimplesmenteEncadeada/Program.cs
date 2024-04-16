
namespace EXP01_ListaSimplesmenteEncadeada
{
    internal class Program
    {
        private static void Main(string[] args)
        {
            ListaEncadeada lista = new ListaEncadeada();
            lista.AdicionarNoInicio(1);
            lista.AdicionarNoInicio(2);
            lista.AdicionarNoFinal(3);

            Imprimir(lista);

            lista.RemoverNoInicio();
            Imprimir(lista);

            lista.RemoverNoFinal();
            Imprimir(lista);

            Console.ReadKey();
        }

        private static void Imprimir(ListaEncadeada lista)
        {
            No aux = lista.Primeiro;

            Console.Write("Lista: ");

            while (aux != null)
            {
                Console.Write("{0,3}", aux.Valor);
                aux = aux.Proximo;
            }
            Console.WriteLine();
        }
    }
}