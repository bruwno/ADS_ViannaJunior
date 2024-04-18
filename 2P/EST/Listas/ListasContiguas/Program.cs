using System;

namespace ListasContiguas
{
    class Program
    {
        static void Main(string[] args)
        {
            // var lista = new ListaContigua();

            // lista.AdicionarNoFinal(7);
            // lista.AdicionarNoFinal(10);
            // lista.AdicionarNoFinal(5);

            // Imprimir(lista);

            // lista.RemoverNoFinal();

            // Imprimir(lista);

            var lista = new ListaContigua2();

            lista.AdicionarNoFinal(5);  //5
            lista.AdicionarNoFinal(6);  //5 6
            lista.AdicionarNoFinal(7);  //5 6 7
            lista.AdicionarNoInicio(3); //3 5 6 7
            lista.AdicionarNoInicio(2); //2 3 5 6 7

            Imprimir2(lista);

            lista.RemoverNoFinal();  //2 3 5 6
            lista.RemoverNoInicio(); //3 5 6

            Imprimir2(lista);
        }

        static void Imprimir(ListaContigua lista)
        {
            for (int i = 0; i < lista.Tamanho; i++)
                Console.Write($"{lista.Get(i)}  ");

            Console.WriteLine();
        }

        static void Imprimir2(ListaContigua2 lista)
        {
            for (int i = 0; i < lista.Tamanho; i++)
                Console.Write($"{lista.Get(i)}  ");

            Console.WriteLine();
        }
    }
}