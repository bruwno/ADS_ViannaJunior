// Conta de credito.

public class ContaEspecial extends ContaBancaria
{
    private double limite;
    
    public ContaEspecial(String numero, double limite) {
        this.limite = limite;
        setNumeroConta(numero);
    }
    
    public double getLimite() {
        return limite;
    }
    
    @Override
    public void sacar(double valor) {
        if (valor >= 0 && valor <= super.getSaldo() + limite) {
            super.saldo -= valor;
        }
    }
}
