package br.edu.vianna.avaliacoes;

import br.edu.vianna.eventos.Evento;
import br.edu.vianna.clientes.Cliente;

import java.time.LocalDateTime;
public class Avaliacao {
    private Evento evento;
    private Cliente cliente;
    private LocalDateTime dataHora;
    private int nota;

    public Avaliacao() {
    }

    public Avaliacao(Evento evento, Cliente cliente, LocalDateTime dataHora, int nota) {
        setEvento(evento);
        setCliente(cliente);
        this.dataHora = LocalDateTime.now();
        setNota(nota);
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        if (evento != null) {
            this.evento = evento;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        if (cliente != null) {
            this.cliente = cliente;
        }
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getNota() {
        return nota;
    }

    public boolean setNota(int nota) {
        if (nota >= 0 && nota <= 5) {
            this.nota = nota;
            return true;
        }
        return false;
    }
    public void avaliar() {
        TotemAvaliacao totem = new TotemAvaliacao();
        setNota(totem.atribuirNota());
    }
}
