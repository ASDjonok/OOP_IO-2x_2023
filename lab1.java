import java.util.Scanner;

public class lab1 {
    public static void main(String[] args) {
        float S = 0, i, j;
        int C = 1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть значення a (a>1):");
        int a = scan.nextInt();
        System.out.println("Введіть значення b:");
        int b = scan.nextInt();
        System.out.println("Введіть значення n:");
        int n = scan.nextInt();
        System.out.println("Введіть значення m:");
        int m = scan.nextInt();
        for (i = a; i <= n; i++) {
            if (i - C == 0) {
                System.out.println("Ділення на 0");
                return;
            }
            for (j = b; j <= m; j++) {
                S += (i - j) / (i - C);

            }
        }
        System.out.println(S);

    }
}
