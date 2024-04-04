package br.com.williamsilva.veiculo;

public class Motor {
    private double potenciaMotor;

    public Motor() {}

    public Motor(double potenciaMotor) {
        this.potenciaMotor = potenciaMotor;
    }

    public double getPotenciaMotor(){
        return potenciaMotor;
    }

    public void setPotenciaMotor(double potenciaMotor) {
        if (potenciaMotor > 0) {
            this.potenciaMotor = potenciaMotor;
        }
    }
}
