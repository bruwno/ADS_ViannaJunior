import java.util.ArrayList;

public class Banco {
    private String nome, sigla;
    private Gerente gerente;
    private ArrayList<Bancario> bancarios;
    //private Endereco endereco;
    private ArrayList<ContaBancaria> contas;
    
    public Banco() {
        bancarios = new ArrayList<>();
        contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSigla() {
        return sigla;
    }
    
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    public Gerente getGerente() {
        return gerente;
    }
    
    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }
    
    public ArrayList<Bancario> getBancarios() {
       return bancarios; 
    }
    
    public void addBancario(Bancario bancario) {
        bancarios.add(bancario);
    }
    
    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }
    
    public void addConta(ContaBancaria conta) {
        contas.add(conta);
    }
}