public class Pilha
{
    private No? topo;
    public No? Topo { get => topo; set => topo = value; }

    public void Empilhar(char valor)
    {
        No novoNo = new No(valor);
        novoNo.Proximo = topo;
        topo = novoNo;
    }

    public void Desempilhar()
    {
        if (topo == null)
        {
            throw new Exception("Não é possivel remover um elemento em uma pilha vazia!");
        }

        topo = topo.Proximo;
    }

    public void DesempilharRecursivo()
    {
        if (topo == null)
        {
            return;
        }
        Desempilhar();
        DesempilharRecursivo();
    }

    public void ParaCada(Action<char> acao)
    {
        var atual = topo;

        while (atual != null)
        {
            acao(atual.Valor);
            atual = atual.Proximo;
        }
    }

    public void ParaCadaRecursivo()
    {
        ParaCadaRecursivo2(topo!);
    }

    private void ParaCadaRecursivo2(No atual)
    {
        if (atual == null)
        {
            return;
        }
        ParaCadaRecursivo2(atual.Proximo!);
        Console.Write(atual.Valor);
    }
}