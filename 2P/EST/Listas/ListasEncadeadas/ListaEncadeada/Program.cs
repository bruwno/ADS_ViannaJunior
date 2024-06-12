
var lista = new ListaEncadeada<int>();

lista.AdicionarNoInicio(10);
lista.AdicionarNoInicio(7);
lista.AdicionarNoInicio(2); //2 7 10
lista.AdicionarNoFinal(50); //2 7 10 50 1
lista.AdicionarNoFinal(1);

lista.RemoverNoInicio(); //7 10 50 1
lista.RemoverNoFinal();//7 10 50

lista.ParaCada(x => Console.Write($"{x} "));
Console.WriteLine();

/*
int soma = 0;
lista.ParaCada(x => soma += x);
Console.WriteLine($"Soma: {soma}");
*/

/*
var noAtual = lista.Primeiro;

while (noAtual != null)
{
    Console.Write($"{noAtual.Valor}  ");
    noAtual = noAtual.Proximo;
}
*/