import java.util.Scanner;

public class Lab_1 {
    public static void main(String[] args) {
        int n, m, a, b;
        float s = 0;

        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        n = input.nextInt();

        System.out.print("Enter m: ");
        m = input.nextInt();

        do {
            System.out.print("Enter a (can't be above n): ");
            a = input.nextInt();
        } while (a > n);

        do {
            System.out.print("Enter b (can't be above m): ");
            b = input.nextInt();
        } while (b > m);

        if ((a <= 0) && (n >= 0)) {
            System.out.println("Error, division by zero, shutting down!");
            System.exit(1);
        }

        for (int i = a; i < n; i++) {
            for (int j = b; j < m; j++) {
                s += i * j / i;
            }
        }

        System.out.println("S = " + s);
    }
}
