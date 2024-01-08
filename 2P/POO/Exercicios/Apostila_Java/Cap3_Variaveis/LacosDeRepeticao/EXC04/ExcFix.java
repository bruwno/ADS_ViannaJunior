public class ExcFix{
    public static void main(String[] args) {
        int fat = 1;
        for (int i = 1; i <= 10; i++) {
            fat *= i;
            System.out.println("Fatorial de " + i + " = " + fat);
        }
    }
}