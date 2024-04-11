package br.com.williamsilva.opcionaiscarro;

import static br.com.williamsilva.opcionaiscarro.TiposDeAcessorios.*;

public class
Acessorios {
    private boolean arCondicionado;
    private boolean vidroAutomatico;
    private boolean cambioAutomatico;
    private boolean alarme;
    private boolean pinturaCustomizada;
    private String tipoPintura;
    private boolean tetoSolar;
    private boolean kitMultimidia;

    public Acessorios() {}

    public Acessorios(boolean arCondicionado, boolean vidroAutomatico, boolean cambioAutomatico, boolean alarme, boolean pinturaCustomizada, String tipoPintura, boolean tetoSolar, boolean kitMultimidia) {
        this.arCondicionado = arCondicionado;
        this.vidroAutomatico = vidroAutomatico;
        this.cambioAutomatico = cambioAutomatico;
        this.alarme = alarme;
        this.pinturaCustomizada = pinturaCustomizada;
        this.tipoPintura = tipoPintura;
        this.tetoSolar = tetoSolar;
        this.kitMultimidia = kitMultimidia;
    }

    public boolean temAcessorio(TiposDeAcessorios acessorio) {
        switch (acessorio) {
            case AR_CONDICIONADO:
                return arCondicionado;
            case VIDRO_AUTOMATICO:
                return vidroAutomatico;
            case CAMBIO_AUTOMATICO:
                return cambioAutomatico;
            case ALARME:
                return alarme;
            case PINTURA:
                return pinturaCustomizada;
            case TETO_SOLAR:
                return tetoSolar;
            case KIT_MULTIMIDIA:
                return kitMultimidia;
            default:
                return false;
        }
    }

    // Métodos acessores.
    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean isVidroAutomatico() {
        return vidroAutomatico;
    }

    public void setVidroAutomatico(boolean vidroAutomatico) {
        this.vidroAutomatico = vidroAutomatico;
    }

    public boolean isCambioAutomatico() {
        return cambioAutomatico;
    }

    public void setCambioAutomatico(boolean cambioAutomatico) {
        this.cambioAutomatico = cambioAutomatico;
    }

    public boolean isAlarme() {
        return alarme;
    }

    public void setAlarme(boolean alarme) {
        this.alarme = alarme;
    }

    public boolean isPinturaCustomizada() {
        return pinturaCustomizada;
    }

    public void setPinturaCustomizada(boolean pinturaCustomizada) {
        this.pinturaCustomizada = pinturaCustomizada;
    }

    public String getTipoPintura() {
        return tipoPintura;
    }

    public void setTipoPintura(String tipoPintura) {
        if (!tipoPintura.isEmpty()) {
            this.tipoPintura = tipoPintura;
        }
    }

    public boolean isTetoSolar() {
        return tetoSolar;
    }

    public void setTetoSolar(boolean tetoSolar) {
        this.tetoSolar = tetoSolar;
    }

    public boolean isKitMultimidia() {
        return kitMultimidia;
    }

    public void setKitMultimidia(boolean kitMultimidia) {
        this.kitMultimidia = kitMultimidia;
    }

    // Métodos da classe.
    public double valorTotalEmAcessorios() {
        return adicionalArCondicionado() + adicionalVidroAutomativo() + adicionalCambioAutomatico() + adicionalAlarme() +
                adicionalTipoPintura() + adicionalTetoSolar() + adicionalKitMultimidia();
    }

    private double adicionalArCondicionado() {
        return (arCondicionado) ? AR_CONDICIONADO.getPrecoAcessorio() : 0;
    }

    private double adicionalVidroAutomativo() {
        return vidroAutomatico ? VIDRO_AUTOMATICO.getPrecoAcessorio() : 0;
    }

    private double adicionalCambioAutomatico() {
        return (cambioAutomatico) ? CAMBIO_AUTOMATICO.getPrecoAcessorio() : 0;
    }

    private double adicionalAlarme() {
        return (alarme) ? ALARME.getPrecoAcessorio() : 0;
    }

    private double adicionalTipoPintura() {
        return (pinturaCustomizada) ? PINTURA.getPrecoAcessorio() : 0;
    }

    private double adicionalTetoSolar() {
        return (tetoSolar) ? TETO_SOLAR.getPrecoAcessorio() : 0;
    }

    private double adicionalKitMultimidia() {
        return (kitMultimidia) ? KIT_MULTIMIDIA.getPrecoAcessorio() : 0;
    }
}
