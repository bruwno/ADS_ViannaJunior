
public class Incremento {
    public static void main(String[] args) {
        /*
         * OPERADOR DE PRÉ-INCREMENTO
         * O operador de pré-incremento (++variavel) aumenta o valor da variável em 1
         * antes de usar a variável em uma expressão
         */
        int num = 10;
        int resultado = ++num; // num é incrementada para 11 e depois é atribuída a resultado.
        System.out.println(num); // Imprime 10.
        System.out.println(resultado); // Imprime 10;

        /*
         * OPERADOR DE PÓS-INCREMENTO
         * Já o operador de pós-incremento (variavel++) aumenta o valor da variável em 1
         * depois de usar a variável em uma expressão
         */
        int num2 = 10;
        int resultado2 = num++; // num é atribuída à variável resultado e posteriormente é incrementada para 11.
        System.out.println(num2); // Imprime 10.
        System.out.println(resultado2); // Imprime 11.
    }
}