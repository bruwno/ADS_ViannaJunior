package br.edu.vianna.utils.datahora;

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

}
