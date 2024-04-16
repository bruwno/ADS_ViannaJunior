
public class Pagamento
{
    private int mesAno;
    private double valorPago;
    private Imovel imovel;
    private Condominio condominio;
    
    Pagamento() {};
    
    Pagamento(int mesAno, double valorPago, Imovel imovel, Condominio condominio) {
        this.mesAno = mesAno;
        this.valorPago = valorPago;
        this.imovel = imovel;
        this.condominio = condominio;
    }
    
    public int getMesAno()
    {
        return this.mesAno;
    }
    
    public void setMesAno(int mesAno) {
        this.mesAno = mesAno;
    }
}
