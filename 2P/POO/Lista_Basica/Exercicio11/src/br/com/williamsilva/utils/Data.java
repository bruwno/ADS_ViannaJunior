package br.com.williamsilva.utils;

import java.util.Calendar;
import java.util.Date;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        if (dia > 0) {
            this.dia = dia;
        }
        if (mes > 0) {
            this.mes = mes;
        }
        if (ano > 0) {
            this.ano = ano;
        }
    }

    public Data()
    {
        Calendar calendario = Calendar.getInstance();
        this.dia = calendario.

    }
}
