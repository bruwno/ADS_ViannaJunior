
public class Casa extends Imovel implements CondominioFechado {
    private int metragemTerreno;
    
    public Casa() {
        super(0,0,"");
        this.metragemTerreno = 0;
    }
    
    public Casa(int numero, int metrosQuadrados, String proprietario, int metragemTerreno) {
        super(numero, metrosQuadrados, proprietario);
        this.metragemTerreno = metragemTerreno;
    }
    
    @Override
    public double valorVenal() {
        return 0;
    }
    
    public double valorVenda() {
        return 0;
    }
    
    // Vem da interface.
    public double valorTerreno() {
        return 0;
    }
}
