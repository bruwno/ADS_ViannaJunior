
public class Cobertura extends Imovel {
    private boolean duplex;
    private boolean triplex;
    
    public Cobertura() {
        super(0,0,"");
    }
    
    public Cobertura(int numero, int metrosQuadrados, String proprietario, boolean duplex, boolean triplex) {
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
    
    @Override
    public double valorVenal() {
        int multiplicadorDuplex = (duplex) ? 2 : 1;
        int multiplicadorTriplex = (triplex) ? 3 : 1;
        return (metrosQuadrados * 1000) * multiplicadorDuplex * multiplicadorTriplex;
    }
}