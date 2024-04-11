public class Poupanca extends ContaBancaria
{
    public Poupanca(String numero) {
        setNumeroConta(numero);
    }
    
    public void rendimento() {
        double rendimento = getSaldo() * 0.01;
        depositar(rendimento);
    }
}