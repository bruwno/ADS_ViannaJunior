package br.edu.vianna.sistemaclube.utils.datahora;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormataData {
    public static String formataDataParaExibicao(String data) {
        if (data != null && !data.isBlank()) {
            DateTimeFormatter dtfEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter dtfSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataFormatada = LocalDate.parse(data, dtfEntrada);
            return dataFormatada.format(dtfSaida);
        } else {
            return null;
        }
    }

    public static LocalDate formataStringParaData(String data) {
        DateTimeFormatter dtfEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLocal = LocalDate.parse(data, dtfEntrada);
        String dataFormatada = dataLocal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return LocalDate.parse(dataFormatada, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public static String formataDataParaString(LocalDate data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return data.format(dtf);
    }

    public static String formataDataParaBuscaNaBase(String data) {
        DateTimeFormatter dtfEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataLocal = LocalDate.parse(data, dtfEntrada);
        String dataFormatada = dataLocal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return String.format(dataFormatada, dtfEntrada);
    }

    public static String dbFormataDataParaStringBase(LocalDate data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return data.format(dtf);
    }

    public static String dbFormataStringParaDataBase(String data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataLocal = LocalDate.parse(data, dtf);
        return dataLocal.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
