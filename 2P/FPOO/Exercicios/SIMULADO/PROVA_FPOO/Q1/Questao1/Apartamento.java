
public class Apartamento extends Imovel {
    private int nroQuarto;
    
    public Apartamento() {
        super(0,0,"");
        this.nroQuarto = 0;
    }
    
    public Apartamento(int numero, int metrosQuadrados, String proprietario, int nroQuarto) {
        super(numero, metrosQuadrados, proprietario);
        this.nroQuarto = nroQuarto;
    }
    
    public int getNroQuarto() {
        return this.nroQuarto;
    }
    
    public void setNroQuarto(int nroQuarto) {
        this.nroQuarto = nroQuarto;
    }
    
    @Override
    public double valorVenal() {
        return (metrosQuadrados * 1000) + (nroQuarto * 500);
    }
}
