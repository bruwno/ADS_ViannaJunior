
public class Pagamento
{
    private int mesAno;
    private double valorPago;
    
    Pagamento(int mesAno, double valorPago) {
        this.mesAno = mesAno;
        this.valorPago = valorPago;
    }
    
    public int getMesAno()
    {
        return this.mesAno;
    }
    
    public void setMesAno(int mesAno) {
        this.mesAno = mesAno;
    }
    
    
}
