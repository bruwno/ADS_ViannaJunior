
public class Despesa {
    private int mesAno;
    private String descricao;
    private double valor;
    private boolean taxaExtra;
    
    public Despesa(int mesAno, String descricao, double valor, boolean taxaExtra) {
        this.mesAno = mesAno;
        this.descricao = descricao;
        this.valor = valor;
        this.taxaExtra = taxaExtra;
    }
    
    public int getMesAno()
    {
        return this.mesAno;
    }
    
    public void setMesAno(int mesAno)
    {
        this.mesAno = mesAno;
    }
    
    public String getdescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        if (descricao != null && !descricao.equals("")) {
            this.descricao = descricao;
        }
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
}
