package IO_24._02_Бондаренко_Тарас_Андрійович.lab6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        Comfort tariff1 = new Comfort("Comfort", 100, 5000);
        Economy tariff2 = new Economy("Economy", 25, 10000);
        Optimal tariff3 = new Optimal("Optimal", 300, 50000);

        Tariff[] tariffs = {tariff1, tariff2, tariff3};
        int sum = 0;
        System.out.println("Тарифи мобільної мобільної компанії:");
        for (int i = 0; i < tariffs.length; i++) {
            System.out.printf("\t%d. %s%n", i + 1, tariffs[i].getName());
            sum += tariffs[i].getCustomers();
        }
        System.out.println("\nЗагальна кількість користувачів: " + sum + ";");

        System.out.println("\nТарифи мобільної компанії відсортовані за вартістю:");
        Arrays.sort(tariffs, Comparator.comparing(Tariff::getPrice));
        for (int i = 0; i < tariffs.length; i++) {
            System.out.printf("\t%d. %s%n", i + 1, tariffs[i]);
        }
        System.out.println("\nВведіть діапазон цін, в якому бажаєте підібрати тариф: ");

        Scanner scan = new Scanner(System.in);
        System.out.print("\tМінімальна ціна: ");
        int minSum = scan.nextInt();
        System.out.print("\tМаксимальна ціна: ");
        int maxSum = scan.nextInt();
        scan.close();
        int n2 = 0;

        System.out.println("\nПідібрані тарифи: ");
        for (int i = 0; i < tariffs.length; i++) {
            if (minSum <= tariffs[i].getPrice() && tariffs[i].getPrice() <= maxSum) {
                System.out.printf("\t%d. %s%n", i + 1, tariffs[i]);
                n2 += 1;
            }
        }
        if (n2 == 0) {
            System.out.println("\tНе знайдено тарифів в заданому діапазоні цін;");
        }
    }
}
