package br.edu.vianna.utils.datahora;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormataData {
    public static LocalDate formataStringParaData(String data){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, dtf);
    }

    public static String formataDataParaString(LocalDate data){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(dtf);
    }
}
