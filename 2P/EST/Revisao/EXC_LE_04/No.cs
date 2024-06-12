public class No
{
    private int valor;
    private No proximo = null;

    public int Valor { get => valor; set => valor = value; }
    public No Proximo { get => proximo; set => proximo = value; }

    public No(int valor) 
    {
        this.valor = valor;
    }
}