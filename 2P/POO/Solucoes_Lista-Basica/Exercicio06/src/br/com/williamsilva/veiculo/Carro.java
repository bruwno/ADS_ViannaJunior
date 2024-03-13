package br.com.williamsilva.veiculo;

import br.com.williamsilva.opcionaiscarro.Acessorios;
import br.com.williamsilva.opcionaiscarro.TiposDeAcessorios;
import br.com.williamsilva.taxas.Impostos;
import br.com.williamsilva.utils.FormatarInformacaoCarro;

import java.util.ArrayList;
import java.util.List;

public class Carro {
    private String modelo;
    private String marca;
    private Motor motor;
    private Acessorios acessorios;
    private String tipoPintura;
    private boolean importado;
    private double precoBase;
    public Carro() {}

    public Carro(String modelo, String marca, Motor motor, Acessorios acessorios, boolean importado, double precoBase) {
        this.modelo = modelo;
        this.marca = marca;
        this.motor = motor;
        this.acessorios = acessorios;
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
        return (precoBase + taxaDeIPI()) + acrescimoCarroImportado() + acessorios.valorTotalEmAcessorios() - descontoIPIParaMotores1000();
    }

    public String exibeInformacoes() {
        FormatarInformacaoCarro formatInfo = new FormatarInformacaoCarro();
        StringBuilder info = new StringBuilder();
        info.append("Informações do Carro:\n");
        info.append(formatInfo.formatarInformacao("Modelo     ", modelo));
        info.append(formatInfo.formatarInformacao("Marca      ", marca));
        info.append(formatInfo.formatarInformacao("Motorização", String.format("%.1f ", motor.getCilindradas()) + formatInfo.formatarInformacao(motor.getConfiguracaoMotor())));
        info.append(formatInfo.formatarInformacao("Fabricação ", fabricacao()));
        info.append(formatInfo.formatarInformacao("Valor      ", String.format("R$ %.2f", valorFinalCarro())));
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
        return listaDeAcessorios;
    }

    private double acrescimoCarroImportado() {
        return (importado) ? precoBase * 0.30 : 0;
    }

    private double taxaDeIPI() {
        return Impostos.aplicaImpostoIPI(precoBase);
    }

    private double descontoIPIParaMotores1000() {
        return (motor.getCilindradas() == 1.0) ? Impostos.aplicaDescontoIsencaoImpostoIPI(precoBase) : 0;
    }

    private String fabricacao() {
        return (importado) ? "Importado" : "Nacional";
    }
}