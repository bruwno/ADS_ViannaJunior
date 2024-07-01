package br.edu.vianna.sistemaclube.utils.datahora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormataDataHora {
    // Recuperar no formato de exibição.
    public static String formataDataHoraParaExibicaoSemSegundos(String dataHora) {
        if (dataHora != null && !dataHora.isBlank()) {
            DateTimeFormatter dtfEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            DateTimeFormatter dtfSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime dataHoraFormatada = LocalDateTime.parse(dataHora, dtfEntrada);
            return dataHoraFormatada.format(dtfSaida);
        } else {
            return null;
        }
    }

    public static String formataDataHoraParaExibicaoComSegundos(String dataHora) {
        if (dataHora != null && !dataHora.isBlank()) {
            DateTimeFormatter dtfEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            DateTimeFormatter dtfSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime dataHoraFormatada = LocalDateTime.parse(dataHora, dtfEntrada);
            return dataHoraFormatada.format(dtfSaida);
        } else {
            return null;
        }
    }

    // Salvar e recuperar no formato que a base armazena.
    public static String dbFormataDataHoraParaBase(String dataHora) {
        DateTimeFormatter dtfEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter dtfSaida = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dataHoraConvertida = LocalDateTime.parse(dataHora, dtfEntrada);
        return dataHoraConvertida.format(dtfSaida);
    }

    public static LocalDateTime dbFormataStringParaDataHoraBase(String dataHora) {
        DateTimeFormatter dtfEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter dtfSaida = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dataHora, dtfEntrada);
    }

    public static LocalDateTime dbFormataStringParaDataHora(String dataHora) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dataHora, dtf);
    }

    public static String dbFormataDataHoraParaStringBase(LocalDateTime dataHora) {
        DateTimeFormatter dtfSaida = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dataHora.format(dtfSaida);
    }
}
