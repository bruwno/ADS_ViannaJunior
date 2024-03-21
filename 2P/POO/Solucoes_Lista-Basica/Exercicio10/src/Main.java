/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 18/03/2024
 *
 * Exercício 10. Faça um programa para pesquisa sobre algumas características físicas da população
 * de uma determinada região coletou os seguintes dados, referentes a cada habitante, para serem analisados:
 * - sexo (masculino, feminino)
 * - cor dos olhos (azuis, verdes, castanhos)
 * - cor dos cabelos (louros, castanhos, pretos)
 * - altura
 * - idade
 * O aplicativo deve calcular e imprimir as seguintes informações:
 * a) a maior e a menor altura dos habitantes;
 * b) a média de altura das mulheres;
 * c) o número de homens;
 * d) A porcentagem de homens e de mulheres.
 * e) A porcentagem de indivíduos do sexo feminino cuja idade esteja entre 18 e 35 anos,
 * inclusive, e que tenham olhos verdes e cabelos louros.
 */

import br.com.williamsilva.participantepesquisa.CoresOlhos;
import br.com.williamsilva.participantepesquisa.CoresCabelos;
import br.com.williamsilva.participantepesquisa.Generos;
import br.com.williamsilva.participantepesquisa.Habitante;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Habitante h = new Habitante();

        int qtdParticipantes = leQtdParticipantes(sc);

        for (int i = 0; i < qtdParticipantes; i++) {
            System.out.printf("%n| Participante %d de %d |%n", i + 1, qtdParticipantes);
            h.addPessoa(lerDadosHabitante());
        }

        exibirResultadosDaPesquisa(h);
    }

    public static int leQtdParticipantes(Scanner sc) {
        System.out.print("Quantas pessoas irão participar da pesquisa?: ");
        return sc.nextInt();
    }

    public static Habitante lerDadosHabitante() {
        Scanner sc = new Scanner(System.in);
        Habitante h = new Habitante();
        System.out.println("\tInforme seus dados para a pesquisa");

        System.out.print("\tGênero: \n");
        h.setSexo(escolherGenero());

        System.out.print("\tCor dos olhos: \n");
        h.setCorDosOlhos(escolherCorDosOlhos());

        System.out.print("\tCor dos cabelos: \n");
        h.setCorDosCabelos(escolherCorDosCabelos());

        System.out.print("\tAltura: ");
        h.setAltura(leRetornaAltura(sc));

        System.out.print("\tIdade : ");
        h.setIdade(leRetornaIdade(sc));

        return h;
    }

    public static void exibirResultadosDaPesquisa(Habitante h) {
        System.out.println("\nResultados da pesquisa");
        System.out.println("ALTURA DA POPULAÇÃO");
        System.out.printf("\tMenor altura: %.2f m%n", h.calcularMenorAltura());
        System.out.printf("\tMaior altura: %.2f m%n", h.calcularMaiorAltura());

        System.out.println("\nALTURA MÉDIA ENTRE AS MULHERES");
        System.out.printf("\tMédia: %.2f m%n", h.calcularMediaAlturaMulheres());

        System.out.println("\nPARTICIPANTES DA PESQUISA QUE SÃO HOMENS");
        System.out.printf("\tTotal: %d%n", h.calcularQtdHabitantesSexoMasculino());

        System.out.println("\nPERCENTUAL DE COMPOSIÇÃO DA POPULAÇÃO (por gênero)");
        System.out.printf("\tTotais: %s%n", h.obterPercentDeHomensEMulheres());

        System.out.println("\nPERCENTUAL DE LOIRAS NA FAIXA (18-35 anos) QUE TÊM OLHOS VERDES");
        System.out.printf("\tTotal: %.2f%%%n", h.obterPercentLoirasOlhosVerdes());
    }

    public static char leRetornaGenero() {
        Scanner sc = new Scanner(System.in);
        char opcaoDigitada = ' ';
        while (opcaoDigitada != 'M' && opcaoDigitada != 'F') {
            System.out.print("\t\t|>| ");
            opcaoDigitada = sc.next().toUpperCase().charAt(0);
        }
        return opcaoDigitada;
    }

    public static double leRetornaAltura(Scanner sc) {
        return sc.nextDouble();
    }

    public static int leRetornaIdade(Scanner sc) {
        return sc.nextInt();
    }

    public static void listarGeneros() {
        List<Generos> listaDeGeneros = Generos.getGeneros();
        for (Generos genero : listaDeGeneros) {
            System.out.printf("\t\t[%c] %s%n", genero.getIdGenero(), genero.getNomeGenero());
        }
    }

    public static Generos escolherGenero() {
        listarGeneros();
        char opcDigitada = leRetornaGenero();
        Generos genero = null;
        switch (opcDigitada) {
            case 'M':
                genero = Generos.MASCULINO;
                break;
            case 'F':
                genero = Generos.FEMININO;
                break;
        }
        return genero;
    }

    public static void listarCoresDeOlhos() {
        List<CoresOlhos> listaDeCoresDeOlhos = CoresOlhos.getCoresOlhos();
        for (CoresOlhos coresOlhos : listaDeCoresDeOlhos) {
            System.out.printf("\t\t[%d] %s%n", coresOlhos.getIdCorDosOlhos(), coresOlhos.getCorDosOlhos());
        }
    }

    public static CoresOlhos escolherCorDosOlhos() {
        listarCoresDeOlhos();
        int opcDigitada = lerOpcaoDigitada(3);
        CoresOlhos corDosOlhos = null;
        switch (opcDigitada) {
            case 1:
                corDosOlhos = CoresOlhos.AZUIS;
                break;
            case 2:
                corDosOlhos = CoresOlhos.VERDES;
                break;
            case 3:
                corDosOlhos = CoresOlhos.CASTANHOS;
                break;
        }
        return corDosOlhos;
    }

    public static void listarCoresDeCabelos() {
        List<CoresCabelos> listaCoresDeCabelos = CoresCabelos.getCoresDeCabelos();
        for (CoresCabelos coresCabelos : listaCoresDeCabelos) {
            System.out.printf("\t\t[%d] %s%n", coresCabelos.getIdCorCabelos(), coresCabelos.getCorDosCabelos());
        }
    }

    public static CoresCabelos escolherCorDosCabelos() {
        listarCoresDeCabelos();
        int opcDigitada = lerOpcaoDigitada(3);
        CoresCabelos corDosCabelos = null;
        switch (opcDigitada) {
            case 1:
                corDosCabelos = CoresCabelos.LOUROS;
                break;
            case 2:
                corDosCabelos = CoresCabelos.CASTANHOS;
                break;
            case 3:
                corDosCabelos = CoresCabelos.PRETOS;
                break;
        }
        return corDosCabelos;
    }

    public static int lerOpcaoDigitada(int qtdOpcoes) {
        Scanner sc = new Scanner(System.in);
        int opcaoDigitada = 0;
        while (opcaoDigitada <= 0 || opcaoDigitada > qtdOpcoes) {
            System.out.print("\t\t|>| ");
            opcaoDigitada = sc.nextInt();
        }
        return opcaoDigitada;
    }
}