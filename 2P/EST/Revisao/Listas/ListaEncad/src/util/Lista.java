package util;

public class Lista<T extends Comparable<T>> {
    private No<T> primeiro; // Cabeça/Head da Lista.
    private No<T> ultimo;

    public Lista() {
        this.primeiro = null;
        this.ultimo = null;
    }

    // INSERÇÕES.
    public void inserirNoInicio(T valor) {
        No<T> novoNo = new No<>(); // Instancia um novo Nó.
        novoNo.setValor(valor); // Define o valor deste Nó.

        if (primeiro == null) {
            primeiro = ultimo = novoNo;
        } else {
            novoNo.setProximo(primeiro);
            primeiro = novoNo;
        }
    }

    public void inserirNoFinal(T valor) {
        No<T> novoNo = new No<>();
        novoNo.setValor(valor);

        if (ultimo == null) {
            ultimo = primeiro = novoNo;
        } else {
            ultimo.setProximo(novoNo);
            ultimo = novoNo;
        }
    }

    public void removerNoInicio() {
        if (primeiro == null) {
            System.out.println("Não é possível remover um elemento de uma lista vazia!");
            return;
        }

        primeiro = primeiro.getProximo(); // Vai pegar a última posição.

        if (primeiro == null) {
            ultimo = null; // Anulando o último, caso o primeiro seja nulo.
        }
    }

    public void removerNoFinal() {
        if (primeiro == null) {
            System.out.println("Não é possível remover um elemento de uma lista vazia!");
            return;
        }

        if (primeiro.getProximo() == null) {
            primeiro = null;
        } else {
            var penultimo = primeiro;

            while (penultimo.getProximo().getProximo() != null) {
                penultimo = penultimo.getProximo();
            }

            if (penultimo != null) {
                penultimo.setProximo(null);
                ultimo = penultimo;
            }
        }
    }

    // AUXILIARES.
    public int getQtdElementos() {
        int tamanho = 0;
        No<T> atual = primeiro;

        while (atual != null) {
            tamanho++;
            atual = atual.getProximo();
        }

        return tamanho;
    }

    public T getValorPosicao(int posicao) {
        int cont = 0;
        No<T> atual = primeiro;

        while (atual != null) {
            if (cont == posicao) {
                return atual.getValor();
            }
            atual = atual.getProximo();
            cont++;
        }

        return null;
    }

    public void setValorPosicao(int posicao, T valor) {
        int cont = 0;
        No<T> atual = primeiro;

        while (atual != null) {
            if (cont == posicao) {
                atual.setValor(valor);
                return;
            }
            atual = atual.getProximo();
            cont++;
        }
    }

    public Lista<T> ordenar(Lista<T> lista) { // Ordenação por InsertionSort
        for (int i = 1; i < getQtdElementos(); i++) {
            T chave = getValorPosicao(i);
            int j;
            for (j = i - 1; j >= 0 && getValorPosicao(j).compareTo(chave) > 0; j--) {
                setValorPosicao(j + 1, getValorPosicao(j));
            }
            setValorPosicao(j + 1, chave);
        }
        return this;
    }
    
    public T getMenorValor() {
        if (primeiro == null) {
            return null;
        }

        T menor = primeiro.getValor();
        No<T> atual = primeiro.getProximo();

        while (atual != null) {
            if (atual.getValor().compareTo(menor) < 0) {
                menor = atual.getValor();
            }
            atual = atual.getProximo();
        }

        return menor;
    }

    public T getMaiorValor() {
        if (primeiro == null) {
            return null;
        }

        T maior = primeiro.getValor();
        No<T> atual = primeiro.getProximo();

        while (atual != null) {
            if (atual.getValor().compareTo(maior) > 0) {
                maior = atual.getValor();
            }
            atual = atual.getProximo();
        }

        return maior;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(); // Otimiza a construção de Strings grandes.
        sb.append("[ ");
        No<T> ponteiro = primeiro;
        while (ponteiro != null) {
            sb.append(ponteiro.getValor() + " ");
            ponteiro = ponteiro.getProximo();
        }
        sb.append("]");

        return sb.toString();
    }
}
