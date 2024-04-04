package br.com.williamsilva.veiculo;

public class ModeloCarro extends Carro {

    public ModeloCarro(String modelo, String marca, String tipoDePintura, Motor potenciaMotor, boolean isImportado, double precoBase) {
        super.modelo = modelo;
        super.marca = marca;
        super.tipoPintura = tipoDePintura;
        super.motor = potenciaMotor;
        super.importado = isImportado;
        super.precoBase = precoBase;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipoDePintura() {
        return tipoPintura;
    }

    public void setTipoDePintura(String tipoDePintura) {
        this.tipoPintura = tipoDePintura;
    }

    public double getPotenciaMotor() {
        return motor.getPotenciaMotor();
    }

    public void setPotenciaMotor(Motor potenciaMotor) {
        this.motor = potenciaMotor;
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
}
