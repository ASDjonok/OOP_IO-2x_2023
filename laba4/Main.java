import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int quantity = 0;
        while (true) {
            System.out.println("Скільки елементів в масиві ви хочете мати?");
            try {
                quantity = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Введені символи не є цілим числом, спробуйте ще раз.");
                scanner.nextLine();
            }
        }
        Cosmetic[] arr = new Cosmetic[quantity];

        for (int i = 0; i < quantity; i++) {
            while (true) {
                System.out.println("Бажаєте заповнить об'єкт №" + (i + 1) + " випадковими значеннями?(Введіть так або ні)");
                String anwser = scanner.next();
                if (anwser.equalsIgnoreCase("так")) {
                    arr[i] = new Cosmetic();
                    break;
                } else {
                    if (anwser.equalsIgnoreCase("ні")) {
                        System.out.println("Добре, задайте дані об'єкта номер" + (i + 1) + ":");
                        int price = 0;

                            while (true) {
                                System.out.print("Введіть ціну в долларах: ");
                                try {
                                    price = scanner.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Введені символи не є цілим числом, спробуйте ще раз.");
                                    scanner.nextLine();
                                }
                            }


                        int healthDamage = 0;
                        while (true){
                            System.out.print("Введіть шкоду здоров'ю по шкалі від 0 до 10: ");
                            while (true) {
                                try {
                                    healthDamage = scanner.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Введені символи не є цілим числом, спробуйте ще раз:");
                                    scanner.nextLine();
                                }
                            }
                            if (healthDamage<=10&&healthDamage>=0){
                                break;
                            }
                            else {
                                System.out.println("Помилка! Число знаходиться не в межах від 1 до 10.");
                            }
                        }
                        int attractiveness = 0;
                        while (true){
                            System.out.print("Введіть привабливість по шкалі від 0 до 10: ");
                            while (true) {
                                try {
                                    attractiveness = scanner.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Введені символи не є цілим числом, спробуйте ще раз:");
                                    scanner.nextLine();
                                }
                            }
                            if (attractiveness<=10&&attractiveness>=0){
                                break;
                            }
                            else {
                                System.out.println("Помилка! Число знаходиться не в межах від 1 до 10.");
                            }
                        }
                        int quality = 0;
                        while (true){
                            System.out.print("Введіть якість по шкалі від 0 до 10: ");
                            while (true) {
                                try {
                                    quality = scanner.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Введені символи не є цілим числом, спробуйте ще раз:");
                                    scanner.nextLine();
                                }
                            }
                            if (quality<=10&&quality>=0){
                                break;
                            }
                            else {
                                System.out.println("Помилка! Число знаходиться не в межах від 1 до 10.");
                            }
                        }
                        int brightness = 0;
                        while (true){
                            System.out.print("Введіть яркість по шкалі від 0 до 10: ");
                            while (true) {
                                try {
                                    quality = scanner.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Введені символи не є цілим числом, спробуйте ще раз:");
                                    scanner.nextLine();
                                }
                            }
                            if (brightness<=10&&brightness>=0){
                                break;
                            }
                            else {
                                System.out.println("Помилка! Число знаходиться не в межах від 1 до 10.");
                            }
                        }

                        arr[i] = new Cosmetic(price, healthDamage, attractiveness, quality, brightness);
                        arr[i] = new Cosmetic();
                    } else {
                        System.out.println("Ви ввели не правильне значення");
                    }
                }
            }
        }

        Cosmetic pomada = new Cosmetic();
        Cosmetic c2 = new Cosmetic(10, 3, 7, 5, 9);
        System.out.println(pomada.price_in_$);

    }
}