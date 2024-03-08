package br.com.williamsilva.utils;

import java.time.LocalDate;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (ehAnoBissexto()) {
            if (dia > 0 && dia <= 29) {
                this.dia = dia;
            }
        } else if (dia > 0 && dia <= 31) {
            this.dia = dia;
        }

        if (mes > 0 && mes <= 12) {
            this.mes = mes;
        }
        if (ano > 0) {
            this.ano = ano;
        }
    }

    public Data() {
        LocalDate data = LocalDate.now();
        this.dia = data.getDayOfMonth();
        this.mes = data.getMonthValue();
        this.ano = data.getYear();
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia >= 1 && dia <= 31) {
            this.dia = dia;
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes >= 1 && mes <= 12) {
            this.mes = mes;
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", dia, mes, ano);
    }

    public void avancaData() {
        if (mes == Meses.FEVEREIRO.getMes()) {
            defineDuracaoFevereiro();
        } else {
            ehUltimoDiaDoMes();
        }
    }

    private void ehUltimoDiaDoMes() {
        if (dia < 31 && mes <= 12) {
            dia += 1;
        } else {
            ehUltimoDiaDoAno();
        }
    }

    private void ehUltimoDiaDoAno() {
        if (dia == 31 && mes == 12) {
            dia = 1;
            ano += 1;
            mes = 1;
        }
    }

    private void defineDuracaoFevereiro() {
        if (ehAnoBissexto()) {
            if (dia < 29) {
                dia += 1;
            }
        }
    }

    private boolean ehAnoBissexto() {
        return ano % 4 == 0;
    }
}
