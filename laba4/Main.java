import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
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
            System.out.println("Введіть назву об'єкта №" + (i + 1)+": ");
            String name = scanner.next();
            while (true) {

                System.out.println("Бажаєте заповнить об'єкт №" + (i + 1) + " випадковими значеннями?(Введіть так або ні)");
                String anwser = scanner.next();
                if (anwser.equalsIgnoreCase("так")) {
                    arr[i] = new Cosmetic(name);
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
                        while (true) {
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
                            if (healthDamage <= 10 && healthDamage >= 0) {
                                break;
                            } else {
                                System.out.println("Помилка! Число знаходиться не в межах від 0 до 10.");
                            }
                        }
                        int attractiveness = 0;
                        while (true) {
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
                            if (attractiveness <= 10 && attractiveness >= 0) {
                                break;
                            } else {
                                System.out.println("Помилка! Число знаходиться не в межах від 0 до 10.");
                            }
                        }
                        int quality = 0;
                        while (true) {
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
                            if (quality <= 10 && quality >= 0) {
                                break;
                            } else {
                                System.out.println("Помилка! Число знаходиться не в межах від 0 до 10.");
                            }
                        }
                        int brightness = 0;
                        while (true) {
                            System.out.print("Введіть яркість по шкалі від 0 до 10: ");
                            while (true) {
                                try {
                                    brightness = scanner.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Введені символи не є цілим числом, спробуйте ще раз:");
                                    scanner.nextLine();
                                }
                            }
                            if (brightness <= 10 && brightness >= 0) {
                                break;
                            } else {
                                System.out.println("Помилка! Число знаходиться не в межах від 0 до 10.");
                            }
                        }

                        arr[i] = new Cosmetic(name, price, healthDamage, attractiveness, quality, brightness);
                        break;

                    } else {
                        System.out.println("Ви ввели не правильне значення");
                    }
                }
            }
        }
        System.out.println("\n\n\n\n");
        System.out.println("Чудово! Масив з елементами класу створено!");
        System.out.println("Далі треба задати поля, по яким слід сортувати елементи");
        System.out.println("Для сортування по ціні введіть - 1");
        System.out.println("Для сортування по шкоді для здоров'я введіть - 2");
        System.out.println("Для сортування по привабливосты введіть - 3");
        System.out.println("Для сортування по якості введіть - 4");
        System.out.println("Для сортування по яркості введіть - 5\n");

        int num1 = 0;
        while (true) {
            System.out.print("Введіть поле масиву від 1 до 5 для сортуванням за зростанням: ");
            while (true) {
                try {
                    num1 = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Введені символи не є цілим числом, спробуйте ще раз:");
                    scanner.nextLine();
                }
            }
            if (num1 <= 5 && num1 >= 1) {
                break;
            } else {
                System.out.println("Помилка! Число знаходиться не в межах від 1 до 5.");
            }
        }
        int num2 = 0;
        while (true) {
            System.out.print("Введіть поле масиву від 1 до 5 для сортування за спаданням: ");
            while (true) {
                try {
                    num2 = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Введені символи не є цілим числом, спробуйте ще раз:");
                    scanner.nextLine();
                }
            }
            if (num2 <= 5 && num2 >= 1) {
                break;
            } else {
                System.out.println("Помилка! Число знаходиться не в межах від 1 до 5.");
            }
        }
        System.out.println("Масив відсортований за зростанням:");
        if (num1==1){
            Arrays.sort(arr, Comparator.comparingInt(Cosmetic::getPrice_in_$));
            for(Cosmetic i: arr){
                System.out.println(i.getName()+" - "+i.getPrice_in_$());
            }
        }
        else if(num1==2){
            Arrays.sort(arr, Comparator.comparingInt(Cosmetic::getHealth_damage_from1to10));
            for(Cosmetic i: arr){
                System.out.println(i.getName()+" - "+i.getHealth_damage_from1to10());
            }
        }
        else if(num1==3){
            Arrays.sort(arr, Comparator.comparingInt(Cosmetic::getAttractiveness_from1to10));
            for(Cosmetic i: arr){
                System.out.println(i.getName()+" - "+i.getAttractiveness_from1to10());
            }
        }
        else if(num1==4){
            Arrays.sort(arr, Comparator.comparingInt(Cosmetic::getQuality_from1to10));
            for(Cosmetic i: arr){
                System.out.println(i.getName()+" - "+i.getQuality_from1to10());
            }
        }
        else if(num1==5){
            Arrays.sort(arr, Comparator.comparingInt(Cosmetic::getBrightness_from1to10));
            for(Cosmetic i: arr){
                System.out.println(i.getName()+" - "+i.getBrightness_from1to10());
            }
        }
        System.out.println("Масив відсортований за спаданням:");
        if (num2==1){
            Arrays.sort(arr, Comparator.comparingInt(Cosmetic::getPrice_in_$).reversed());
            for(Cosmetic i: arr){
                System.out.println(i.getName()+" - "+i.getPrice_in_$());
            }
        }
        else if(num2==2){
            Arrays.sort(arr, Comparator.comparingInt(Cosmetic::getHealth_damage_from1to10).reversed());
            for(Cosmetic i: arr){
                System.out.println(i.getName()+" - "+i.getHealth_damage_from1to10());
            }
        }
        else if(num2==3){
            Arrays.sort(arr, Comparator.comparingInt(Cosmetic::getAttractiveness_from1to10).reversed());
            for(Cosmetic i: arr){
                System.out.println(i.getName()+" - "+i.getAttractiveness_from1to10());
            }
        }
        else if(num2==4){
            Arrays.sort(arr, Comparator.comparingInt(Cosmetic::getQuality_from1to10).reversed());
            for(Cosmetic i: arr){
                System.out.println(i.getName()+" - "+i.getQuality_from1to10());
            }
        }
        else if(num2==5){
            Arrays.sort(arr, Comparator.comparingInt(Cosmetic::getBrightness_from1to10).reversed());
            for(Cosmetic i: arr){
                System.out.println(i.getName()+" - "+i.getBrightness_from1to10());
            }
        }





    }
}