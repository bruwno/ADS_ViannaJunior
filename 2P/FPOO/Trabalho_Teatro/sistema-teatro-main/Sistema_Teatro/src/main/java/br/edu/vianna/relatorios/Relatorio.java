package br.edu.vianna.relatorios;

import br.edu.vianna.autenticar.Autenticacao;
import br.edu.vianna.auxiliares.terminal.AuxiliaImpressao;
import br.edu.vianna.auxiliares.terminal.LeituraDeDados;
import br.edu.vianna.avaliacoes.Avaliacao;
import br.edu.vianna.modelosteatro.Teatro;
import br.edu.vianna.eventos.Evento;
import br.edu.vianna.funcionarios.Funcionario;
import br.edu.vianna.funcionarios.Vendedor;
import br.edu.vianna.utils.datahora.FormataData;
import br.edu.vianna.utils.datahora.FormataDataHora;
import br.edu.vianna.vendas.Venda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

public class Relatorio {
    public static void gerarRelatorioVendas(Teatro teatro) {
        int[] anoMes = lerRetornarAnoMes();
        int ano = anoMes[0], mes = anoMes[1];
        Map<Integer, Venda> vendas = teatro.getVendas();
        double valorTotal = 0.00;

        for (Map.Entry<Integer, Venda> v : vendas.entrySet()) {
            LocalDateTime dataEvento = v.getValue().getDataHoraVenda();
            int anoEvento = dataEvento.getYear();
            int mesEvento = dataEvento.getMonthValue();
            if (ano == anoEvento && mes == mesEvento) {
                valorTotal += v.getValue().getValorTotal();
            }
        }
        imprimirDadosRelatorioDeVendas(mes, ano, valorTotal);
    }

    public static void gerarRelatorioAssentos(Teatro teatro) {
        Map<Integer, Evento> eventos = teatro.getEventos();

        int[] anoMes = lerRetornarAnoMes();
        int ano = anoMes[0], mes = anoMes[1], capacidadeTotal = 0, totalAssentosReservados = 0;
        System.out.print("(>) Digite o código do evento: ");
        int codEvento = Integer.parseInt(LeituraDeDados.lerEVerificarCampo());

        Evento evento = eventos.get(codEvento);
        if (evento != null) {
            LocalDate dataEvento = FormataData.formataStringParaData(evento.getData());
            int anoEvento = dataEvento.getYear();
            int mesEvento = dataEvento.getMonthValue();
            capacidadeTotal = evento.getCapacidade();
            if (ano == anoEvento && mes == mesEvento) {
                for (int i = 0; i < evento.retornarAssentos().length; i++) {
                    for (int j = 0; j < evento.retornarAssentos()[i].length; j++) {
                        if (evento.retornarAssentos()[i][j].isReservado()) {
                            totalAssentosReservados++;
                        }
                    }
                }
            }
        } else {
            System.out.println("(!) Evento não encontrado ou não registrado.");
        }

        imprimirDadosDeOcupacaoDosAssentos(totalAssentosReservados, capacidadeTotal, mes, ano);
    }

    public static void gerarRelatorioAvaliacaoEvento(Teatro teatro) {
        System.out.print("Digite o código do evento: ");
        int opc = Integer.parseInt(LeituraDeDados.lerEVerificarCampo());

        int quantidadeDeAvaliacoes = 0, somaDasNotas = 0;
        for (Map.Entry<Integer, Evento> evt : teatro.getEventos().entrySet()) {
            if (evt.getKey().equals(opc)) {
                for (Avaliacao avaliacao : evt.getValue().getAvaliacoes()) {
                    somaDasNotas += avaliacao.getNota();
                    quantidadeDeAvaliacoes++;
                }
            }
        }
        imprimirDadosAvaliacaoEvento(somaDasNotas, quantidadeDeAvaliacoes);
    }

    public static void gerarRelatorioAvaliacaoAtendimento(Autenticacao auth) {
        Map<String, Funcionario> funcionarios = auth.getFuncionariosCadastrados();
        final String codVend = lerCodVendedor();

        Vendedor vendedor = (Vendedor) funcionarios.get(codVend);
        if (vendedor != null) {
            exibirDadosVendedor(vendedor);
            if (exibirNotasRecebidas()) {
                AuxiliaImpressao.centralizarTexto("NOTAS RECEBIDAS", 50);
                percorrerListaDeAtendimentos(vendedor);
                AuxiliaImpressao.decorarImpressao("-", 50);
            }
        } else {
            System.out.println("\n(!) Vendedor não encontrado. Verifique se o identificador foi digitado corretamente.");
        }
    }

