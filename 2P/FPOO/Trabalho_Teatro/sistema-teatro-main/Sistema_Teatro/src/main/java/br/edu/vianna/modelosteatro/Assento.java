package br.edu.vianna.modelosteatro;

public class Assento {
    private int numero;
    private boolean reservado;

    public Assento() {}

    public Assento(int numero) {
        setNumero(numero);
        this.reservado = false;
    }

    public Assento(int numero, boolean reservado) {
        setNumero(numero);
        setReservado(reservado);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if(numero > 0 && numero <= 100){
            this.numero = numero;
        }
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    public void reservar() {
        if (!reservado) {
            this.reservado = true;
        }
    }
}

