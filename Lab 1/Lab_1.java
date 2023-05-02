import java.util.Scanner;

public class Lab_1 {
    public static void main(String[] args) {
        int n, m, a, b;
        float s = 0;

        Scanner input = new Scanner(System.in);
        
        do {
            try {
                System.out.print("Enter n: ");
                n = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("N must be an integer.");
                input.nextLine();
            }
        } while (true);

        do {
            try {
                System.out.print("Enter m: ");
                m = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("M must be an integer.");
                input.nextLine();
            }
        } while (true);

        do {
            try {
                System.out.print("Enter a: ");
                a = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("A must be an integer.");
                input.nextLine();
            }
        } while (true);

        do {
            try {
                System.out.print("Enter b: ");
                b = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("B must be an integer.");
                input.nextLine();
            }
        } while (true);

        input.close();

        for (int i = a; i <= n; i++) {
            for (int j = b; j <= m; j++) {
                s += j;
            }
        }

        System.out.println("S = " + s);
    }
}
