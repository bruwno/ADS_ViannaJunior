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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.williamsilva.opcionaiscarro.Acessorios;
import br.com.williamsilva.opcionaiscarro.TiposDeAcessorios;
import br.com.williamsilva.veiculo.Carro;
import br.com.williamsilva.veiculo.Motor;

public class Main {
    public static void main(String[] args) {
        System.out.println("Escolha dentre os modelos disponíveis abaixo e personalize o seu carro novo!");
        Carro carro = selecionarModelo();

        System.out.println(carro.exibeInformacoes());

        List<String> listaDeAcessorios = carro.listarAcessorios();
        System.out.println("\tAcessórios:");
        for (var acessorio : listaDeAcessorios) {
            System.out.println("\t" + acessorio);
        }
    }

    private static Carro selecionarModelo() {
        Scanner sc = new Scanner(System.in);
        Motor motor = new Motor();
        String modelo = "", marca = "";
        String tipoPintura = "Padrão";
        boolean ehImportado = false;
        double precoBase = 0;

        StringBuilder sb = new StringBuilder();
        sb.append("Modelos disponíveis:\n" +
                "[1] Volkswagen Gol - 1.0\n" +
                "[2] Hyundai HB20 - 1.6\n" +
                "[3] Ford Mustang - 5.0\n");

        System.out.println("Esolha entre os modelos disponíveis digitando o seu número correspondente: ");
        System.out.println(sb);
        int modeloSelecionado = opcaoDigitada(3);

        switch (modeloSelecionado) {
            case 1:
                modelo = "Gol";
                marca = "Volkswagen";
                tipoPintura = "Padrão";
                ehImportado = false;
                motor.setPotenciaMotor(1.0);
                precoBase = 40000.00;
                break;
            case 2:
                modelo = "HB20";
                marca = "Hyundai";
                tipoPintura = "Padrão";
                ehImportado = false;
                motor.setPotenciaMotor(1.0);
                precoBase = 86000.00;
                break;
            case 3:
                modelo = "Mustang";
                marca = "Ford";
                tipoPintura = "Padrão";
                ehImportado = true;
                motor.setPotenciaMotor(5.0);
                precoBase = 500000.00;
                break;
        }
        Acessorios acessorios = personalizarCarro(marca, modelo);
        return new Carro(modelo, marca, motor, acessorios, tipoPintura, ehImportado, precoBase);
    }

    private static Acessorios personalizarCarro(String marca, String modelo) {
        Acessorios acessorios;
        List<String> listaDeAcessorios = new ArrayList<>();
        List<TiposDeAcessorios> tiposDeAcessoriosDisponiveis = TiposDeAcessorios.getTiposAcessorios();

        for (TiposDeAcessorios acessorio : tiposDeAcessoriosDisponiveis) {
            listaDeAcessorios.add(acessorio.getTipoAcessorio() + " (R$ " + acessorio.getPrecoAcessorio() + ")");
        }

        System.out.printf("Vamos escolher os acessórios do seu novo %s %s%n", marca, modelo);
        System.out.println("(i) Para adicionar um acessório digite [S]im");
        List<Boolean> acessoriosSelec = new ArrayList<>();
        for (int i = 0; i < listaDeAcessorios.size(); i++) {
            System.out.printf("Deseja que o seu carro tenha %s: ", listaDeAcessorios.get(i));
            boolean opcao = converterOpcao();
            acessoriosSelec.add(opcao);
        }

        boolean arCondicionado = acessoriosSelec.get(0);
        boolean vidro = acessoriosSelec.get(1);
        boolean cambioAutomatico = acessoriosSelec.get(2);
        boolean alarme = acessoriosSelec.get(3);
        boolean pinturaEspecial = acessoriosSelec.get(4);
        boolean tetoSolar = acessoriosSelec.get(5);
        boolean kitMultimida = acessoriosSelec.get(6);

        String tipoPintura = "Padrão";
        if (pinturaEspecial) {
            tipoPintura = escolherTipoPintura();
        }

        acessorios = new Acessorios(arCondicionado, vidro, cambioAutomatico, alarme, pinturaEspecial, tipoPintura,
                tetoSolar, kitMultimida);
        return acessorios;
    }

    private static String escolherTipoPintura() {
        StringBuilder sb = new StringBuilder();
        String pintura;

        System.out.println("Selecione o tipo de pintura do seu carro: ");
        sb.append("[1] Pintura Especial (R$ 2.500,00)\n" +
                "[2] Pintura Metálica (R$ 2.500,00)\n" +
                "[3] Pintura Comemorativa (R$ 2.500,00)\n" +
                "[4] Manter a Pintura Padrão (Grátis)\n");
        System.out.println(sb);
        int pinturaEscolhida = opcaoDigitada(4);

        switch (pinturaEscolhida) {
            case 1:
                pintura = "Pintura Especial";
                break;
            case 2:
                pintura = "Pintura Metálica";
                break;
            case 3:
                pintura = "Pintura Comemorativa";
                break;
            default:
                pintura = "Pintura Padrão";
        }
        return pintura;
    }

    // Métodos auxiliares.
    private static int opcaoDigitada(int qtdOpcoes) {
        Scanner sc = new Scanner(System.in);
        int opcaoEscolhida = 0;
        while (opcaoEscolhida <= 0 || opcaoEscolhida > qtdOpcoes) {
            System.out.print("|>| ");
            opcaoEscolhida = sc.nextInt();
        }
        return opcaoEscolhida;
    }

    private static boolean converterOpcao() {
        Scanner sc = new Scanner(System.in);
        return sc.next().toUpperCase().equals("S");
    }
}