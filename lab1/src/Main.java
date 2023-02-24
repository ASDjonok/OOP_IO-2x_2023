public class Main {

    public static void main(String[] args) {
        float s = 0.0f, a = 2.0f, b = 1.0f, m = 6.0f, n = 4.0f;
        int c = 1;

        for (float i = a; i <= m; i++) {
            // Перевірка ділення на 0.
            if (i == -1) {
                System.out.println("Помилка: ділення на нуль не можливе.");
                return;
            }
            for (float j = b; j <= n; j++) {
                s += (i + j) / (i + c);
            }
        }

        System.out.println("S = " + s);
    }

}
