
public class Comissionado extends Empregado
{
    private double totalVenda;
    private double taxaComissao;
    
    public double vencimento() {
        return this.totalVenda - taxaComissao;
    }
}