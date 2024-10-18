package br.edu.vianna.auxiliares.terminal;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LeituraDeDados {
    public static String lerEVerificarCampo() {
        Scanner sc = new Scanner(System.in);
        String campo = sc.nextLine().trim();

        while (campo.isEmpty()) {
            System.out.print("(!) Este campo deve ser preenchido!\nDigite novamente: ");
            campo = sc.nextLine().trim();
        }

        return campo;
    }

    public static String lerEVerificarFormatoData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataDigitada = null;

        while (dataDigitada == null) {
            String data = lerEVerificarCampo();
                try {
                    LocalDate.parse(data, dtf);
                    dataDigitada = data;
                } catch (
                        Exception ex) {
                    System.out.print("Data inválida!\nPor favor, digite a data no formato correto! (DD/MM/AAAA): ");
                }
        }

        return dataDigitada;
    }

    public static String lerEVerificarFormatoHora() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        String horaDigitada = null;

        while (horaDigitada == null) {
            String hora = lerEVerificarCampo();

            try {
                LocalTime.parse(hora, dtf);
                horaDigitada = hora;
            } catch (
                    Exception ex) {
                System.out.print("Horário inválido!\nPor favor, digite o horário no formato correto! (HH:mm): ");
            }
        }

        return horaDigitada;
    }

    public static int lerRetornarOpcaoDigitada(int numeroOpcoes) {
        int opc;
        boolean entradaValida;
        do {
            entradaValida = true;
            try {
                opc = Integer.parseInt(lerEVerificarCampo());
                if (opc < 0 || opc > numeroOpcoes) {
                    System.out.print("(!) Opção inválida, digite novamente: ");
                    entradaValida = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("(!) Entrada inválida. Por favor, digite um número que corresponda às opções exibidas.");
                System.out.print("> ");
                entradaValida = false;
                opc = -1;
            }
        } while (!entradaValida);
        return opc;
    }
}