
public class ContaBancaria
{
    private Cliente correntista;
    protected double saldo;
    private String numeroConta;
    private Banco banco; // Relacionamento bi-direcional.
    
    public ContaBancaria() {}
    
    public ContaBancaria(String numeroConta) {
        this.numeroConta = numeroConta;
    }
    
    public Cliente getCorrentista() {
        return this.correntista;
    }
    
    public void setCorrentista(Cliente correntista) {
        this.correntista = correntista;
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    public String getNumeroConta() {
        return this.numeroConta;
    }
    
    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }
      
    public Banco getBanco() {
        return this.banco;
    }
    
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    
    public void depositar(double valor) {
        if (valor >= 0) {
            this.saldo += valor;
        }
    }
    
    public void sacar(double valor) {
        if (valor >= 0 && valor <= saldo) {
            this.saldo -= valor;
        }
    }
}
