package br.edu.vianna.basededados;

import br.edu.vianna.autenticar.Autenticacao;
import br.edu.vianna.clientes.Cliente;
import br.edu.vianna.clientes.Endereco;
import br.edu.vianna.modelosteatro.Teatro;
import br.edu.vianna.eventos.Evento;
import br.edu.vianna.funcionarios.Administrador;
import br.edu.vianna.funcionarios.Funcionario;
import br.edu.vianna.funcionarios.Vendedor;

import java.util.Map;

public class Bases {
    public static Map<String, Funcionario> baseDeFuncionarios(Autenticacao auth) {
        Funcionario adm = new Administrador("Raphael", "raphael@mail.com", "1234");
        Funcionario vend1 = new Vendedor(1, "Samuel", "samuel@mail.com", "123", 0, "01/05/2024");
        Funcionario vend2 = new Vendedor(2, "Renan", "renan@mail.com", "012", 0, "10/05/2024");
        auth.cadastraFuncionario(adm);
        auth.cadastraFuncionario(vend1);
        auth.cadastraFuncionario(vend2);

        return auth.getFuncionariosCadastrados();
    }

    public static Map<Integer, Evento> baseDeEventos(Teatro teatro) {
        Evento evt1 = new Evento("Coral", "17/10/2024", "14:00", "Apresentação do coral", 50.0, 80);
        Evento evt2 = new Evento("Show de Stand-up", "18/05/2024", "18:00", "Show de Humor", 80.0, 50);
        Evento evt3 = new Evento("Música ao vivo", "19/05/2024", "19:30", "Apresentação Musical", 120.0, 100);
        Evento evt4 = new Evento("Teatro de bonecos", "05/06/2024", "18:00", "Teatro de bonecos", 100.0, 90);
        Evento evt5 = new Evento("Momento cultural", "05/06/2024", "19:00", "Show beneficente", 20.0, 100);
        teatro.addEvento(evt1);
        teatro.addEvento(evt2);
        teatro.addEvento(evt3);
        teatro.addEvento(evt4);
        teatro.addEvento(evt5);

        return teatro.getEventos();
    }

    public static Map<String, Cliente> baseDeClientes(Teatro teatro) {
        Endereco endCli1 = new Endereco("Dalvo Trombeta", "357", "Casa 1", "São José", "Formoso do Norte", "35000123", "MG");
        Cliente cli1 = new Cliente("Otávio", "Silva", "12345678900", "diogenes@mail.com", "32988776655", "01/01/1993", endCli1);
        Endereco endCli2 = new Endereco("Rua dos Javeiros", "17", "", "São Oracle", "Javantes", "34000321", "SP");
        Cliente cli2 = new Cliente("Diógenes", "Lopes", "00987654321", "otavio@mail.com", "119112234455", "10/05/2002", endCli2);
        teatro.addCliente(cli1);
        teatro.addCliente(cli2);

        return teatro.getClientes();
    }
}
