class No<T>
{
    private T valor;
    public T Valor
    {
        get { return valor; }
        set { valor = value; }
    }
    
    private No<T>? proximo = null;
    public No<T>? Proximo
    {
        get { return proximo; }
        set { proximo = value; }
    }    
}