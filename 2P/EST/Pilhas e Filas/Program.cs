
/*
var pilha = new Pilha<int>();

pilha.Empilhar(3); //3
pilha.Empilhar(2); //2 3
pilha.Empilhar(1); //1 2 3

while (pilha.Topo != null)
{
    Console.WriteLine(pilha.Topo.Valor);
    pilha.Desempilhar();
}
*/

var fila = new Fila<int>();

fila.Adicionar(3); //3
fila.Adicionar(2); //3 2
fila.Adicionar(1); //3 2 1

while (fila.Inicio != null)
{
    Console.WriteLine(fila.Inicio.Valor);
    fila.Remover();
}

/*
LISTA ENCADEADA
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