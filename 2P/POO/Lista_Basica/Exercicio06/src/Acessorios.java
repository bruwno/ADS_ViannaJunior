public class Acessorios {
    private double valorCarro;
    private boolean arCondicionado;
    private boolean vidroAutomatico;
    private boolean cambioAutomatico;
    private boolean alarme;
    private boolean tipoPintura;
    private boolean tetoSolar;
    private boolean kitMultimidia;

    public Acessorios(double valorCarro, boolean arCondicionado, boolean vidroAutomatico, boolean cambioAutomatico, boolean alarme, boolean tipoPintura, boolean tetoSolar, boolean kitMultimidia) {
        this.valorCarro = valorCarro;
        this.arCondicionado = arCondicionado;
        this.vidroAutomatico = vidroAutomatico;
        this.cambioAutomatico = cambioAutomatico;
        this.alarme = alarme;
        this.tipoPintura = tipoPintura;
        this.tetoSolar = tetoSolar;
        this.kitMultimidia = kitMultimidia;
    }

    public double valorTotalEmAcessorios() {
        return valorCarro + adicionalArCondicionado() + adicionalVidroAutomativo() + adicionalCambioAutomatico() + adicionalAlarme() +
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
        return (tipoPintura) ? 2500 : 0;
    }

    private double adicionalTetoSolar(){
        return (tetoSolar) ? 4000 : 0;
    }

    private double adicionalKitMultimidia() {
        return (kitMultimidia) ? 1800 : 0;
    }
}
