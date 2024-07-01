package br.edu.vianna.sistemaclube.utils.datahora;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FormataHora {
    public static LocalTime formataStringParaHora(String hora){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(hora, dtf);
    }

    public static String formataHoraParaString(LocalTime hora){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        return hora.format(dtf);
    }

    public static String dbFormataHoraParaString(String hora) {
        DateTimeFormatter dtfEntrada = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter dtfSaida = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime horaConvertida = LocalTime.parse(hora, dtfEntrada);
        return horaConvertida.format(dtfSaida);
    }

    public static String formataHoraParaBuscaNaBase(String hora) {
        DateTimeFormatter dtfEntrada = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter dtfSaida = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime horaConvertida = LocalTime.parse(hora, dtfEntrada);
        return horaConvertida.format(dtfSaida);
    }
}