    private static void imprimirDadosRelatorioDeVendas(int mes, int ano, double valorTotal) {
        AuxiliaImpressao.decorarImpressao("-", 70);
        AuxiliaImpressao.centralizarTexto("RELATÓRIO DE ARRECADAÇÃO", 70);
        System.out.printf("(i) Valor total arrecadado pelo teatro no mês %d/%d: R$ %.2f%n", mes, ano, valorTotal);
        AuxiliaImpressao.decorarImpressao("-", 70);
    }

    private static void imprimirDadosDeOcupacaoDosAssentos(double totalAssentosReservados, int capacidadeTotal, int mes, int ano) {
        double percentualDeOcupacao = (totalAssentosReservados / capacidadeTotal) * 100.0;
        AuxiliaImpressao.decorarImpressao("-", 75);
        AuxiliaImpressao.centralizarTexto("OCUPAÇÃO DOS ASSENTOS", 75);
        System.out.printf("(i) Percentual de ocupação dos eventos, ocorridos no período %d/%d%n", mes, ano);
        System.out.printf("(=) No evento selecionado %.1f%% dos assentos disponibilizados foram ocupados.%n", percentualDeOcupacao);
        AuxiliaImpressao.decorarImpressao("-", 75);
    }

    private static void imprimirDadosAvaliacaoEvento(double somaDasNotas, int quantidadeDeAvaliacoes) {
        double media = somaDasNotas / quantidadeDeAvaliacoes;
        AuxiliaImpressao.decorarImpressao("-", 50);
        AuxiliaImpressao.centralizarTexto("MÉDIA DE AVALIAÇÕES", 50);
        System.out.printf("(i) A média de avaliações deste evento é: %.1f%n", media);
        AuxiliaImpressao.decorarImpressao("-", 50);
        System.out.println();
    }

    private static String lerCodVendedor() {
        AuxiliaImpressao.centralizarTexto("DESEMPENHO DOS VENDEDORES", 50);
        System.out.print("(>) Digite o identificador do vendedor (email cadastrado): ");
        return LeituraDeDados.lerEVerificarCampo();
    }

    private static void percorrerListaDeAtendimentos(Vendedor vend) {
        for (Avaliacao avaliacao : vend.getAvaliacoes()) {
            System.out.printf("CÓD. EVENTO: %d | AVALIAÇÃO: %d | DATA HORA: %s%n",
                    avaliacao.getEvento().getCodEvento(), avaliacao.getNota(), FormataDataHora.formataDataHoraParaString(avaliacao.getDataHora()));
        }
    }

    private static void exibirDadosVendedor(Vendedor vend) {
        AuxiliaImpressao.centralizarTexto("DADOS DO VENDEDOR", 50);
        System.out.printf("%nNOME: %s %nDATA DE REGISTRO: %s%n",
                vend.getNome(), vend.getDataRegistro());
        AuxiliaImpressao.decorarImpressao("-", 50);
        AuxiliaImpressao.centralizarTexto("AVALIAÇÃO MÉDIA DO VENDEDOR", 50);
        System.out.printf("(i) A nota média de avaliação deste vendedor é: %.1f%n", vend.getNotaDeAtendimento());
        AuxiliaImpressao.decorarImpressao("-", 50);
    }

    private static boolean exibirNotasRecebidas() {
        System.out.print("(?) Exibir as notas recebidas? (S)im | (N)ão: ");
        return (LeituraDeDados.lerEVerificarCampo().equalsIgnoreCase("S"));
    }

    private static int[] lerRetornarAnoMes() {
        int[] anoMes = new int[2];
        System.out.print("Digite o ano (AAAA): ");
        anoMes[0] = Integer.parseInt(LeituraDeDados.lerEVerificarCampo());
        System.out.print("Digite o mês (MM)  : ");
        anoMes[1] = Integer.parseInt(LeituraDeDados.lerEVerificarCampo());
        return anoMes;
    }
}