package br.edu.vianna.sistemaclube.utils.datahora;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * O recurso estará ativo se a data for maior ou igual a data atual e a hora (ou minuto) for maior que a hora atual.
 * Retorna TRUE se a data/hora está dentro do limite.
 *
 * @author William Silva
 */
public class VerificaDataHora {
    public static boolean verificarSeDataHoraJaPassou(String data, String hora) {
        DateTimeFormatter formatoDeEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataAtividade = LocalDate.parse(FormataData.formataDataParaExibicao(data), formatoDeEntrada);
        LocalTime horaAtividade = FormataHora.formataStringParaHora(hora);

        return (dataAtividade.isAfter(LocalDate.now())) || (dataAtividade.isEqual(LocalDate.now()) && horaAtividade.isAfter(LocalTime.now()));
    }
}
