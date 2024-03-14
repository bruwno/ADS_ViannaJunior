package br.com.williamsilva.veiculo;

import br.com.williamsilva.opcionaiscarro.Acessorios;
import br.com.williamsilva.opcionaiscarro.TiposDeAcessorios;
import br.com.williamsilva.taxas.Impostos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.williamsilva.auxiliar.Leituras.*;
import static br.com.williamsilva.opcionaiscarro.TiposDePintura.*;

public class PersonalizaCarro {
    private Map<Integer, ModeloCarro> modelosDisponiveis;

    public PersonalizaCarro() {
        modelosDisponiveis = new HashMap<>();
        modelosDisponiveis.put(1, new ModeloCarro("Gol","Volkswagen", PADRAO.getTipoPintura(), new Motor(1.0),false, 40000));
        modelosDisponiveis.put(2, new ModeloCarro("HB20","Hyundai", PADRAO.getTipoPintura(),new Motor(1.6),false,86000.0));
        modelosDisponiveis.put(3, new ModeloCarro("Mustang","Ford", PADRAO.getTipoPintura(),new Motor(5.0),true,500000.0));
        modelosDisponiveis.put(4, new ModeloCarro("Accord","Honda", PADRAO.getTipoPintura(),new Motor(3.5),true,93000.0));
    }

    public Carro selecionarModelo() {
        System.out.println("Escolha dentre os modelos disponíveis abaixo e personalize o seu carro novo!");
        System.out.println("* Valor bruto, sem aplicação de taxas. Conferir o valor final.");
        System.out.println("\nDigite o número [ID] correspondente ao modelo");

        // Exibindo os detalhes de cada modelo.
        System.out.println("[ID]\tMARCA/MODELO \t\tMOTORIZAÇÃO \tIMPORTADO \tPREÇO BASE*");
        //System.out.println("[ID]\tMARCA/MODELO \t\tMOTORIZAÇÃO \tPREÇO BASE*");
        for (Map.Entry<Integer, ModeloCarro> entry : modelosDisponiveis.entrySet()) {
            int idModelo = entry.getKey();
            ModeloCarro valor = entry.getValue();
            //System.out.printf("[%d] \t%s %s \t\t%.1f \t\t\tR$ %.2f%n", idModelo, valor.getMarca(), valor.getModelo(), valor.getPotenciaMotor(), valor.getPrecoBase());
            System.out.printf("[%d] \t%s %s \t\t%.1f \t\t\t%b \t\tR$ %.2f%n", idModelo, valor.getMarca(), valor.getModelo(), valor.getPotenciaMotor(), valor.isImportado(), valor.getPrecoBase());
        }
        // Selecionando o modelo.
        int modeloSelecionado = lerOpcaoDigitada(modelosDisponiveis.size());
        ModeloCarro modeloCarro = modelosDisponiveis.get(modeloSelecionado);
        // Escolhendo os acessórios.
        Acessorios acessorios = escolherAcessorios(modeloCarro.getMarca(), modeloCarro.getModelo());
        // Retornando um carro para o main
        return new Carro(modeloCarro.getModelo(), modeloCarro.getMarca(),
                new Motor(modeloCarro.getPotenciaMotor()), acessorios,
                PADRAO.getTipoPintura(), modeloCarro.isImportado(), modeloCarro.getPrecoBase());
    }

    private Acessorios escolherAcessorios(String marca, String modelo) {
        List<String> listaDeAcessorios = listarAcessoriosParaSelecao();
        System.out.printf("\n|ACESSÓRIOS| Vamos escolher os acessórios do seu novo %s %s%n", marca, modelo);
        System.out.println("(i) Para adicionar um acessório digite [S]im ou [N]ão para ignorar\n");

        List<Boolean> acessoriosSelec = new ArrayList<>();
        for (int i = 0; i < listaDeAcessorios.size(); i++) {
            System.out.printf("Deseja que o seu %s tenha %s?: ", modelo, listaDeAcessorios.get(i));
            acessoriosSelec.add(lerConverterOpcao());
        }

        boolean arCondicionado = acessoriosSelec.get(0);
        boolean vidro = acessoriosSelec.get(1);
        boolean cambioAutomatico = acessoriosSelec.get(2);
        boolean alarme = acessoriosSelec.get(3);
        boolean pinturaCustomizada = acessoriosSelec.get(4);
        boolean tetoSolar = acessoriosSelec.get(5);
        boolean kitMultimida = acessoriosSelec.get(6);

        String tipoPintura = PADRAO.getTipoPintura();
        if (pinturaCustomizada) {
            tipoPintura = escolherTipoPintura();
        }

        if (tipoPintura.equals(PADRAO.getTipoPintura())) {
            pinturaCustomizada = false;
        }

        return new Acessorios(arCondicionado, vidro, cambioAutomatico, alarme, pinturaCustomizada, tipoPintura, tetoSolar, kitMultimida);
    }

    private String escolherTipoPintura() {
        StringBuilder sb = new StringBuilder();
        String pintura;

        System.out.println("\nEscolha o tipo de pintura do seu carro: ");
        sb.append("[1] Pintura Especial (R$ 2.500,00)\n" +
                "[2] Pintura Metálica (R$ 2.500,00)\n" +
                "[3] Pintura Comemorativa (R$ 2.500,00)\n" +
                "[4] Manter a Pintura Padrão (Grátis)\n");
        System.out.println(sb);
        int pinturaEscolhida = lerOpcaoDigitada(4);

        switch (pinturaEscolhida) {
            case 1:
                pintura = ESPECIAL.getTipoPintura();
                break;
            case 2:
                pintura = METALICA.getTipoPintura();
                break;
            case 3:
                pintura = COMEMORATIVA.getTipoPintura();
                break;
            default:
                pintura = PADRAO.getTipoPintura();
        }
        return pintura;
    }

    private List<String> listarAcessoriosParaSelecao() {
        List<TiposDeAcessorios> tiposDeAcessoriosDisponiveis = TiposDeAcessorios.getTiposAcessorios();

        List<String> listaDeAcessoriosEPrecos = new ArrayList<>();
        for (TiposDeAcessorios acessorio : tiposDeAcessoriosDisponiveis) {
            listaDeAcessoriosEPrecos.add(acessorio.getTipoAcessorio() + " (R$ " + acessorio.getPrecoAcessorio() + ")");
        }
        return listaDeAcessoriosEPrecos;
    }
}
