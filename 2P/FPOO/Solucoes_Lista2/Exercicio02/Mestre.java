
public class Mestre extends Professor
{
    @Override
    public double valorHoraAula() {
        double valorHoraAula = super.valorHoraAula();
        return valorHoraAula += super.valorHoraAula() * 0.45;
    }
}
