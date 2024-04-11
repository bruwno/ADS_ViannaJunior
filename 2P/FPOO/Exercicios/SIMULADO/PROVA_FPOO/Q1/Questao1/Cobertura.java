
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
    
}