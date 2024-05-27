class No<T>
{
    private T valor;
    private No<T>? proximo = null;

    public T Valor
    {
        get { return valor; }
        set { valor = value; }
    }
    
    public No<T>? Proximo
    {
        get { return proximo; }
        set { proximo = value; }
    }    
}