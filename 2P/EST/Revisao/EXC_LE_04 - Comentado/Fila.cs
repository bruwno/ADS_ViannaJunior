public class Fila
{
    // Referência para o primeiro nó (início) da fila
    private No inicio = null;
    // Referência para o último nó (final) da fila
    private No final = null;

    // Propriedade para acessar o início da fila
    public No Inicio { get => inicio; set => inicio = value; }

    // Método para adicionar um valor no final da fila (FIFO)
    public void Adicionar(int valor)
    {
        // Cria um novo nó com o valor fornecido
        No novoNo = new No(valor);
        // Se a fila estiver vazia, define o novo nó como início e final
        if (final == null)
        {
            final = inicio = novoNo;
        }
        else
        {
            // Caso contrário, adiciona o novo nó ao final da fila
            final.Proximo = novoNo;
            final = novoNo;
        }
    }

    // Método para remover o nó do início da fila (FIFO)
    public void Remover()
    {
        // Se a fila estiver vazia, lança uma exceção
        if (inicio == null)
        {
            throw new Exception("A fila está vazia!");
        }

        // Move o início para o próximo nó
        inicio = inicio.Proximo;

        // Se a fila estiver vazia após a remoção, define o final como nulo
        if (inicio == null)
        {
            final = null;
        }
    }

    // Método para percorrer todos os nós da fila e executar uma ação em cada valor
    public void ParaCada(Action<int> acao) 
    {
        var atual = inicio;

        // Percorre cada nó da fila
        while (atual != null)
        {
            // Executa a ação fornecida no valor do nó atual
            acao(atual.Valor);
            atual = atual.Proximo;
        }
    }
}

public class Pilha
{
    // Referência para o nó do topo da pilha
    private No topo;
    // Propriedade para acessar o topo da pilha
    public No Topo { get => topo; set => topo = value; }

    // Método para adicionar um valor no topo da pilha (LIFO)
    public void Empilhar(int valor)
    {
        // Cria um novo nó com o valor fornecido
        No novoNo = new No(valor);
        // Define o próximo do novo nó como o nó do topo atual
        novoNo.Proximo = topo;
        // Define o novo nó como o topo da pilha
        topo = novoNo;
    }

    // Método para remover o nó do topo da pilha (LIFO)
    public void Desempilhar()
    {
        // Se a pilha estiver vazia, lança uma exceção
        if (topo == null)
        {
            throw new Exception("Pilha vazia!");
        }
        else
        {
            // Move o topo para o próximo nó
            topo = topo.Proximo;
        }
    }

    // Método para percorrer todos os nós da pilha e executar uma ação em cada valor
    public void ParaCada(Action<int> acao)
    {
        var atual = topo;

        // Percorre cada nó da pilha
        while (atual != null)
        {
            // Executa a ação fornecida no valor do nó atual
            acao(atual.Valor);
            atual = atual.Proximo;
        }
    }
}

public class Lista
{
    // Referência para o primeiro nó da lista
    private No primeiro = null;
    // Referência para o último nó da lista
    private No ultimo = null;

    // Método para adicionar um valor no início da lista
    public void AdicionarNoInicio(int valor)
    {
        // Cria um novo nó com o valor fornecido
        No novoNo = new No(valor);

        // Se a lista estiver vazia, define o novo nó como primeiro e último
        if (primeiro == null) 
        {
            ultimo = primeiro = novoNo;
        }
        else
        {
            // Caso contrário, adiciona o novo nó no início da lista
            novoNo.Proximo = primeiro;
            primeiro = novoNo;
        }
    }

    // Método para adicionar um valor no final da lista
    public void AdicionarNoFinal(int valor) 
    {
        // Cria um novo nó com o valor fornecido
        No novoNo = new No(valor);

        // Se a lista estiver vazia, define o novo nó como primeiro e último
        if (ultimo == null)
        {
            primeiro = ultimo = novoNo;
        }
        else
        {
            // Caso contrário, adiciona o novo nó no final da lista
            ultimo.Proximo = novoNo;
            ultimo = novoNo;
        }
    }

    // Método para remover o nó do início da lista
    public void RemoverNoInicio()
    {
        // Se a lista estiver vazia, lança uma exceção
        if (primeiro == null)
        {
            throw new Exception("Lista vazia!");
        }

        // Move o primeiro para o próximo nó
        primeiro = primeiro.Proximo;

        // Se a lista ficar vazia após a remoção, define o último como nulo
        if (primeiro == null) 
        {
            ultimo = null;
        }
    }

    // Método para remover o nó do final da lista
    public void RemoverNoFinal()
    {
        // Se a lista estiver vazia, lança uma exceção
        if (primeiro == null) 
        {
            throw new Exception("Lista vazia!");
        }
        // Se a lista tiver apenas um nó, define a lista como vazia
        if (primeiro.Proximo == null)
        {
            primeiro = ultimo = null;
        }
        else
        {
            // Caso contrário, percorre a lista até encontrar o penúltimo nó
            var penultimo = primeiro;
            while (penultimo.Proximo.Proximo != null)
            {
                penultimo = penultimo.Proximo;
            }
            // Define o penúltimo nó como o último e remove a referência ao último nó
            penultimo.Proximo = null;
            ultimo = penultimo;
        }
    }

    // Método para ordenar a lista (bubble sort)
    public void Ordenar()
    {
        // Se a lista estiver vazia, retorna
        if (primeiro == null)
        {
            return;
        }

        No atual = primeiro;

        // Percorre a lista para ordenar
        while (atual.Proximo != null) 
        {
            // Compara o valor do nó atual com o próximo e troca se necessário
            if (atual.Valor > atual.Proximo.Valor)
            {
                Troca(atual, atual.Proximo);
            }
            atual = atual.Proximo;
        }
    }

    // Método auxiliar para trocar os valores de dois nós
    public void Troca(No no1, No no2)
    {
        var aux = no1.Valor;
        no1.Valor = no2.Valor;
        no2.Valor = aux;
    }

    // Método para percorrer todos os nós da lista e executar uma ação em cada valor
    public void ParaCada(Action<int> acao)
    {
        var atual = primeiro;

        // Percorre cada nó da lista
        while (atual != null)
        {
            // Executa a ação fornecida no valor do nó atual
            acao(atual.Valor);
            atual = atual.Proximo;
        }
    }
}
