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
import br.com.williamsilva.opcionaiscarro.TiposDeAcessorios;
import br.com.williamsilva.auxiliar.Interacoes;
import br.com.williamsilva.veiculo.Carro;
import br.com.williamsilva.veiculo.CatalogoModelos;
import br.com.williamsilva.veiculo.ModeloCarro;
import br.com.williamsilva.veiculo.Motor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static br.com.williamsilva.auxiliar.Leituras.*;
import static br.com.williamsilva.opcionaiscarro.TiposDePintura.*;

public class Main {
    private static CatalogoModelos catModelos = new CatalogoModelos();
    private static Interacoes interacao = new Interacoes();

    public static void main(String[] args) {
        System.out.println("|Sistema| CONCESSIONÁRIA\n");
        System.out.println(interacao.exibeInformacaoDescontoCarro1000());

        Carro carro;
        carro = selecionarModelo();
        System.out.println(carro.exibirResumoDoModeloEscolhido());

        List<String> listaDeAcessorios = carro.listarAcessorios();
        System.out.println("Acessórios:");
        for (var acessorio : listaDeAcessorios) {
            System.out.println("\t" + acessorio);
        }
    }

    public static Carro selecionarModelo() {
        Map<Integer, ModeloCarro> modelosDisponiveis = catModelos.retonarModelosDisponiveis();
        System.out.println(interacao.exibeDialogoInteracaoSelecionarModelo());

        exibeCabecalhoModelosEDatalhes();
        exibeModelosEDetalhes();

        int modeloSelecionado = lerOpcaoDigitada(modelosDisponiveis.size());
        ModeloCarro modeloCarro = modelosDisponiveis.get(modeloSelecionado);
        Acessorios acessorios = escolherAcessorios(modeloCarro.getMarca(), modeloCarro.getModelo());

        return new Carro(modeloCarro.getModelo(), modeloCarro.getMarca(),
                new Motor(modeloCarro.getPotenciaMotor()), acessorios,
                PADRAO.getTipoPintura(), modeloCarro.isImportado(), modeloCarro.getPrecoBase());
    }

    private static Acessorios criarConjuntoDeAcessorios(List<Boolean> acessoriosSelec) {
        boolean arCondicionado = acessoriosSelec.get(0);
        boolean vidro = acessoriosSelec.get(1);
        boolean cambioAutomatico = acessoriosSelec.get(2);
        boolean alarme = acessoriosSelec.get(3);
        boolean pinturaCustomizada = acessoriosSelec.get(4);
        boolean tetoSolar = acessoriosSelec.get(5);
        boolean kitMultimida = acessoriosSelec.get(6);

        String tipoPintura = armazenaTipoPinturaSelecionado(pinturaCustomizada);
        if (tipoPintura.equals(PADRAO.getTipoPintura())) {
            pinturaCustomizada = false;
        }
        return new Acessorios(arCondicionado, vidro, cambioAutomatico, alarme, pinturaCustomizada, tipoPintura,
                tetoSolar, kitMultimida);
    }

    private static Acessorios escolherAcessorios(String marca, String modelo) {
        System.out.println(interacao.exibeDialogoInteracaoEscolherAcessorios(marca, modelo));

        List<String> listaDeAcessorios = listarAcessoriosParaSelecao();
        List<Boolean> acessoriosSelec = armazenaAcessoriosSelecionados(listaDeAcessorios, modelo);

        return criarConjuntoDeAcessorios(acessoriosSelec);
    }

    private static String escolherTipoPintura() {
        System.out.println(interacao.exibeDialogoInteracaoEscolherPintura());
        int opcDigitada = lerOpcaoDigitada(4);
        String pinturaEscolhida;
        switch (opcDigitada) {
            case 1:
                pinturaEscolhida = ESPECIAL.getTipoPintura();
                break;
            case 2:
                pinturaEscolhida = METALICA.getTipoPintura();
                break;
            case 3:
                pinturaEscolhida = COMEMORATIVA.getTipoPintura();
                break;
            default:
                pinturaEscolhida = PADRAO.getTipoPintura();
        }
        return pinturaEscolhida;
    }

    public static void exibeCabecalhoModelosEDatalhes() {
        System.out.println("[ID]\tMARCA/MODELO \t\tMOTORIZAÇÃO \tIMPORTADO \tPREÇO BASE*");
    }

    public static void exibeModelosEDetalhes() {
        for (Map.Entry<Integer, ModeloCarro> entry : catModelos.retonarModelosDisponiveis().entrySet()) {
            int idModelo = entry.getKey();
            ModeloCarro valor = entry.getValue();
            System.out.printf("[%d] \t%s %s \t\t%.1f \t\t\t%b \t\tR$ %.2f%n", idModelo, valor.getMarca(),
                    valor.getModelo(), valor.getPotenciaMotor(), valor.isImportado(), valor.getPrecoBase());
        }
    }

    private static List<Boolean> armazenaAcessoriosSelecionados(List<String> listaDeAcessorios, String modelo) {
        List<Boolean> acessoriosSelec = new ArrayList<>();
        for (int i = 0; i < listaDeAcessorios.size(); i++) {
            System.out.printf("Deseja que o seu %s tenha %s?: ", modelo, listaDeAcessorios.get(i));
            acessoriosSelec.add(lerConverterOpcao());
        }
        return acessoriosSelec;
    }

    private static String armazenaTipoPinturaSelecionado(boolean pinturaCustomizada) {
        String tipoPintura = PADRAO.getTipoPintura();
        if (pinturaCustomizada) {
            tipoPintura = escolherTipoPintura();
        }

        return tipoPintura;
    }

    private static List<String> listarAcessoriosParaSelecao() {
        List<TiposDeAcessorios> tiposDeAcessoriosDisponiveis = TiposDeAcessorios.getTiposAcessorios();

        List<String> listaDeAcessoriosEPrecos = new ArrayList<>();
        for (TiposDeAcessorios acessorio : tiposDeAcessoriosDisponiveis) {
            listaDeAcessoriosEPrecos.add(acessorio.getTipoAcessorio() + " (R$ " + acessorio.getPrecoAcessorio() + ")");
        }
        return listaDeAcessoriosEPrecos;
    }
}