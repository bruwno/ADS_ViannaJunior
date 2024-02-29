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


public class Main {
    public static void main(String[] args) {
        Acessorios acessorios = new Acessorios(true, true, true, true, true, true, true);
        Motor motor = new Motor(5.0, "V8");
        Carro carro = new Carro("Mustang", "Ford", motor, acessorios, true, 500000);

        System.out.println(carro.exibeInformacoes());

        List<String> listaDeAcessorios = carro.listarAcessorios();
        System.out.println("\tAcessórios:");
        for (var acessorio : listaDeAcessorios) {
            System.out.println("\t" + acessorio);
        }
    }
}