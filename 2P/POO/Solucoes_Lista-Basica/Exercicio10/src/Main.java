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
            h.addHabitante(lerDadosHabitante());
        }

        exibirResultadosDaPesquisa(h);
    }

    public static int leQtdParticipantes(Scanner sc) {
        System.out.print("Quantas pessoas irão participar da pesquisa?: ");
        return sc.nextInt();
    }

    public static void exibirResultadosDaPesquisa(Habitante h) {
        System.out.println("\nResultados da pesquisa");
        System.out.println("ALTURA DA POPULAÇÃO");
        System.out.printf("\tMENOR ALTURA: %.2f m%n", h.calcularMenorAltura());
        System.out.printf("\tMAIOR ALTURA: %.2f m%n", h.calcularMaiorAltura());

        System.out.println("\nALTURA MÉDIA ENTRE AS MULHERES");
        System.out.printf("\tMÉDIA: %.2f m%n", h.calcularMediaAlturaMulheres());

        System.out.println("\nPARTICIPANTES DA PESQUISA QUE SÃO HOMENS");
        System.out.printf("\tTOTAL: %d%n", h.calcularQtdHabitantesSexoMasculino());

        System.out.println("\nPERCENTUAL DE COMPOSIÇÃO DA POPULAÇÃO (por gênero)");
        System.out.printf("\t%s%n", h.obterPorcentDeHomensEMulheres());

        System.out.println("\nPERCENTUAL DE LOIRAS NA FAIXA (18-35 anos) QUE TÊM OLHOS VERDES");
        System.out.printf("\t%.2f%%%n", h.obterPorcentLoirasOlhosVerdes());
    }

    public static Habitante lerDadosHabitante() {
        Scanner sc = new Scanner(System.in);
        Habitante h = new Habitante();
        System.out.println("\t[Informe seus dados para a pesquisa]");

        System.out.print("\tGênero (M)asculino ou (F)eminino: ");
        h.setSexo(leRetornaGenero(sc));

        System.out.print("\tCor dos olhos: \n");
        h.setCorDosOlhos(escolherCorDosOlhos());

        System.out.print("\tCor dos cabelos: \n");
        h.setCorDosCabelos(escolherCorDosCabelos());

        System.out.print("\tAltura: ");
        h.setAltura(leRetornaAltura(sc));

        System.out.print("\tIdade: ");
        h.setIdade(leRetornaIdade(sc));

        return h;
    }

    public static Character leRetornaGenero(Scanner sc) {
        return sc.next().toUpperCase().charAt(0);
    }

    public static double leRetornaAltura(Scanner sc) {
        return sc.nextDouble();
    }

    public static int leRetornaIdade(Scanner sc) {
        return sc.nextInt();
    }

    public static void listarCoresDeOlhos() {
        List<CoresOlhos> listaDeCoresDeOlhos = CoresOlhos.getCoresOlhos();
        for (CoresOlhos coresOlhos : listaDeCoresDeOlhos) {
            System.out.printf("\t\t[%d] %s%n", coresOlhos.getIdCorDosOlhos(), coresOlhos.getCorDosOlhos());
        }
    }

    public static String escolherCorDosOlhos() {
        listarCoresDeOlhos();
        int opcDigitada = lerOpcaoDigitada(3);
        String corDosOlhos = "";
        switch (opcDigitada) {
            case 1:
                corDosOlhos = CoresOlhos.AZUIS.getCorDosOlhos();
                break;
            case 2:
                corDosOlhos = CoresOlhos.VERDES.getCorDosOlhos();
                break;
            case 3:
                corDosOlhos = CoresOlhos.CASTANHOS.getCorDosOlhos();
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

    public static String escolherCorDosCabelos() {
        listarCoresDeCabelos();
        int opcDigitada = lerOpcaoDigitada(3);
        String corDosCabelos = "";
        switch (opcDigitada) {
            case 1:
                corDosCabelos = CoresCabelos.LOUROS.getCorDosCabelos();
                break;
            case 2:
                corDosCabelos = CoresCabelos.CASTANHOS.getCorDosCabelos();
                break;
            case 3:
                corDosCabelos = CoresCabelos.PRETOS.getCorDosCabelos();
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