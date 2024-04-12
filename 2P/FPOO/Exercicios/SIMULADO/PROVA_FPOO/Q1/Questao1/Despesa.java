
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
    
    
}
