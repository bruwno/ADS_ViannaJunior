public class Emprestimo {
    private double valor;
    private double taxaDeJuros;
    private int prazoParaPagamento;

    public Emprestimo() {}
    public Emprestimo(double valor, double taxaDeJuros, int prazoParaPagamento) {
        this.valor = valor;
        this.taxaDeJuros = taxaDeJuros;
        this.prazoParaPagamento = prazoParaPagamento;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }
    public void setTaxaDeJuros(double taxaDeJuros) {
        this.taxaDeJuros = taxaDeJuros;
    }
    public int getPrazoParaPagamento() {
        return prazoParaPagamento;
    }
    public void setPrazoParaPagamento(int prazoParaPagamento) {
        this.prazoParaPagamento = prazoParaPagamento;
    }


    public double calculaValorMensalidade() {
        taxaDeJuros /= 100.0;
        return valor * (taxaDeJuros) / (1 - Math.pow(1 + taxaDeJuros, - prazoParaPagamento));
    }

    public double calculaValorTotalPago() {
        return calculaValorMensalidade() * prazoParaPagamento;
    }

    public double calculaValorTotalEmJuros() {
        return calculaValorTotalPago() - valor;
    }
}
