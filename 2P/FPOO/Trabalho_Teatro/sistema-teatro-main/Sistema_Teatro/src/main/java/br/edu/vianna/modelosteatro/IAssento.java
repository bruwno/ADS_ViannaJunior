package br.edu.vianna.modelosteatro;

public interface IAssento {
    public void inicializarAssentos();
    public Assento reservarAssento(int numeroAssento);
    public Assento[][] retornarAssentos();
    public int contarAssentosLivres();
}