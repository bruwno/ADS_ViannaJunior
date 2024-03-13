package br.com.williamsilva.veiculo;

public class Motor {
    private double cilindradas;
    private String configuracaoMotor;

    public Motor(double cilindradas, String configuracaoMotor) {
        this.cilindradas = cilindradas;
        this.configuracaoMotor = configuracaoMotor;
    }

    public Motor() {}

    public double getCilindradas(){
        return cilindradas;
    }

    public void setCilindradas(double cilindradas) {
        if (cilindradas > 0) {
            this.cilindradas = cilindradas;
        }
    }

    public String getConfiguracaoMotor() {
        return configuracaoMotor;
    }

    public void setConfiguracaoMotor(String configuracaoMotor) {
        if (!configuracaoMotor.isEmpty()) {
            this.configuracaoMotor = configuracaoMotor;
        }
    }
}
