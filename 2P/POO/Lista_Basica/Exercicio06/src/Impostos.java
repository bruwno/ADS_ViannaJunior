public class Impostos {
    public double aplicaImpostoIPI(double valor) {
        return (valor > 0) ? valor * 0.20 : 0;
    }

    public double aplicaIsencaoImpostoIPI(double valor) {
        double valorComDesconto = valor - (valor * 0.10);
        return (valor > 0) ? valorComDesconto : 0;
    }
}
