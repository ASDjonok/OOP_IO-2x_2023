package Lab4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Lab4 {
    int C11 = 2401 % 11; // 3 - Визначити клас літак, який складається як мінімум з 5-и полів.
    public static void main(String[] args) {
        Airplane[] airplanes = { // Створюємо масив літаків, можливості створити літак, який одразує літає неможливо,
                                 // що логічно
                new Airplane(1, "Boeing 747", "Airline 1", 20, 50000.0),
                new Airplane(2, "Airbus A320", "Airline 1", 300, 3000.0),
                new Airplane(3, "Embraer E190", "Airline 2", 1700, 2000.0),
                new Airplane(4, "Cessna 172", "Airline 3", 400, 1500.0),
                new Airplane(5, "Bombardier Global 6000", "Airline 1", 100, 800.0),
        };

        Scanner scanner = new Scanner(System.in); // Підключаємо Scanner
        boolean quit = false;
        while (!quit) {  // Нескінченний цикл поки користувач не введе 'q'

            System.out.print("\nEnter the field to sort by (number, model, capacity, fuelcapacity), 'fly' to fly airplane or enter 'q' to exit: ");
            String input = scanner.nextLine();
            // перевірка чи правильно введено слово
            if (!input.equals("number") && !input.equals("model") && !input.equals("capacity") && !input.equals("fuelcapacity") && !input.equals("q") && !input.equals("fly")) {
                System.out.println("Invalid field to sort by! Please enter 'number', 'model', 'capacity', 'fuelcapacity'.");
                continue;
            }
            // перевірка виходу з програми
            if (input.equals("q")) {
                quit = true;
                System.out.println("Closing program...");
                continue;
            }
            // перевірка, чи користувач хоче запустити літак
            if (input.equals("fly")){
                buildBoard(airplanes); // виводимо таблицю літаків, через функцію buildBoard
                System.out.print("Enter the airplane number to make it fly or land if it already fly: ");
                int airplaneNumber = scanner.nextInt();
                scanner.nextLine();

                // Знаходимо вибраний літак
                Airplane selectedAirplane = null;
                for (Airplane airplane : airplanes) {
                    if (airplane.getNumber() == airplaneNumber) {
                        selectedAirplane = airplane;
                        break;
                    }
                }
                // перевірка, якщо літає - садимо на землю, якщо в ангарі, то запускаємо в повітр'я
                if (selectedAirplane != null) {
                    if (selectedAirplane.isFlying()) {
                        selectedAirplane.land(); // викликаємо метод для посадки
                    } else {
                        selectedAirplane.takeOff(); // викликаємо метод для запуску
                    }
                } else {
                    System.out.println("No airplane found with the specified number.");
                }

                continue;
            }

            String field = input;
            System.out.print("Enter the sort order (asc or desc): "); // вибір користувачем сортування за спаданням
            String order = scanner.nextLine();                        // чи зростанням

            if (!order.equals("asc") && !order.equals("desc")) { // перевірка чи правильно введено символ
                System.out.println("Invalid sort order! Please enter 'asc' or 'desc'.");
                continue;
            }
            // "потужний" swtich
            Comparator<Airplane> comparator = switch (field) { // в залежності від введеного слова - певний метод сортування
                case "number" -> new SortByNumber();
                case "model" -> new SortByModel();
                case "capacity" -> new SortByCapacity();
                case "fuelcapacity" -> new SortByFuelCapacity();
                default -> null;
            };

            if (order.equals("desc")) {  // інвертуємо для зворотнього порядку
                comparator = comparator.reversed();
            }
            Arrays.sort(airplanes, comparator); // сортуємо літаки за результатами компоратора

            System.out.println("\nSorted by " + field + " (in " + order + "ending order):");
            buildBoard(airplanes); // виклик функції buildBoard

        }

    }
    public static void buildBoard(Airplane[] airplanes){ // Функція нічого не повертає, приймає на вхід масив літаків
        System.out.println(String.format("%n%-7s | %-25s | %-10s | %-6s | %12s | %-10s", "Number", "Model", "Airline", "Capacity", "Fuel Capcity", "Is flying"));
        System.out.println("---------------------------------------------------------------------------------------");
        for (Airplane airplane : airplanes) { // "потужний" цикл for, щоб зручно перебрати літаки
            System.out.println(airplane.toString()); // викликаємо метод toSring(), який є прикладом поліморфізму
        }
    }

}
