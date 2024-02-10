public class ExcFix{
    public static void main(String[] args) {
        long fat = 1;
        for (int i = 1; i <= 40; i++) {
            fat *= i;
            System.out.println("Fatorial de " + i + " = " + fat);
        }
    }
}