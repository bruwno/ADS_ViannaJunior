package br.edu.vianna.modelosteatro;

import br.edu.vianna.clientes.Endereco;
import br.edu.vianna.clientes.Cliente;
import br.edu.vianna.eventos.Evento;
import br.edu.vianna.funcionarios.Administrador;
import br.edu.vianna.vendas.Venda;

import java.util.HashMap;
import java.util.Map;

public class Teatro {
    private String nome;
    private Endereco endereco;
    private Administrador gerente;
    private int capacidade;
    private Map<Integer, Evento> eventos;
    private Map<String, Cliente> clientes;
    private Map<Integer, Venda> vendas;

    public Teatro() {
        this.eventos = new HashMap<>();
        this.clientes = new HashMap<>();
        this.vendas = new HashMap<>();
    }

    public Teatro(String nome, Endereco endereco, Administrador gerente) {
        setNome(nome);
        setEndereco(endereco);
        setGerente(gerente);
        this.eventos = new HashMap<>();
        this.clientes = new HashMap<>();
        this.vendas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        if (endereco != null) {
            this.endereco = endereco;
        }
    }

    public Administrador getGerente() {
        return gerente;
    }

    public void setGerente(Administrador gerente) {
        if (gerente != null) {
            this.gerente = gerente;
        }
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade > 0 && capacidade < 100) {
            this.capacidade = capacidade;
        }
    }

    public Map<Integer, Evento> getEventos() {
        return eventos;
    }

    public boolean addEvento(Evento evento) {
        int id = eventos.size() + 1;
        if (evento != null && !eventos.containsKey(id)) {
            this.eventos.put(id, evento);
            evento.setCodEvento(id);
            return true;
        }
        return false;
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public boolean addCliente(Cliente cliente) {
        if (cliente != null && !clientes.containsKey(cliente.getCpf())) {
            this.clientes.put(cliente.getCpf(), cliente);
            return true;
        }
        return false;
    }

    public Map<Integer, Venda> getVendas() {
        return vendas;
    }

    public void addVenda(Venda venda) {
        int codVenda = vendas.size() + 1;
        if (venda != null) {
            this.vendas.put(codVenda, venda);
        }
    }
}
