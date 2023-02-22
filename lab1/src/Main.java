public class Main {

    public static void main(String[] args) {
        float s = 0, a = 2, b = 1, m = 6, n = 4;

        for (float i = a; i <= m; i++) {
            for (float j = b; j <= n; j++) {
                // Перевірка ділення на 0.
                if (i == -1) {
                    System.out.println("Помилка: ділення на нуль не можливе.");
                    return;
                }
                s += (i + j) / (i + 1);
            }
        }

        System.out.println("S = " + s);
    }

}
