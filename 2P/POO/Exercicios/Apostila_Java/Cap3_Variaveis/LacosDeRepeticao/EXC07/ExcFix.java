public class ExcFix{
    public static void main(String[] args) {
        int x = 13;

        for (int i = 0; i < x; i++) {
            if (i % x == 0) {
                x = x / 2;
                System.out.println(x);
            }
            else if (i % x == 1) {
                x = 3 * x + 1;
                System.out.println(x);
            }
            
        }
    }
}