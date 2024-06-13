public class No
{
    private char valor;
    private No? proximo = null;

    public char Valor { get=> valor; set => valor = value; }
    public No? Proximo { get => proximo; set => proximo = value; }

    public No(char valor)
    {
        this.valor = valor;
    }
}