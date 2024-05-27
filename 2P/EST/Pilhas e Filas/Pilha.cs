class Pilha<T>
{
    public void Empilhar(T valor)
    {
        var novoNo = new No<T>
        {
            Valor = valor
        };

        novoNo.Proximo = topo;
        topo = novoNo;
    }

    public void Desempilhar()
    {
        if (topo == null)
            throw new Exception("Não é possível desempilhar um elemento em uma pilha vazia.");
        
        topo = topo.Proximo;
    }

    public No<T>? Topo => topo;
    
    private No<T>? topo = null;
}