
import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {

    public static void main(String[] args) {
        // Вмикаємо прибори
        TurnOn();
        // Виводимо відомості про систему
        String totalPower = Integer.toString(ElectroAppliance.getTotalPower());
        System.out.println("Загальна споживана потужість:" + totalPower + " Вт");
        String totalWater = Integer.toString(WashingMashines.getTotalWaterConsumption());
        System.out.println("Загальна споживана вода:" + totalWater + " Л");
        String totalHeat = Integer.toString(HeatingDevices.getTotalHeatTransfer());
        System.out.println("Загальне виділення тепла:" + totalHeat + " Дж");
        String totalMech = Integer.toString(MechanicDevices.getTotalMechanicPower());
        System.out.println("Загальн механічна потужність:" + totalMech + " Вт");
        System.out.println("-------------------------");
        //Виводимо сортовані потужності
        ElectroAppliance.printSortedPowers();
        System.out.println("-------------------------");
        //Виводимо електромагнітні випромінювання в шуканому діапазоні
        ElectroAppliance.printDiapasonedElectromagneticRadiation(getLimits());
    }

    public static void TurnOn() {

        if (AskTrueOrFalse("Ввімкнути в розетку посудомийну машину(введіть так або ні)?")) {
            WashingMashines DishWasher = new WashingMashines(11, 1000, 30, "Посудомийна машина");

        }
        if (AskTrueOrFalse("Ввімкнути в розетку пральну машину(введіть так або ні)?")) {
            WashingMashines ClothesWasher = new WashingMashines(50, 2000, 10, "Пральна машина");
        }
        if (AskTrueOrFalse("Ввімкнути в розетку мікрохвильовку(введіть так або ні)?")) {
            HeatingDevices MicroWawe = new HeatingDevices(2000, 1100, 10000, "Мікрохвильвка");
        }
        if (AskTrueOrFalse("Ввімкнути в розетку духову піч(введіть так або ні)?")) {
            HeatingDevices Oven = new HeatingDevices(1000, 800, 1000, "Духова піч");
        }
        if (AskTrueOrFalse("Ввімкнути в розетку блендер(введіть так або ні)?")) {
            MechanicDevices Blender = new MechanicDevices(200, 400, 1, "Блендер");
        }
        if (AskTrueOrFalse("Ввімкнути в розетку пилосос(введіть так або ні)?")) {
            MechanicDevices VacuumCleaner = new MechanicDevices(50, 300, 3, "Пилосос");
        }
        /**
         * Цей метод створений для того, щоб запитати у користувача, які він прилади хоче ввімкнути в розетку і потім,
         *          якщо відповідь буде позитивна, створює об'єект цього класу.
         */
    }
    public static int[] getLimits(){
        int[] limits = new int[2];
        while (true) {
            int low = 0;
            System.out.println("Введіть нижню границю пошуку");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                try {
                    low = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Введені символи не є цілим числом, спробуйте ще раз.");
                    scanner.nextLine();
                }
            }
            System.out.println("Введіть нижню границю пошуку");
            int top = 0;
            while (true) {
                try {
                    top = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Введені символи не є цілим числом, спробуйте ще раз.");
                    scanner.nextLine();
                }
            }
            if (top >= low) {
                limits[0]=low;
                limits[1]=top;
                break;
            } else {
                System.out.println("Нижня границя більна верхньої");
            }
        }

        return limits;
        /**
         * Цей метод створений для того, щоб запитати у користувача нижню і верхню границю пошуку, і при цьому оброботи
         *         всі можливі помилки, такі як ввід не цілого числа, та перевищення нижньої границі верхньої
         */
    }
    public static boolean AskTrueOrFalse(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        boolean x = true;
        while (true) {
            String anwser = scanner.nextLine();
            if (anwser.equalsIgnoreCase("так")) {
                x = true;
                break;
            } else if (anwser.equalsIgnoreCase("ні")) {
                x = false;
                break;
            } else {
                System.out.println("Ви ввели не правильний текст, спробуйте ще раз");
            }
        }
        return x;
    }
    /**
     * Цей метод створений для того, щоб запитати у користвуча відповідь так або ні. Він приймає текстовий аргумент,
     *      виводить його на екран і очікує ввід. Потім він перевіряє відповіть на рівність "так" або "ні"
     *      і повертає значення true або false.
     */
}
