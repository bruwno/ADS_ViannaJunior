package br.edu.vianna.eventos;

import br.edu.vianna.clientes.Cliente;
import br.edu.vianna.modelosteatro.Assento;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ingresso {
    private int numero;
    private Assento assento;
    private Cliente cliente;
    private Evento evento;
    private LocalDate dataEmissao;
    private LocalTime horaEmissao;

    public Ingresso() {
    }

    public Ingresso(Assento assento, Cliente cliente, Evento evento) {
        setNumero(evento);
        setAssento(assento);
        setCliente(cliente);
        setEvento(evento);
        setDataEmissao(LocalDate.now());
        setHoraEmissao(LocalTime.now());
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(Evento evento) {
        int numero = evento.getIngressos().size();
        if(numero >= 0){
            this.numero = numero + 1;
        }
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        if(assento != null){
            this.assento = assento;
        }
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        if(cliente != null){
            this.cliente = cliente;
        }
    }

    public Evento getEvento() {
        return this.evento;
    }

    public void setEvento(Evento evento) {
        if(evento != null){
            this.evento = evento;
        }
    }

    public LocalDate getDataEmissao() {
        return this.dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public LocalTime getHoraEmissao() {
        return this.horaEmissao;
    }

    public void setHoraEmissao(LocalTime horaEmissao) {
        this.horaEmissao = horaEmissao;
    }
}