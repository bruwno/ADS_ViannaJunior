package br.edu.vianna.utils.datahora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormataDataHora {
    public static LocalDateTime formataStringParaDataHora(String data){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(data, dtf);
    }

    public static String formataDataHoraParaString(LocalDateTime data){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return data.format(dtf);
    }
}
