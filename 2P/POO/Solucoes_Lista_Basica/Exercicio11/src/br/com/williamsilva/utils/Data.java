package br.com.williamsilva.utils;

import java.time.LocalDate;

public class Data {
    private int dia = 0;
    private int mes = 0;
    private int ano = 1900;

    public Data() {
        LocalDate data = LocalDate.now();
        this.dia = data.getDayOfMonth();
        this.mes = data.getMonthValue();
        this.ano = data.getYear();
    }

    public Data(int dia, int mes, int ano) {
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("Mês inválido.");
        }

        if (dia < 1 || dia > verificaDuracaoDoMes(mes, ano)) {
            throw new IllegalArgumentException("O dia informado não é válido para o mês fornecido");
        }

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
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
        if (dia == 31 && mes == 12) {
            defineDiaDoMesFinalAno();
            return;
        }
        if (verificaDuracaoDoMes(mes, ano) == 30) {
            defineDiaDoMes30Dias();
        } else if (verificaDuracaoDoMes(mes, ano) == 31) {
            defineDiaDoMes31Dias();
        } else if (verificaDuracaoDoMes(mes, ano) <= 29) {
            defineDiaDoMesFevereiro();
        }
    }

    // Métodos auxiliares do método avancaData.
    private void defineDiaDoMes30Dias() {
        if (dia >= 1 && dia < 30) {
            acrescenta1Dia();
        } else {
            dia = 1;
            acrescenta1Mes();
        }
    }

    private void defineDiaDoMes31Dias() {
        if (dia >= 1 && dia < 31) {
            acrescenta1Dia();
        } else {
            dia = 1;
            acrescenta1Mes();
        }
    }

    private void defineDiaDoMesFevereiro() {
        if (mes == Meses.FEVEREIRO.getMes()) {
            regrasParaSomarDiasEmFevereiro();
        }
    }

    private void defineDiaDoMesFinalAno() {
        dia = 1;
        acrescenta1Ano();
        mes = 1;
    }

    private void acrescenta1Dia() {
        dia += 1;
    }

    private void acrescenta1Mes() {
        mes += 1;
    }

    private void acrescenta1Ano() {
        ano += 1;
    }

    private void regrasParaSomarDiasEmFevereiro() {
        if (ehAnoBissexto(ano)) {
            if (dia < 29) {
                acrescenta1Dia();
            } else {
                dia = 1;
                acrescenta1Mes();
            }
        } else if (dia < 28) {
            acrescenta1Dia();
        } else {
            dia = 1;
            acrescenta1Mes();
        }
    }

    private int verificaDuracaoDoMes(int mes, int ano) {
        switch (mes) {
            case 2: // Fevereiro
                return (ehAnoBissexto(ano)) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11: // Abril, Junho, Setembro, Novembro
                return 30;
            default: // Todos os outros meses
                return 31;
        }
    }

    private boolean ehAnoBissexto(int ano) {
        return (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0));
    }
}