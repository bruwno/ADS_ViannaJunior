package br.edu.vianna;

import br.edu.vianna.autenticar.Autenticacao;
import br.edu.vianna.auxiliares.terminal.Grade;
import br.edu.vianna.auxiliares.terminal.LeituraDeDados;
import br.edu.vianna.auxiliares.terminal.AuxiliaImpressao;
import br.edu.vianna.avaliacoes.Avaliacao;
import br.edu.vianna.clientes.Cliente;
import br.edu.vianna.clientes.Endereco;
import br.edu.vianna.eventos.Ingresso;
import br.edu.vianna.modelosteatro.Teatro;
import br.edu.vianna.modelosteatro.Assento;
import br.edu.vianna.eventos.Evento;
import br.edu.vianna.funcionarios.Administrador;
import br.edu.vianna.funcionarios.Funcionario;
import br.edu.vianna.funcionarios.Vendedor;
import br.edu.vianna.relatorios.Relatorio;
import br.edu.vianna.utils.datahora.FormataData;
import br.edu.vianna.utils.datahora.FormataHora;
import br.edu.vianna.vendas.pagamentos.ETipoPagamento;
import br.edu.vianna.vendas.pagamentos.Pagamento;
import br.edu.vianna.vendas.Venda;
import br.edu.vianna.basededados.Bases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static br.edu.vianna.utils.datahora.FormataData.*;
import static br.edu.vianna.utils.datahora.FormataHora.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Autenticacao auth = new Autenticacao();

        Map<String, Funcionario> baseFunc = Bases.baseDeFuncionarios(auth);
        Teatro teatro = definirDadosTeatro(baseFunc);
        Bases.baseDeEventos(teatro);
        Bases.baseDeClientes(teatro);

        exibeDadosTeatro(teatro);

        Funcionario func = exibeTelaAutenticacao(auth, teatro);
        exibirMenu(func, teatro, auth);

        desconectarUsuario(auth, teatro);
    }

    public static Teatro definirDadosTeatro(Map<String, Funcionario> baseFunc) {
        Teatro teatro = new Teatro();
        Administrador gerente = (Administrador) baseFunc.get("raphael@mail.com");
        teatro.setNome("Teatro Municipal de Juiz de Fora");
        teatro.setGerente(gerente);
        teatro.setCapacidade(100);
        Endereco endTeatro = new Endereco("Praça João Pessoa", "S/N", "", "Centro", "Juiz de Fora", "36010-150", "MG");
        teatro.setEndereco(endTeatro);

        return teatro;
    }

    public static void exibeDadosTeatro(Teatro teatro) {
        AuxiliaImpressao.decorarImpressao("*", 70);
        AuxiliaImpressao.centralizarTexto(teatro.getNome(), 70);
        AuxiliaImpressao.decorarImpressao("*", 70);
        System.out.printf("GERENTE: %s%n", teatro.getGerente().getNome());
    }

    // Autenticação.
    public static Funcionario exibeTelaAutenticacao(Autenticacao auth, Teatro teatro) {
        System.out.printf("\nBem vindo ao Sistema do %s!%n%nPara prosseguir realize o login%n", teatro.getNome());
        AuxiliaImpressao.centralizarTexto("- --- LOGIN --- -", 24);
        Funcionario func;
        while (true) {
            System.out.print("(>) Digite o seu email: ");
            String email = LeituraDeDados.lerEVerificarCampo();
            System.out.print("(>) Digite a sua senha: ");
            String senha = LeituraDeDados.lerEVerificarCampo();
            func = auth.autenticar(email, senha);
            if (func != null) {
                break;
            } else {
                System.out.println("(!) Dados inválidos, tente novamente");
            }
        }
        return func;
    }

    private static void desconectarUsuario(Autenticacao auth, Teatro teatro) {
        Funcionario func;
        while (true) {
            System.out.print("Deseja voltar a tela de login ou fechar o sistema? (L)ogin ou (F)echar: ");
            if (scanner.next().equalsIgnoreCase("L")) {
                func = exibeTelaAutenticacao(auth, teatro);
                exibirMenu(func, teatro, auth);
            } else {
                System.out.println("(i) Fechando o sistema...");
                System.exit(-1);
            }
        }
    }

    // Menus.
    private static void exibirMenu(Funcionario f, Teatro teatro, Autenticacao auth) {
        if (f instanceof Administrador) {
            menuAdministrador(teatro, auth, f);
        } else if (f instanceof Vendedor) {
            menuVendedor(teatro, f);
        }
    }

    public static void menuAdministrador(Teatro teatro, Autenticacao auth, Funcionario gerente) {
        while (true) {
            AuxiliaImpressao.centralizarTexto("MENU", 22);
            System.out.println("1 - Consultar Eventos Disponíveis\n2 - Consultar todos os Eventos \n3 - Cadastrar Eventos\n4 - Cadastrar Funcionário\n5 - Gerar Relatórios\n6 - Sair\n");
            System.out.print("(>) DIGITE A OPÇÃO DESEJADA: ");
            int opcao = LeituraDeDados.lerRetornarOpcaoDigitada(6);
            switch (opcao) {
                case 1:
                    exibirEventos(teatro, gerente);
                    break;
                case 2:
                    exibirTodosOsEventos(teatro);
                    break;
                case 3:
                    cadastrarEvento(teatro);
                    break;
                case 4:
                    cadastrarFuncionario(auth);
                    break;
                case 5:
                    menuRelatorios(teatro, auth);
                    break;
                case 6:
                    return;
            }
        }
    }

    public static void menuVendedor(Teatro teatro, Funcionario vendedor) {
        while (true) {
            AuxiliaImpressao.centralizarTexto("MENU", 22);
            System.out.println("1 - Cadastrar Cliente \n2 - Vender Ingresso \n3 - Cadastrar Avaliação \n4 - Exibir clientes cadastrados \n5 - Sair\n");
            System.out.print("(>) DIGITE A OPÇÃO DESEJADA: ");
            int opcao = LeituraDeDados.lerRetornarOpcaoDigitada(5);
            switch (opcao) {
                case 1:
                    cadastrarCliente(teatro);
                    break;
                case 2:
                    exibirEventos(teatro, vendedor);
                    break;
                case 3:
                    avaliarEvento(teatro);
                    break;
                case 4:
                    exibirClientesCadastrados(teatro);
                    break;
                case 5:
                    return;

            }
        }
    }

    private static void menuRelatorios(Teatro teatro, Autenticacao auth) {
        System.out.print("1 - Vendas de ingresso \n2 - Ocupação dos Assentos \n3 - Avaliações dos eventos \n4 - Avaliações de atendimento  \n5 - Retornar ao menu \n\n(>) DIGITE A OPÇÃO DESEJADA: ");
        int opc = LeituraDeDados.lerRetornarOpcaoDigitada(5);

        switch (opc) {
            case 1:
                Relatorio.gerarRelatorioVendas(teatro);
                break;
            case 2:
                Relatorio.gerarRelatorioAssentos(teatro);
                break;
            case 3:
                Relatorio.gerarRelatorioAvaliacaoEvento(teatro);
                break;
            case 4:
                Relatorio.gerarRelatorioAvaliacaoAtendimento(auth);
                break;
            case 5:
                break;
        }
    }

    // Cadastros.
    public static void cadastrarFuncionario(Autenticacao auth) {
        Vendedor vendedor = new Vendedor();
        System.out.println("CADASTRO DE VENDEDORES");
        System.out.println("(*)-> Preenchimento obrigatório\n");
        System.out.print("(*) Digite o nome: ");
        vendedor.setNome(LeituraDeDados.lerEVerificarCampo());
        System.out.print("(*) Digite o email: ");
        vendedor.setEmail(LeituraDeDados.lerEVerificarCampo());
        System.out.print("(*) Digite a senha: ");
        vendedor.setSenha(LeituraDeDados.lerEVerificarCampo());
        vendedor.setCodVendedor(auth.getFuncionariosCadastrados().size() + 1);
        if (auth.cadastraFuncionario(vendedor)) {
            System.out.println("\n(i) Funcionário cadastrado com sucesso!\n");

        } else {
            System.out.println("\n(!) Este funcionário já encontra-se cadastrado.\n");
        }
    }

    public static String impedirCadastroEmDataAnterior(String dataDigitada) {
        LocalDate data = formataStringParaData(dataDigitada);

        while (data.isBefore(LocalDate.now())) {
            Scanner sc = new Scanner(System.in);
            System.out.print("(!) A data do evento não pode ser anterior a data atual!\n(>) Digite novamente: ");
            data = formataStringParaData(sc.nextLine());
        }
        return formataDataParaString(data);
    }

    public static void cadastrarCliente(Teatro teatro) {
        Cliente cliente = new Cliente();

        System.out.println("CADASTRO DE CLIENTES");
        System.out.println("(*)-> Preenchimento obrigatório\n");
        System.out.print("(*) Digite o primeiro nome: ");
        cliente.setNome(LeituraDeDados.lerEVerificarCampo());

        System.out.print("(*) Digite o sobrenome: ");
        cliente.setSobrenome(LeituraDeDados.lerEVerificarCampo());

        System.out.print("(*) Digite o CPF (apenas números): ");
        cliente.setCpf(LeituraDeDados.lerEVerificarCampo());

        System.out.print("(*) Digite o email: ");
        cliente.setEmail(LeituraDeDados.lerEVerificarCampo());

        System.out.print("(*) Digite o número de telefone (apenas números): ");
        cliente.setTelefone(LeituraDeDados.lerEVerificarCampo());

        System.out.print("(*) Digite a data de nascimento (DD/MM/AAAA): ");
        cliente.setDataNasc(impedirCadastroComDataFutura(LeituraDeDados.lerEVerificarFormatoData()));

        Endereco endereco = cadastrarEndereco();
        cliente.setEndereco(endereco);

        if (teatro.addCliente(cliente)) {
            System.out.println("\n(i) Cliente cadastrado com sucesso!\n");
        } else {
            System.out.println("\n(!) Já existe um cliente cadastrado com este CPF.\n");
        }
    }

    private static void exibirClientesCadastrados(Teatro teatro) {
        exibirCabecalhoListaClientes();
        for (Map.Entry<String, Cliente> cliente : teatro.getClientes().entrySet()) {
            String cpfCliente = cliente.getKey();
            Cliente cli = cliente.getValue();
            AuxiliaImpressao.decorarImpressao("-", 102);
            System.out.printf("| %-11s | %-20s | %-20s | %-20s | %-15s |\n",
                    cpfCliente, cli.getNome(), cli.getSobrenome(), cli.getEmail(), cli.getTelefone());
            AuxiliaImpressao.decorarImpressao("-", 102);
        }
    }

    public static void exibirCabecalhoListaClientes() {
        AuxiliaImpressao.centralizarTexto("LISTA DE CLIENTES CADASTRADOS\n", 102);
        System.out.printf("| %-11s | %-20s | %-20s | %-20s | %-15s\n",
                "CPF", "NOME", "SOBRENOME", "EMAIL", "TELEFONE");
    }

    public static String impedirCadastroComDataFutura(String dataDigitada) {
        LocalDate data = formataStringParaData(dataDigitada);

        while (data.isAfter(LocalDate.now())) {
            Scanner sc = new Scanner(System.in);
            System.out.print("(!) A data não pode ser posterior a data atual!\n(>) Digite novamente: ");
            data = formataStringParaData(sc.nextLine());
        }
        return formataDataParaString(data);
    }

    public static Endereco cadastrarEndereco() {
        Endereco endereco = new Endereco();

        System.out.println("\nINFORME OS DADOS DO ENDEREÇO DO CLIENTE");
        System.out.println("(*)-> Preenchimento obrigatório\n");
        System.out.print("(*) Digite o nome da Rua: ");
        endereco.setRua(LeituraDeDados.lerEVerificarCampo());

        System.out.println("(i) Caso seja SEM NÚMERO digite S/N");
        System.out.print("(*) Digite o número da residência: ");
        endereco.setNumero(LeituraDeDados.lerEVerificarCampo());

        System.out.print("(>) Digite o complemento (se houver): ");
        endereco.setComplemento(scanner.nextLine());

        System.out.print("(*) Digite o CEP (apenas números): ");
        endereco.setCep(LeituraDeDados.lerEVerificarCampo());

        System.out.print("(*) Digite o bairro: ");
        endereco.setBairro(LeituraDeDados.lerEVerificarCampo());

        System.out.print("(*) Digite a cidade: ");
        endereco.setCidade(LeituraDeDados.lerEVerificarCampo());

        System.out.print("(*) Digite a sigla da UF: ");
        endereco.setUf(LeituraDeDados.lerEVerificarCampo().toUpperCase());

        return endereco;
    }

    public static void cadastrarEvento(Teatro teatro) {
        Evento evento = new Evento();

        System.out.println("CADASTRO DE EVENTOS");
        System.out.println("(*)-> preenchimento obrigatório\n");
        System.out.print("(*) Digite o nome do evento (máximo 20 caracteres): ");
        evento.setNome(LeituraDeDados.lerEVerificarCampo());

        System.out.print("(*) Digite a descrição do evento (máx. 20 caracteres): ");
        evento.setDescricao(LeituraDeDados.lerEVerificarCampo());

        System.out.print("(*) Digite a data do evento (DD/MM/AAAA): ");
        evento.setData(impedirCadastroEmDataAnterior(LeituraDeDados.lerEVerificarFormatoData()));

        System.out.print("(*) Digite o horário (HH:mm): ");
        evento.setHorario(verificarCadastroComHorarioAnterior(evento.getData(), impedirCadastroDeEventoNoMesmoHorario(evento.getData(), teatro)));

        System.out.print("(*) Digite o preço do ingresso (R$ 0,00): ");
        evento.setPreco(Double.parseDouble(LeituraDeDados.lerEVerificarCampo().replace(',', '.')));

        System.out.print("(*) Defina o público para o evento (máximo 100 lugares): ");
        evento.setCapacidade(Integer.parseInt(LeituraDeDados.lerEVerificarCampo()));

        if (teatro.addEvento(evento)) {
            System.out.println("\n(i) Evento cadastrado com sucesso!\n");
        } else {
            System.out.println("\n(!) Já existe um evento cadastrado com este código!\n(i)Os códigos não pode ser repetidos.\n");
        }
    }

    public static String verificarCadastroComHorarioAnterior(String data, String hora) {
        LocalDate dataEvento = FormataData.formataStringParaData(data);
        while (true) {
           LocalTime horaEvento = FormataHora.formataStringParaHora(hora);
           if (horaEvento.isAfter(LocalTime.now()) && dataEvento.isEqual(LocalDate.now()) || dataEvento.isAfter(LocalDate.now())) {
                break;
           } else {
               System.out.println("(!) A hora não pode ser anterior ao horário atual.");
               hora = LeituraDeDados.lerEVerificarFormatoHora();
           }
        }
        return hora;
    }

   public static String impedirCadastroDeEventoNoMesmoHorario(String data, Teatro teatro) {
        Map<Integer, Evento> eventos = teatro.getEventos();

        String hora = LeituraDeDados.lerEVerificarFormatoHora();

        for (Map.Entry<Integer, Evento> evento : eventos.entrySet()) {
            LocalDate dataEvento = formataStringParaData(evento.getValue().getData());
            LocalTime horaEvento = formataStringParaHora(evento.getValue().getHorario());

            while (dataEvento.isEqual(formataStringParaData(data)) && horaEvento.equals(formataStringParaHora(hora))) {
                System.out.println("(!) Já existe um evento agendado para esta data neste mesmo horário.\n(>) Digite o horário novamente: ");
                hora = LeituraDeDados.lerEVerificarFormatoHora();
            }
        }

        return hora;
    }

    // Eventos.
    public static void exibirEventos(Teatro teatro, Funcionario func) {
        Map<Integer, Evento> eventos = teatro.getEventos();

        AuxiliaImpressao.centralizarTexto("LISTA DE EVENTOS DISPONÍVEIS\n", 122);
        imprimirCabecalhoDaTabelaDeEventos();
        for (Map.Entry<Integer, Evento> evento : eventos.entrySet()) {
            Evento infoEvento = evento.getValue();
            if (exibirApenasEventosDisponiveis(infoEvento)) {
                imprimirEvento(evento.getKey(), infoEvento);
            }
        }
        if (func instanceof Vendedor) {
            selecionarEvento(teatro, func);
        }
    }

    private static void exibirTodosOsEventos(Teatro teatro) {
        Map<Integer, Evento> eventos = teatro.getEventos();

        AuxiliaImpressao.centralizarTexto("LISTA DE TODOS OS EVENTOS REGISTRADOS\n", 122);
        for (Map.Entry<Integer, Evento> evento : eventos.entrySet()) {
            Evento infoEvento = evento.getValue();
            imprimirEvento(evento.getKey(), infoEvento);
        }
    }

    public static boolean exibirApenasEventosDisponiveis(Evento evento) {
        LocalTime horaEvento = FormataHora.formataStringParaHora(evento.getHorario());
        LocalDate dataEvento = FormataData.formataStringParaData(evento.getData());
        return horaEvento.isAfter(LocalTime.now()) && dataEvento.isEqual(LocalDate.now()) || dataEvento.isAfter(LocalDate.now());
    }

    public static void imprimirCabecalhoDaTabelaDeEventos() {
        System.out.printf("| %-6s | %-25s | %-25s | %-12s | %-10s | %-12s | %-10s |\n",
                "CÓDIGO", "NOME", "DESCRIÇÃO", "DATA", "HORÁRIO", "PREÇO", "CAPACIDADE");
    }

    public static void imprimirEvento(int codEvento, Evento evento) {
        AuxiliaImpressao.decorarImpressao("-", 122);
        System.out.printf("| %-6d | %-25s | %-25s | %-12s | %-10s | %-12.2f | %03d / %03d  |\n",
                codEvento, evento.getNome(), evento.getDescricao(), evento.getData(), evento.getHorario(), evento.getPreco(), evento.contarAssentosLivres(), evento.getCapacidade());
        AuxiliaImpressao.decorarImpressao("-", 122);
    }

    public static void selecionarEvento(Teatro teatro, Funcionario vendedor) {
        Map<Integer, Evento> eventos = teatro.getEventos();
        if (eventos.isEmpty()) {
            System.out.println("(!) Nenhum evento cadastrado.\n");
            return;
        }

        int codigoEvento = lerCodigoEvento(teatro);
        if (codigoEvento == 0) {
            return;
        }

        Evento eventoSelecionado = retornarEventoSelecionado(teatro, codigoEvento);
        if (eventoSelecionado != null && eventoSelecionado.contarAssentosLivres() > 0) {
            verificarDisponibilidadeEvento(eventoSelecionado, teatro, vendedor);
        } else {
            System.out.println("(!) Evento com a capacidade esgotada ou não encontrado.\n");
        }
    }

    public static int lerCodigoEvento(Teatro teatro) {
        System.out.print("\n(i) Para retornar ao MENU digite [0]\n(>) Para realizar a reserva de assentos digite o [CÓDIGO] do evento: ");
        return LeituraDeDados.lerRetornarOpcaoDigitada(teatro.getEventos().size());
    }

    public static void verificarDisponibilidadeEvento(Evento evento, Teatro teatro, Funcionario vendedor) {
        if (exibirApenasEventosDisponiveis(evento)) {
            iniciarVenda(teatro, evento, vendedor);
        } else {
            AuxiliaImpressao.decorarImpressao("-", 70);
            System.out.println("\n(!) Este evento já ocorreu e não está mais disponível para venda.\n");
            AuxiliaImpressao.decorarImpressao("-", 70);
            exibirEventos(teatro, vendedor);
        }
    }

    public static Evento retornarEventoSelecionado(Teatro teatro, int opcDigitada) {
        Evento eventoSelecionado = null;
        for (Map.Entry<Integer, Evento> evento : teatro.getEventos().entrySet()) {
            if (evento.getKey() == opcDigitada) {
                eventoSelecionado = evento.getValue();
                break;
            }
        }
        return eventoSelecionado;
    }

    // Assentos.
    public static void reservarAssentos(Teatro teatro, Evento evento, Cliente cliente, Venda venda) {
        while (true) {
            exibeContagemAssentosLivresEReservados(evento);
            try {
                int assentoSelecionado = solicitarAssento(evento);
                Assento assento = evento.reservarAssento(assentoSelecionado);

                if (!verificarAssentoDisponivel(assento)) {
                    continue;
                }

                exibirInformacoesAssentos(evento);
                emitirIngresso(evento, cliente, assento, venda);

                if (continuarVenda()) {
                    concretizarVendaIngresso(teatro, cliente, venda);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("(!) Entrada inválida. Por favor, digite um número que corresponda às opções exibidas.");
            }
        }
    }

    private static void exibirInformacoesAssentos(Evento evento) {
        exibeContagemAssentosLivresEReservados(evento);
        Grade.montarGradeAssentos(evento);
    }

    private static int solicitarAssento(Evento evento) {
        while (true) {
            try {
                int assentoSelecionado = solicitarNumeroAssento();

                if (!verificarSeNumeroAssentoEhValido(assentoSelecionado, evento)) {
                    imprimirInfoNumeroAssentoInvalido();
                    continue;
                }
                return assentoSelecionado;

            } catch (NumberFormatException e) {
                System.out.println("(!) Entrada inválida. Por favor, digite um número que corresponda às opções exibidas.");
            }
        }
    }

    private static boolean verificarAssentoDisponivel(Assento assento) {
        if (verificarSeAssentoEstaLivre(assento)) {
            imprimirInfoAssentoJaReservado();
            return false;
        }
        return true;
    }

    public static void exibeContagemAssentosLivresEReservados(Evento evento) {
        int qtdAssentosReservados = 0;
        int qtdAssentosLivres = evento.getCapacidade();

        for (int i = 0; i < evento.retornarAssentos().length; i++) {
            for (int j = 0; j < evento.retornarAssentos()[i].length; j++) {
                if (evento.retornarAssentos()[i][j].isReservado()) {
                    qtdAssentosReservados++;
                    qtdAssentosLivres--;
                }
            }
        }
        System.out.printf("\t\t\t\t\tASSENTOS LIVRES: %d | ASSENTOS RESERVADOS: %d%n%n", qtdAssentosLivres, qtdAssentosReservados);
    }

    public static boolean verificarSeAssentoEstaLivre(Assento assento) {
        return assento == null;
    }

    private static int solicitarNumeroAssento() {
        System.out.print("(>) Digite o número de um assento para reservá-lo: ");
        return Integer.parseInt(LeituraDeDados.lerEVerificarCampo());
    }

    public static void imprimirInfoAssentoJaReservado() {
        System.out.println("\n(!) O assento digitado já está reservado.\n");
    }

    public static void imprimirInfoNumeroAssentoInvalido() {
        System.out.println("\n(!) O número do assento digitado não é válido.\n");
    }

    public static boolean verificarSeNumeroAssentoEhValido(int assentoSelecionado, Evento evento) {
        return assentoSelecionado > 0 && assentoSelecionado <= evento.getCapacidade();
    }

    public static boolean continuarVenda() {
        System.out.print("(i) Para reservar outro assento digite (R)eservar\n(>) Para prosseguir com a venda digite (C)ontinuar: ");
        return (LeituraDeDados.lerEVerificarCampo().equalsIgnoreCase("C"));
    }

    // Venda de Ingressos.
    public static void iniciarVenda(Teatro teatro, Evento evento, Funcionario vendedor) {
        Venda venda = new Venda();
        venda.setVendedor((Vendedor) vendedor);
        imprimirDialogoIniciarVenda();
        atribuirClienteVenda(teatro, evento, venda);
    }

    public static void imprimirDialogoIniciarVenda() {
        System.out.print("\n(i) Para cadastrar um novo cliente digite [1]\n(>) Para iniciar o processo de venda digite o CPF do cliente: ");
    }

    public static void imprimirDialogoCPFNaoCadastrado() {
        System.out.println("(!) CPF não cadastrado. Utilize os campos abaixo para cadastrar o cliente.\n");
    }

    private static void atribuirClienteVenda(Teatro teatro, Evento evento, Venda venda) {
        String cpf = LeituraDeDados.lerEVerificarCampo();
        Cliente cliente = verificarClienteCadastrado(teatro, cpf);

        if (cliente != null) {
            Grade.montarGradeAssentos(evento);
            reservarAssentos(teatro, evento, cliente, venda);
        } else {
            imprimirDialogoCPFNaoCadastrado();
            cadastrarCliente(teatro);
        }
    }

    public static void concretizarVendaIngresso(Teatro teatro, Cliente cliente, Venda venda) {
        venda.setCliente(cliente);
        venda.setDataHoraVenda(LocalDateTime.now());
        venda.setCodVenda(teatro.getVendas().size() + 1);
        imprimirResumoDaVenda(venda);

        do
        {
            venda.setPagamento(realizarPagamento(venda));
        } while (!processarPagamento());
        imprimirSucessoNoPagamento();

        venda.getVendedor().addAvaliacao(avaliarAtendimento(venda));
        teatro.addVenda(venda);

        imprimirVendaFinalizada();
    }

    private static void imprimirResumoDaVenda(Venda venda) {
        System.out.println();
        AuxiliaImpressao.decorarImpressao("-", 45);
        System.out.printf("VENDEDOR   : %s%n", venda.getVendedor().getNome());
        AuxiliaImpressao.decorarImpressao("-", 45);
        System.out.printf("VALOR TOTAL: R$ %.2f%n", venda.getValorTotal());
        System.out.printf("CLIENTE    : %s %s", venda.getCliente().getNome(), venda.getCliente().getSobrenome());
        System.out.printf("%nCPF        : %s%n", venda.getCliente().getCpf());
        AuxiliaImpressao.decorarImpressao("-", 45);
        listarIngressosDaVenda(venda);
        AuxiliaImpressao.decorarImpressao("-", 45);
    }

    private static void listarIngressosDaVenda(Venda venda) {
        List<Ingresso> ingressos = venda.getIngressos();
        System.out.printf("EVENTO: %s%n", venda.getIngressos().get(0).getEvento().getNome());
        System.out.println("ASSENTOS RESERVADOS");
        for (Ingresso ingresso : ingressos) {
            System.out.printf("Nª ASSENTO: %d%n", ingresso.getAssento().getNumero());
        }
    }

    private static boolean processarPagamento() {
        System.out.println("(i) Aguarde, o pagamento está sendo processado...");
        try {
            TimeUnit.SECONDS.sleep(1);
            return true;
        } catch (
                InterruptedException e) {
            System.out.println("(ERRO) Não foi possível processar o pagamento!");
            return false;
        }
    }

    public static void imprimirSucessoNoPagamento() {
        AuxiliaImpressao.decorarImpressao("*", 36);
        System.out.println("(i) Pagamento realizado com sucesso!");
        AuxiliaImpressao.decorarImpressao("*", 36);
    }

    public static void imprimirVendaFinalizada() {
        AuxiliaImpressao.decorarImpressao("-", 21);
        System.out.println("(i) Venda finalizada!");
        AuxiliaImpressao.decorarImpressao("-", 21);
    }

    public static ETipoPagamento escolherTipoPagamento() {
        System.out.println("(i) Escolha a forma de pagamento:");
        for (ETipoPagamento e : ETipoPagamento.getTiposPagamento()) {
            System.out.println(e.getTipoPagamento());
        }
        System.out.println();
        ETipoPagamento tipoPagamento = null;
        System.out.print("(>) DIGITE A OPÇÃO DESEJADA: ");
        int opc = LeituraDeDados.lerRetornarOpcaoDigitada(4);
        switch (opc) {
            case 1:
                tipoPagamento = ETipoPagamento.DINHEIRO;
                break;
            case 2:
                tipoPagamento = ETipoPagamento.CREDITO;
                break;
            case 3:
                tipoPagamento = ETipoPagamento.DEBITO;
                break;
            case 4:
                tipoPagamento = ETipoPagamento.PIX;
                break;
        }
        return tipoPagamento;
    }

    public static Pagamento realizarPagamento(Venda venda) {
        Pagamento pagamento = new Pagamento();
        pagamento.setMeioPagamento(escolherTipoPagamento());
        pagamento.setValor(venda.getValorTotal());

        return pagamento;
    }

    public static Cliente verificarClienteCadastrado(Teatro teatro, String cpf) {
        for (Map.Entry<String, Cliente> c : teatro.getClientes().entrySet()) {
            Cliente cliente = c.getValue();
            if (c.getKey().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public static void emitirIngresso(Evento evento, Cliente cliente, Assento assento, Venda venda) {
        Ingresso ingresso = new Ingresso(assento, cliente, evento);
        venda.addIngresso(ingresso);
        evento.addIngresso(ingresso);
        imprimirSucessoNaEmissaoDoIngresso(evento, ingresso);
    }

    public static void imprimirSucessoNaEmissaoDoIngresso(Evento evento, Ingresso ingresso) {
        AuxiliaImpressao.decorarImpressao("-", 60);
        System.out.printf("(i) Ingresso [%d] emitido para o evento %s%n", ingresso.getNumero(), evento.getNome());
        AuxiliaImpressao.decorarImpressao("-", 60);
    }

    // Avaliação.
    public static Avaliacao avaliarAtendimento(Venda venda) {
        Avaliacao avaliacaoAtendimento = definirDadosDaAvaliacao(venda);
        while (!processarAvaliacaoDoCliente()) {
            venda.setPagamento(realizarPagamento(venda)); //Libera a venda assim que o cliente faz a avaliação.
        }
        imprimirSucessoNaAvaliacao();

        return avaliacaoAtendimento;
    }

    public static Avaliacao definirDadosDaAvaliacao(Venda venda) {
        Avaliacao avaliacaoAtendimento = new Avaliacao();
        Evento evento = null;
        for (Ingresso ing : venda.getIngressos()) {
            evento = ing.getEvento();
        }
        avaliacaoAtendimento.setCliente(venda.getCliente());
        avaliacaoAtendimento.setEvento(evento);
        avaliacaoAtendimento.setDataHora(LocalDateTime.now());
        avaliacaoAtendimento.avaliar();

        return avaliacaoAtendimento;
    }

    public static void avaliarEvento(Teatro teatro) {
        Avaliacao avaliacaoEvento = new Avaliacao();
        Map<String, Cliente> clientes = teatro.getClientes();
        System.out.print("Digite o CPF do cliente: ");
        String cpf = LeituraDeDados.lerEVerificarCampo();

        for (Map.Entry<String, Cliente> cli : clientes.entrySet()) {
            if (cli.getKey().equals(cpf)) {
                Cliente cliente = cli.getValue();
                System.out.print("Digite o código do evento: ");
                int opc = Integer.parseInt(LeituraDeDados.lerEVerificarCampo());
                Map<Integer, Evento> eventos = teatro.getEventos();
                for (Map.Entry<Integer, Evento> evt : eventos.entrySet()) {
                    if (evt.getKey().equals(opc)) {
                        adicionarAvaliacao(evt, avaliacaoEvento, cliente);
                    }
                }
            }
        }
    }

    public static void adicionarAvaliacao(Map.Entry<Integer, Evento> evt, Avaliacao avaliacaoEvento, Cliente cliente) {
        while (true) {
            System.out.print("(>) Digite a nota do cliente para o evento: ");
            int nota = Integer.parseInt(LeituraDeDados.lerEVerificarCampo());
            if (avaliacaoEvento.setNota(nota)) {
                avaliacaoEvento.setEvento(evt.getValue());
                avaliacaoEvento.setCliente(cliente);
                avaliacaoEvento.setDataHora(LocalDateTime.now());
                evt.getValue().addAvaliacao(avaliacaoEvento);
                imprimirSucessoNaAvaliacao();
                break;
            } else {
                System.out.println("(i) A nota deve ser de 0 a 5.");
            }
        }
    }

    public static void imprimirSucessoNaAvaliacao() {
        AuxiliaImpressao.decorarImpressao("-", 36);
        System.out.println("(i) Avaliação registrada com sucesso!");
        AuxiliaImpressao.decorarImpressao("-", 36);
    }

    public static boolean processarAvaliacaoDoCliente() {
        System.out.println("\n(i) Aguarde enquanto o cliente faz a avaliação do atendimento...");
        try {
            TimeUnit.SECONDS.sleep(2);
            return true;
        } catch (
                InterruptedException e) {
            System.out.println("(ERRO) Não foi possível processar a avaliação!");
            return false;
        }
    }
}