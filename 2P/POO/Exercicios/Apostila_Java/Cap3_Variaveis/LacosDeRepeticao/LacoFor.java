public class LacoFor{
    public static void main(String[] args) {
        for (int i = 1; i < 30; i++) {
            if (i > 15 && i < 19) {
                continue;
            }
            System.out.print(i + " ");
            // Pula uma linha a cada 3 numeros.
            if (i % 3 == 0) {
                System.out.println();
            }
        }
    }
}