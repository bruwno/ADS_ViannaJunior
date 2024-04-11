
public class Condominio {
    private String nome;
    private String endereco;
    
    public Condominio() {}
    
    public Condominio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
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
    
    public double valorCondominio(int mesAno) {
        return 0;
    }
    
    public void pagarCondominio(Imovel imovel, int mesAno) {
        
    }
}
