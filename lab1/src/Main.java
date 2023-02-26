import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    /* Номер залікової книжки - 2425,
    C2 = 1, C3 = 1 = C,C5 = 0, C7 = 3, index's type = long */
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");

    public static void main(String[] args) {
        //System.out.println("Перед тим як вводити значення враховуйте умову: 0 < a <= n\n 0 <= b <= m");
        System.out.print("\nВеддіть ваше значення a: ");
        Scanner a1 = new Scanner(System.in);
        int a = a1.nextInt();
        System.out.print("\nВеддіть ваше значення b: ");
        Scanner b1 = new Scanner(System.in);
        int b = b1.nextInt();
        System.out.print("\nВеддіть ваше значення m: ");
        Scanner m1 = new Scanner(System.in);
        int m = m1.nextInt();
        System.out.print("\nВеддіть ваше значення n: ");
        Scanner n1 = new Scanner(System.in);
        int n = n1.nextInt();
        double S = 0;
        final int C = 1; //Const
        if (b >= 0 && a <= n && b <= m && a > 1) {
            for (long i = a; i <= n; i++) {
                for (long j = b; j <= m; j++) {
                    S += (double) (i * j) / (i - C);
                }
            }
            System.out.println("Значення S = " + DECIMAL_FORMAT.format(S));
        } else {
            System.out.println("Значення А має бути > 0\nЗначення А має бути <= n");
            System.out.println("Значення B має бути >= 0\nЗначення B має бути <= m");
        }

    }
}