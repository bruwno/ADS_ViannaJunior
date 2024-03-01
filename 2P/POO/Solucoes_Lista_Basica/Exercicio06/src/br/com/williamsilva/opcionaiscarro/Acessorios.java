package br.com.williamsilva.opcionaiscarro;

public class Acessorios {
    private final boolean arCondicionado;
    private final boolean vidroAutomatico;
    private final boolean cambioAutomatico;
    private final boolean alarme;
    private final boolean tipoDePintura;
    private final boolean tetoSolar;
    private final boolean kitMultimidia;

    public Acessorios(boolean arCondicionado, boolean vidroAutomatico, boolean cambioAutomatico, boolean alarme, boolean tipoDePintura, boolean tetoSolar, boolean kitMultimidia) {
        this.arCondicionado = arCondicionado;
        this.vidroAutomatico = vidroAutomatico;
        this.cambioAutomatico = cambioAutomatico;
        this.alarme = alarme;
        this.tipoDePintura = tipoDePintura;
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
                return tipoDePintura;
            case TETO_SOLAR:
                return tetoSolar;
            case KIT_MULTIMIDIA:
                return kitMultimidia;
            default:
                return false;
        }
    }

    public double valorTotalEmAcessorios() {
        return adicionalArCondicionado() + adicionalVidroAutomativo() + adicionalCambioAutomatico() + adicionalAlarme() +
                adicionalTipoPintura() + adicionalTetoSolar() + adicionalKitMultimidia();
    }

    private double adicionalArCondicionado() {
        return (arCondicionado) ? 3000 : 0;
    }

    private double adicionalVidroAutomativo() {
        return vidroAutomatico ? 1500 : 0;
    }

    private double adicionalCambioAutomatico() {
        return (cambioAutomatico) ? 5000 : 0;
    }

    private double adicionalAlarme() {
        return (alarme) ? 800 : 0;
    }

    private double adicionalTipoPintura() {
        return (tipoDePintura) ? 2500 : 0;
    }

    private double adicionalTetoSolar(){
        return (tetoSolar) ? 4000 : 0;
    }

    private double adicionalKitMultimidia() {
        return (kitMultimidia) ? 1800 : 0;
    }
}
