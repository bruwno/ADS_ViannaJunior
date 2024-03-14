package br.com.williamsilva.veiculo;

import br.com.williamsilva.opcionaiscarro.Acessorios;
import br.com.williamsilva.opcionaiscarro.TiposDeAcessorios;
import br.com.williamsilva.taxas.Impostos;
import br.com.williamsilva.utils.FormatarInformacaoCarro;

import java.util.ArrayList;
import java.util.List;

public class Carro {
    protected String modelo;
    protected String marca;
    protected Motor motor;
    private Acessorios acessorios;
    protected String tipoPintura;
    protected boolean importado;
    protected double precoBase;

    public Carro() {}

    public Carro(String modelo, String marca, Motor motor, Acessorios acessorios, String tipoPintura, boolean importado, double precoBase) {
        this.modelo = modelo;
        this.marca = marca;
        this.motor = motor;
        this.acessorios = acessorios;
        this.tipoPintura = tipoPintura;
        this.importado = importado;
        this.precoBase = precoBase;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (!modelo.isBlank()) {
            this.modelo = modelo;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (!marca.isBlank()) {
            this.marca = marca;
        }
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Acessorios getAcessorios() {
        return acessorios;
    }

    public String getTipoPintura() {
        return tipoPintura;
    }

    public void setTipoPintura(String tipoPintura) {
        if (!tipoPintura.isEmpty()) {
            this.tipoPintura = tipoPintura;
        }
    }

    public void setAcessorios(Acessorios acessorios) {
        this.acessorios = acessorios;
    }

    public boolean isImportado() {
        return importado;
    }

    public void setImportado(boolean importado) {
        this.importado = importado;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        if (precoBase > 0) {
            this.precoBase = precoBase;
        }
    }

    public double valorFinalCarro() {
        return (precoBase + impostoDeIPI()) + impostoDeImportacao() + acessorios.valorTotalEmAcessorios() - descontoIPIParaMotores1000();
    }

    public String exibirResumoDoModeloEscolhido() {
        FormatarInformacaoCarro formatInfo = new FormatarInformacaoCarro();
        StringBuilder info = new StringBuilder();
        info.append("Informações do Carro:\n");
        info.append(formatInfo.formatarInformacao("Modelo     ", modelo));
        info.append(formatInfo.formatarInformacao("Marca      ", marca));
        info.append(formatInfo.formatarInformacao("Motorização", String.format("%.1f ", motor.getPotenciaMotor())));
        info.append(formatInfo.formatarInformacao("Fabricação ", fabricacao()));
        info.append(formatInfo.formatarInformacao("Pintura    ", acessorios.getTipoPintura()));
        info.append(formatInfo.formatarInformacao("Valor final", String.format("R$ %.2f", valorFinalCarro())));
        return info.toString();
    }

    public List<String> listarAcessorios() {
        List<String> listaDeAcessorios = new ArrayList<>();
        List<TiposDeAcessorios> tiposDeAcessoriosDisponiveis = TiposDeAcessorios.getTiposAcessorios();

        for (TiposDeAcessorios acessorio : tiposDeAcessoriosDisponiveis) {
            if (acessorios.temAcessorio(acessorio)) {
                listaDeAcessorios.add(acessorio.getTipoAcessorio());
            }
        }
        if (listaDeAcessorios.isEmpty()) {
            listaDeAcessorios.add("Nenhum acessório selecionado.");
        }

        return listaDeAcessorios;
    }

    private double impostoDeImportacao() {
        return (importado) ? Impostos.aplicaImpostoDeImportacao(precoBase) : 0;
    }

    private double impostoDeIPI() {
        return Impostos.aplicaImpostoIPI(precoBase);
    }

    private double descontoIPIParaMotores1000() {
        return (motor.getPotenciaMotor() == 1.0) ? Impostos.aplicaDescontoImpostoIPI(precoBase) : 0;
    }

    private String fabricacao() {
        return (importado) ? "Importado" : "Nacional";
    }
}