package br.com.williamsilva.veiculo;

public class Motor {
    private double cilindradas;
    private String configuracaoMotor;

    public Motor(double cilindradas, String configuracaoMotor) {
        this.cilindradas = cilindradas;
        this.configuracaoMotor = configuracaoMotor;
    }

    public double getCilindradas(){
        return cilindradas;
    }

    public String getConfiguracaoMotor() {
        return configuracaoMotor;
    }
}
