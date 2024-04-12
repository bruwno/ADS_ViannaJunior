import java.util.ArrayList;

public class Condominio {
    private String nome;
    private String endereco;
    private ArrayList<Despesa> despesas;
    private ArrayList<Imovel> imoveis;
    private ArrayList<Pagamento> pagamentos;
    
    public Condominio() {
        this("",""); // Referente ao nome e endereco, passados como vazios.
        this.despesas = new ArrayList<>();
        this.imoveis = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
    }
    
    public Condominio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.despesas = new ArrayList<>();
        this.imoveis = new ArrayList<>();
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        if (!nome.equals("") && nome != null) {
            this.nome = nome;
        }
    }
    
    public String getEndreco() {
        return this.endereco;
    }
    
    public void setEndereco(String endereco) {
        if (!endereco.equals("") && endereco != null) {
            this.endereco = endereco;
        }
    }
    
    public ArrayList<Despesa> getDespesas() {
        return this.despesas;
    }
    
    public void addDespesa(Despesa despesa) {
        despesas.add(despesa);
    }
    
    public ArrayList<Imovel> getImovel() {
        return imoveis;
    }
    
    public void addImovel (Imovel imovel) {
        this.imoveis.add(imovel);
    }
    
    public ArrayList<Pagamento> getPagamento() {
        return this.pagamentos;
    }
    
    public void addPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
    }
    
    public double valorCondominio(int mesAno) {
        return 0;
    }
    
    public String relatorio(int mesAno) {
        return "";
    }
        
    public void pagarCondominio(Imovel imovel, int mesAno) {
        
    }
     
}
