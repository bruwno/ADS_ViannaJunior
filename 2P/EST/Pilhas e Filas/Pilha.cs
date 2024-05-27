class Pilha<T>
{
    private No<T>? topo = null;
    public No<T>? Topo => topo;

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
        if (topo == null) {
            throw new Exception("Não é possível desempilhar um elemento em uma pilha vazia.");
        }
        
        topo = topo.Proximo;
    }
}