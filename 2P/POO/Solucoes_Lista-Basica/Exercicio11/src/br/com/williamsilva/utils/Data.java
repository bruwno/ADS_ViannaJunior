package br.com.williamsilva.utils;

import java.time.LocalDate;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        LocalDate dataAtual = LocalDate.now();
        this.dia = dataAtual.getDayOfMonth();
        this.mes = dataAtual.getMonthValue();
        this.ano = dataAtual.getYear();
    }

    public Data(int dia, int mes, int ano) {
        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
        validaData();
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
        validaData();
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        String qtdDigitos = String.valueOf(ano);
        if (qtdDigitos.length() > 4) {
            LocalDate dataAtual = LocalDate.now();
            this.ano = dataAtual.getYear();
        } else {
            this.ano = ano;
            validaData();
        }

    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", this.dia, this.mes, this.ano);
    }

    public void avancaData() {
        if (dia < verificaDuracaoDoMes(mes, ano)) {
            dia++;
        } else {
            dia = 1;
            if (mes < 12) {
                mes++;
            } else {
                mes = 1;
                ano++;
            }
        }
    }

    private void validaData() {
        if (mes < 1 || mes > 12 || dia < 1 || dia > verificaDuracaoDoMes(mes, ano)) {
            throw new IllegalArgumentException("A data informada é inválida!");
        }
    }

    private int verificaDuracaoDoMes(int mes, int ano) {
        switch (mes) {
            case 2:
                return (ehAnoBissexto(ano)) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private boolean ehAnoBissexto(int ano) {
        return (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0));
    }
}