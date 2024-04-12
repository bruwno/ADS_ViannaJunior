
public class Cobertura extends Imovel {
    private boolean duplex;
    private boolean triplex;
    
    public Cobertura()
    {
        super(0,0,"");
        this.duplex = false;
        this.triplex = false;
    }
    
    public Cobertura(int numero, int metrosQuadrados, String proprietario, boolean duplex, boolean triplex)
    {
        super(numero, metrosQuadrados, proprietario);
        this.duplex = duplex;
        this.triplex = triplex;
    }
    
    public boolean getDuplex(){
        return this.duplex;
    }
    
    public void setDuplex(boolean duplex) {
        this.duplex = duplex;
    }
    
    public boolean getTriplex() {
        return this.triplex;
    }
    
    public void setTriplex(boolean triplex) {
        this.triplex = triplex;
    }
    
    public double valorVenda() {
        return 0;
    }
    
    @Override
    public double valorVenal() {
        return 0;
    }
}