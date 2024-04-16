
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
        return (metrosQuadrados * 1500);
    }
    
    public double valorVenda() {
        return super.valorVenda() + valorTerreno();
    }
    
    // Vem da interface.
    public double valorTerreno() {
        return metragemTerreno * 350;
    }
}
