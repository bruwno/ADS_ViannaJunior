import java.util.ArrayList;

public class Condominio {
    private String nome;
    private String endereco;
    private ArrayList<Despesa> despesas;
    private ArrayList<Imovel> imoveis;
    private ArrayList<Pagamento> pagamentos;
    
    public Condominio() {
        this("",""); // Referente ao nome e endereco, passados como vazios.
    }
    
    public Condominio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.despesas = new ArrayList<>();
        this.imoveis = new ArrayList<>();
        this.pagamentos = new ArrayList<>();
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
        double somaDespesas = 0;
        for (Despesa d : despesas) {
            if (d.getMesAno() == mesAno) {
                somaDespesas += d.getValor();
            }
        }
        return somaDespesas / imoveis.size();
    }
    
    public String relatorio(int mesAno) {
        int totalPago = totalPagamentos(mesAno);
        double valorCond = valorCondominio(mesAno);
        String relatorio = "MES :: " + mesAno + "\n";
        relatorio += imoveis.size() + " apartamentos (" + totalPago + " pagos - " +
        (imoveis.size() - totalPago) + " não pagos)";
        relatorio += "Valores arrecadados: R$ " + (totalPago * valorCond) + " valor a ser pago R$ " +
        (imoveis.size() - totalPago) * valorCond;
        
        return relatorio;
    }
    
    public int totalPagamentos(int mesAno) {
        int totalPagos = 0;
        for (Pagamento p : pagamentos) {
            if (p.getMesAno() == mesAno) {
                totalPagos++;
            }
        }
        return totalPagos;
    }
    
    public void pagarCondominio(Imovel imovel, int mesAno) {
        Pagamento pg = new Pagamento(mesAno, valorCondominio(mesAno), imovel, this);
        addPagamento(pg);
    }
     
    
    
}
