
public class Horista extends Empregado
{
    private double precoHora;
    private double horasTrabalhadas;
    
    public double vencimento() {
        return this.precoHora * this.horasTrabalhadas;
    }
}