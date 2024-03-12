/*
 * Autor: William Silva
 * Data : 28/02/2024
 *
 * Excercício 06) Crie um programa que permita ao consumidor customizar a escolha de um carro
 * novo com seus opcionais, câmbio automático, vidro automático, alarme, teto solar, kit
 * multimídia, potência do motor, dentre outros opcionais. Ao final mostre os detalhes do
 * carro escolhido e o custo do carro conforme o cálculo a seguir:
 * O preço do carro depende do modelo, acrescido IPI, 20% do custo final do veículo, se for
 * importante ainda é taxado em 30% sobre o preço. Veículos com motores 1.0 o IPI é
 * reduzido a 10%.
 * Cada acessório opcional acrescenta seu custo ao veículo, segue a tabela de preço
 * abaixo:
 * Ar -> R$ 3.000,00, câmbio automático -> R$ 5.000,00, alarme -> R$ 800,00, pintura
 * especial, metálica ou comemorativa -> R$ 2.500,00, teto solar -> R$ 4.000,00 e kit
 * multimidia -> R$ 1.800,00
 */

import br.com.williamsilva.opcionaiscarro.Acessorios;
import br.com.williamsilva.veiculo.Carro;
import br.com.williamsilva.veiculo.Motor;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Acessorios acessorios = personalizarCarro();
        Motor motor = new Motor(5.0, "V8");
        Carro carro = new Carro("Mustang", "Ford", motor, acessorios, true, 500000);

        // Leitura do modelo.
        //Carro modeloEscolhido = new Carro();
        //modeloEscolhido = selecionarModelo();

        System.out.println(carro.exibeInformacoes());

        List<String> listaDeAcessorios = carro.listarAcessorios();
        System.out.println("\tAcessórios:");
        for (var acessorio : listaDeAcessorios) {
            System.out.println("\t" + acessorio);
        }
    }

    private static Carro selecionarModelo() {
        Carro carro = new Carro();
        Motor motor1000, motor2000, motor3000;

        StringBuilder sb = new StringBuilder();
        sb.append("Modelos:" +
                "1 - VW Gol" +
                "2 - Hyundai HB20" +
                "3 - Ford Mustang" +
                "4 - Fiat Strada");

        System.out.println("Esolha entre os modelos disponíveis: ");

        personalizarCarro();

        return carro;
    }

    private static Acessorios personalizarCarro() {
        Acessorios acessorios = new Acessorios();
        System.out.println("Agora vamos escolher os acessórios do seu novo carro:");
        System.out.println("(i) Para adicionar um acessório digite S");
        //
        System.out.print("Deseja que o seu carro tenha Ar Condicionado?: ");
        acessorios.setArCondicionado(converterOpcao());
        System.out.print("Deseja que o seu carro tenha Vidro Automático?: ");
        acessorios.setVidroAutomatico(converterOpcao());
        System.out.print("Deseja que o seu carro tenha Câmbio Automático?: ");
        acessorios.setCambioAutomatico(converterOpcao());
        System.out.print("Deseja que o seu carro tenha Alarme?: ");
        acessorios.setAlarme(converterOpcao());
        System.out.print("Deseja que o seu carro tenha Pitura Especial?: ");
        acessorios.setTipoDePintura(converterOpcao());
        System.out.print("Deseja que o seu carro tenha Teto Solar?: ");
        acessorios.setTetoSolar(converterOpcao());
        System.out.print("Deseja que o seu carro tenha Kit Multimídia?: ");
        acessorios.setKitMultimidia(converterOpcao());

        return acessorios;
    }

    private static boolean converterOpcao(){
        Scanner sc = new Scanner(System.in);
        if (sc.next().toUpperCase().equals("S")) {
            return true;
        }
        return false;
    }

}