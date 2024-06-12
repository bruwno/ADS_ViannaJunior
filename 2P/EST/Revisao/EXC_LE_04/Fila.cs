public class Fila
{
    private No inicio = null;
    private No final = null;

    public No Inicio { get => inicio; set => inicio = value; }

    public void Adicionar(int valor)
    {
        No novoNo = new No(valor);
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
            throw new Exception("A fila está vazia!");
        }

        inicio = inicio.Proximo;

        if (inicio == null)
        {
            final = null;
        }
    }

    public void ParaCada(Action<int> acao) 
    {
        var atual = inicio;

        while (atual != null)
        {
            acao(atual.Valor);
            atual = atual.Proximo;
        }
    }
}

public class Pilha
{
    private No topo;
    public No Topo { get => topo; set => topo = value; }

    public void Empilhar(int valor)
    {
        No novoNo = new No(valor);
        novoNo.Proximo = topo;
        topo = novoNo;
    }

    public void Desempilhar()
    {
        if (topo == null)
        {
            throw new Exception("Pilha vazia!");
        }
        else
        {
            topo = topo.Proximo;
        }
    }

    public void ParaCada(Action<int> acao)
    {
        var atual = topo;

        while (atual != null)
        {
            acao(atual.Valor);
            atual = atual.Proximo;
        }
    }
}

public class Lista
{
    private No primeiro = null;
    private No ultimo = null;

    public void AdicionarNoInicio(int valor)
    {
        No novoNo = new No(valor);

        if (primeiro == null) 
        {
            ultimo = primeiro = novoNo;
        }
        else
        {
            novoNo.Proximo = primeiro;
            primeiro = novoNo;
        }

    }

    public void AdicionarNoFinal(int valor) 
    {
        No novoNo = new No(valor);

        if (ultimo == null)
        {
            primeiro = null;
        }
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
            throw new Exception("Lista vazia!");
        }

        primeiro = primeiro.Proximo;

        if (primeiro == null) 
        {
            ultimo = null;
        }
    }

    public void RemoverNoFinal()
    {
        if (primeiro == null) 
        {
            throw new Exception("Lista vazia!");
        }
        if (primeiro.Proximo == null)
        {
            primeiro = null;
        }
        else
        {
            var penultimo = primeiro;

            while (penultimo.Proximo.Proximo != null)
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

    public void Ordenar()
    {
        if (primeiro == null)
        {
            return;
        }

        No atual = primeiro;

        while (atual.Proximo != null) 
        {
            if (atual.Valor > atual.Proximo.Valor)
            {
                Troca(atual, atual.Proximo);
            }
            atual = atual.Proximo;
        }
    }

    public void Troca(No no1, No no2)
    {
        var aux = no1.Valor;
        no1.Valor = no2.Valor;
        no2.Valor = aux;
    }

    public void ParaCada(Action<int> acao)
    {
        var atual = primeiro;

        while (atual != null)
        {
            acao(atual.Valor);
            atual = atual.Proximo;
        }
    }
}