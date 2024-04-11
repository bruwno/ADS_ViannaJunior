import java.util.ArrayList;

public class Cliente
{
    private String nome;
    private ArrayList<ContaBancaria> contas;// Relacionamento bi-direcional. A Conta tem um correntista e um correntista tem uma conta.
    
    public Cliente(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
        
    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }
    
    public void addConta(ContaBancaria conta) {
        contas.add(conta);
    }
    
    public double saldoContas() {
        double somaSaldos = 0;
        
        for (var conta : contas) {
            somaSaldos += conta.getSaldo();
        }
        return somaSaldos;
        /*
         for (int i = 0; i < contas.size(); i++) {
            somaSaldos += contas.get(i).getSaldo();
         }
        */
    }
}
