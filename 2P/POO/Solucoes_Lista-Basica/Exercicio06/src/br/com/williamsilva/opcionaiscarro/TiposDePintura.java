package br.com.williamsilva.opcionaiscarro;

public enum TiposDePintura {
    ESPECIAL("Especial"),
    METALICA("Metálica"),
    COMEMORATIVA("Comemorativa"),
    PADRAO("Padrão");

    private final String tipoPintura;

    TiposDePintura(String tipoPintura) {
        this.tipoPintura = tipoPintura;
    }

    public String getTipoPintura() {
        return tipoPintura;
    }
}
