class Fila<T>
{
    private No<T>? inicio = null;
    private No<T>? final = null;
    public No<T>? Inicio => inicio;

    public void Adicionar(T valor)
    {
        var novoNo = new No<T>
        {
            Valor = valor
        };

        if (final == null)
        {
            final = inicio = novoNo;
        }
        else
        {
            final.Proximo = novoNo;
            final = novoNo;
        }
    }

    public void Remover()
    {
        if (inicio == null)
        {
            throw new Exception("Fila vazia!");
        }

        inicio = inicio.Proximo;

        if (inicio == null)
        {
            final = null;
        }
    }
}