package br.edu.vianna.vendas.pagamentos;

public class Pagamento {
    private ETipoPagamento meioPagamento;
    private double valor;

    public Pagamento(){

    }
    public Pagamento(ETipoPagamento meioPagamento, double valor) {
        this.meioPagamento = meioPagamento;
        this.valor = valor;
    }

    public ETipoPagamento getMeioPagamento() {
        return meioPagamento;
    }

    public void setMeioPagamento(ETipoPagamento meioPagamento) {
        this.meioPagamento = meioPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
