public class Main {

    public static void main(String[] args) {

        // Створення матриць.
        char[][] a = {
                {12, 4, 8, 11},
                {16, 9, 3, 13},
                {7, 11, 16, 15}
        };
        char[][] b = {
                {15, 12, 4, 5},
                {19, 1, 3, 11},
                {2, 11, 6, 10}
        };

        System.out.println("Матриця A: ");
        for (char[] i : a) {
            for (char j : i) {
                /* При виведенні елементів ми додаємо пробіли на кінці
                цілого числа (%-4d) задля легшого читання матриці.
                */
                System.out.printf("%-4d", (int) j);
            }
            System.out.println();
        }

        System.out.println("\nМатриця B: ");
        for (char[] i : b) {
            for (char j : i) {
                System.out.printf("%-4d", (int) j);
            }
            System.out.println();
        }

        // Перевірка на те, чи є матриці однакових форм.
        if (a[0].length != b[0].length || a.length != b.length) {
            System.out.println("Матриці А і В мають різні форми.");
        } else {
            int[][] c = new int[a.length][a[0].length];
            float sum = 0;

            System.out.println("\nМатриця С: ");
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {

                    c[i][j] = (byte) a[i][j] ^ (byte) b[i][j];
                    sum += c[i][j];
                    System.out.printf("%-4d", c[i][j]);
                }
                System.out.println();
            }

            float average = sum / (c.length * c[0].length);
            System.out.printf("\nСереднє значення матриці С: %.3f", average);
        }
    }

}
