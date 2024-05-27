import java.util.Scanner;

import util.Lista;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Lista encadeada com Java");
        Scanner sc = new Scanner(System.in);

        Lista<Integer> lista = new Lista<>();

        int opc;
        do {
            showMenu();
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("[INSERCAO NO INICIO] Digite um numero inteiro: ");
                    int valor = sc.nextInt();
                    lista.inserirNoInicio(valor);
                    break;
                case 2:
                    System.out.print("[INSERCAO NO FINAL] Digite um numero inteiro: ");
                    valor = sc.nextInt();
                    lista.inserirNoFinal(valor);
                    break;
                case 3:
                    System.out.printf("ELEMENTOS DA LISTA: %s%n", lista.toString());
                    break;
                case 4:
                    System.out.printf("TAMANHO DA LISTA: %d elementos.%n", lista.getQtdElementos());
                    break;
                case 5:
                    Lista<Integer> listaOrdenada = lista.ordenar(lista);
                    System.out.printf("LISTA ORDENADA: %s%n", listaOrdenada.toString());
                    break;
                case 6:
                    System.out.print("Digite a posicao: ");
                    int posicao = sc.nextInt();
                    System.out.print("Digite o valor que sera inserido: ");
                    valor = sc.nextInt();
                    lista.setValorPosicao(posicao, valor);
                    break;
                case 7:
                    System.out.printf("MENOR VALOR: %d%n", lista.getMenorValor());
                    break;
                case 8:
                    System.out.printf("MAIOR VALOR: %d%n", lista.getMaiorValor());
                    break;
                case 0:
                    System.exit(-1);
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        } while (opc != 0);

        sc.close();
    }

    public static void showMenu() {
        System.out.println("""
                1 - Inserir elemento no inicio da lista
                2 - Inserir elemento no final da lista
                3 - Exibir elementos da lista
                4 - Exibir o tamanho da lista
                5 - Ordenar lista
                6 - Trocar o valor de uma posicao N
                7 - Exibir o menor valor da lista
                8 - Exibir o maior valor da lista
                ---------
                0 - Sair
                """);
    }
}
