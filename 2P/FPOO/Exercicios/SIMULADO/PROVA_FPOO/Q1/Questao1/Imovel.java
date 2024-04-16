
public abstract class Imovel {
    private int numero;
    protected int metrosQuadrados;
    private String proprietario;
    
    public Imovel(int numero, int metrosQuadrados, String proprietario) {
        this.numero = numero;
        this.metrosQuadrados = metrosQuadrados;
        this.proprietario = proprietario;
    }
    
    public abstract double valorVenal();
    
    public double valorVenda() {
        return valorVenal() * 0.85;
    }
}   
