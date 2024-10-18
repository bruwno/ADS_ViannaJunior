package br.edu.vianna.vendas;

import br.edu.vianna.clientes.Cliente;
import br.edu.vianna.eventos.Ingresso;
import br.edu.vianna.funcionarios.Vendedor;
import br.edu.vianna.vendas.pagamentos.Pagamento;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venda {
    private int codVenda;
    private double valorTotal;
    private Cliente cliente;
    private Pagamento pagamento;
    private Vendedor vendedor;
    private LocalDateTime dataHoraVenda;
    private ArrayList<Ingresso> ingressos;

    public Venda() {
        this.ingressos = new ArrayList<>();
    }

    public Venda(Cliente cliente, Pagamento pagamento, Vendedor vendedor) {
        setCliente(cliente);
        setPagamento(pagamento);
        setVendedor(vendedor);
        setDataHoraVenda(LocalDateTime.now());
        this.ingressos = new ArrayList<>();
    }

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        if (codVenda > 0) {
            this.codVenda = codVenda;
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        if (vendedor != null) {
            this.vendedor = vendedor;
        }
    }

    public LocalDateTime getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(LocalDateTime dataHoraVenda) {
        this.dataHoraVenda = dataHoraVenda;
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public void addIngresso(Ingresso ingresso) {
        this.ingressos.add(ingresso);
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public double getValorTotal(){
        calcularValorTotal();
        return valorTotal;
    }
    public void calcularValorTotal() {
        if(this.valorTotal == 0) {
            for (Ingresso i : getIngressos()) {
                this.valorTotal += i.getEvento().getPreco();
            }
        }
    }
}
