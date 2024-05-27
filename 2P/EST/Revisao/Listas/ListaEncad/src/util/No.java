package util;

public class No<T> {
    private T valor;
    private No<T> proximo = null; // Definição recursiva.

    public No() {}

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
}