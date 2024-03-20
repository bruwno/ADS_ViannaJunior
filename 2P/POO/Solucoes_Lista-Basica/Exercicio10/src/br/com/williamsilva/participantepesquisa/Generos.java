package br.com.williamsilva.participantepesquisa;

public enum Generos {
    MASCULINO('M'),
    FEMININO('F');

    private final Character genero;

    Generos(Character genero) {
        this.genero = genero;
    }

    public Character getGenero() {
        return genero;
    }
}
