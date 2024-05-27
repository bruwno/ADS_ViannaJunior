class ListaEncadeada<T>
{
    private No<T>? primeiro = null;
    private No<T>? ultimo = null;

    public void AdicionarNoInicio(T valor)
    {
        var novoNo = new No<T> { Valor = valor };

        if (primeiro == null)
            primeiro = ultimo = novoNo;
        else
        {
            novoNo.Proximo = primeiro;
            primeiro = novoNo;
        }
    }

    public void AdicionarNoFinal(T valor)
    {
        var novoNo = new No<T> { Valor = valor };

        if (ultimo == null)
            ultimo = primeiro = novoNo;
        else
        {
            ultimo.Proximo = novoNo;
            ultimo = novoNo;
        }
    }

    public void RemoverNoInicio()
    {
        if (primeiro == null)
        {
            throw new Exception("Não é possível remover um elemento de uma lista vazia.");
        }

        primeiro = primeiro.Proximo;

        if (primeiro == null)
            ultimo = null;
    }

    public void RemoverNoFinal()
    {
        if (primeiro == null)
        {
            throw new Exception("Não é possível remover um elemento de uma lista vazia.");
        }

        if (primeiro.Proximo == null)
        {
            primeiro = null;
        }
        else
        {
            var penultimo = primeiro;

            while (penultimo?.Proximo?.Proximo != null)
            {
                penultimo = penultimo.Proximo;
            }

            if (penultimo != null)
            {
                penultimo.Proximo = null;
                ultimo = penultimo;
            }
        }
    }

    public void ParaCada(Action<T> visitar)
    {
        var atual = primeiro;

        while (atual != null)
        {
            visitar(atual.Valor);
            atual = atual.Proximo;
        }
    }
}