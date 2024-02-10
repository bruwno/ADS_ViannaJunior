import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner readLine = new Scanner(System.in);
        //
        System.out.print("Digite o valor: ");
        int fib = readLine.nextInt();
        readLine.close();
        //
        System.out.printf("O Fibonacci de %d é = %d", fib, fibonacci(fib));
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}