
public class Casa extends Imovel {
    private int metragemTerreno;
    
    public Casa() {
        super(0,0,"");
        this.metragemTerreno = 0;
    }
    
    public Casa(int numero, int metrosQuadrados, String proprietario, int metragemTerreno) {
        super(numero, metrosQuadrados, proprietario);
        this.metragemTerreno = metragemTerreno;
    }
    
}
