package br.vianna.aula.Servlet.model;

public class Abastecer {

    private double precoGasolina, precoAlcool;

    public Abastecer() {}

    public Abastecer(double precoGasolina, double precoAlcool) {
        this.precoGasolina = precoGasolina;
        this.precoAlcool = precoAlcool;
    }

    public double percPreco(){
        double perc = precoAlcool*100/precoGasolina;

        return perc;
    }
    public boolean abastecerComGasolina(){
        return  percPreco() >= 70;
    }

    public double getPrecoGasolina() {
        return precoGasolina;
    }

    public void setPrecoGasolina(double precoGasolina) {
        this.precoGasolina = precoGasolina;
    }

    public double getPrecoAlcool() {
        return precoAlcool;
    }

    public void setPrecoAlcool(double precoAlcool) {
        this.precoAlcool = precoAlcool;
    }
}
