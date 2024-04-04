/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 28/02/2024
 *
 * Exercício 8) Crie uma classe chamada "Produto" que represente um produto em uma loja.
 * Esta classe deve ter os seguintes atributos: nome (String), código de barras
 * (String), preço (double) e quantidade em estoque (int). Além disso, a classe deve
 * ter métodos para verificar se o produto está disponível em estoque e para exibir
 * algumas informações sobre o produto. Em seguida, crie um programa principal
 * que instancia objetos da classe "Produto", atribui valores aos seus atributos e
 * verifica se cada produto está disponível em estoque.
 */

public class Main {
    public static void main(String[] args) {
        Produto prod1, prod2, prod3;
        prod1 = new Produto("AMD Ryzen 5800X", "012457190074", 1500, 20);
        prod2 = new Produto("Mouse Gamer", "094576345987", 359.90, 0);
        prod3 = new Produto("Monitor 20″", "000146510965", 598.95, 100);

        System.out.println(prod1.exibeInformacoes());
        System.out.println("Estoque do produto: " + prod1.verificaDispProdutoNoEstoque());

        System.out.println(prod2.exibeInformacoes());
        System.out.println("Estoque do produto: " + prod2.verificaDispProdutoNoEstoque());

        System.out.println(prod3.exibeInformacoes());
        System.out.println("Estoque do produto: " + prod3.verificaDispProdutoNoEstoque());
    }
}