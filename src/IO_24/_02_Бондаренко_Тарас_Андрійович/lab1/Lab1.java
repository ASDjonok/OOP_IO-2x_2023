package IO_24._02_Бондаренко_Тарас_Андрійович.lab1;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
//        O1 = +
//        C = 2
//        O2 = %
//        i, j = short(-32.768 to 32.768)
        final int c = 2;
        double result = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = scan.nextInt();// Entering a
        System.out.print("Enter b: ");
        int b = scan.nextInt();// Entering b
        System.out.print("Enter n: ");
        int n = scan.nextInt();// Entering n
        System.out.print("Enter m: ");
        int m = scan.nextInt();// Entering m
        scan.close();

        if (a >= n || b >= m || a <= -c && n >= -c || b <= 0 && m >= 0) {
            System.out.println("Error! Division by zero");
            return;
        }

        for (short i = (short) a; i <= n; i++) {
            for (short j = (short) b; j <= m; j++) {
                result += (double) (i % j) / (i + c); //Calculation of the result
            }
        }
        System.out.println("\ns = " + result); // Outputting the result

    }
}

