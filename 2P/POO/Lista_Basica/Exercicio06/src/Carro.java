public class Carro {
    private String modelo;
    private String marca;
    private Motor motor;
    private Acessorios acessorios;
    private boolean importado;

    public Carro() {}

    public Carro(String modelo, String marca, Motor motor, Acessorios acessorios, boolean importado) {
        this.modelo = modelo;
        this.marca = marca;
        this.motor = motor;
        this.acessorios = acessorios;
        this.importado = importado;
    }

    public double valorFinalCarro() {
        return 0;
    }
}
