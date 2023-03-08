package lab2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть значення n:");
        double n = 0;
        try {
            n = scan.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Число введене не вірно");
            System.exit(0);
        }
        System.out.println("Введіть значення m:");
        double m = 0;
        try {
            m = scan.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Число введене не вірно");
            System.exit(0);
        }

        System.out.println("Введіть значення a:");
        double a = 0;
        try {
            a = scan.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Число введене не вірно");
            System.exit(0);
        }
        System.out.println("Введіть значення b:");
        double b = 0;
        try {
            b = scan.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Число введене не вірно");
            System.exit(0);
        }
        if (a > n) {
            System.out.println("Значення n має бути більшим або рівним  a");
            System.exit(0);
        }
        if (b > m) {
            System.out.println("Значення m має бути більшим або рівним  b");
            System.exit(0);
        }
        double s1 = 0;
        double s2 = 0;

        for (double i = a; i <= n; i++) {
            for (double j = b; j <= m; j++){
                // оскільки C дорівнює 0, то можна скоротити i
                s1=s1+(1/j);
            }
            s2=s2+s1;
        }
        System.out.println("Результат:" + s2);
    }
}
