package Lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaxiPark {

    private static List<Car> cars;

    public TaxiPark() {
        cars = new ArrayList<>();
    } // Створюємо у таксопарка масив машин

    public void addAutomobile(Car car) {cars.add(car);}  // Метод для додавання машини у таксопарк

    // Метод для додавання машини у таксопарк, але користувачем
    public void addAutomobileConsole(String carType, String maker, String model, int year, int price, int speed, double fuelConsumption, Object additionalProperty){
        Car car;
        switch (carType) { // Удосконалений switch для створення конкретного типу машини
            case "Coupe" ->
                    car = new Coupe(maker, model, year, price, speed, fuelConsumption, (String) additionalProperty); //
                    // Я придумав, що у купе поліморфізм виражається у тому, що вона може бути купе, без криші, туфелькою
                    // я дуже погано в машинах розбираюсь, тому надіюсь ви мене зрозуміли
            case "Hatchback", "Sedan" ->
                    car = new Hatchback(maker, model, year, price, speed, fuelConsumption, (int) additionalProperty);
            default -> {
                System.out.println("Invalid car type");
                return;
            }
        }
        addAutomobile(car); // Виклик метода для додаваня машини у таксопарк, можна було без нього,
                            // одною строкою, але так мені це показалось логічним

    }

    public double calculateFleetCost() { // Метод для обрахунку ціни усіх машин
        double totalCost = 0.0;
        for (Car car : cars) {
            totalCost += car.getPrice(); // Перебираємо усі машини, викликаємо у них метод getPrice()
        }
        return totalCost; // Повертаємо результат
    }

    public List<Car> findCarsBySpeedRange(int minSpeed, int maxSpeed) { // Метод для знаходження машин у діапазоні
        List<Car> carsInSpeedRange = new ArrayList<>();
        for (Car car : cars) {
            if (car.getSpeed() >= minSpeed && car.getSpeed() <= maxSpeed) {
                carsInSpeedRange.add(car); // Перебираємо машини, які задовольняються умові діапазону
            }
        }
        return carsInSpeedRange;
    }
    public void boardCars(List<Car> cars){ // Метод для будування таблиці, приймає масив машин, і створює красиву табличку
        System.out.println("----------------------------------------------------------------------------");
        System.out.printf("%-10s | %-7s | %-6s | %-6s | %-5s | %-5s | %-10s        | %n",
                "Maker", "Model", "Year", "Price", "Speed", "Fuel", "Special");
        System.out.println("----------------------------------------------------------------------------");
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println("----------------------------------------------------------------------------");
    }

    public void sortByFuelConsumption() { // Метод у таксопарка, який викликає клас для сортування

        cars.sort(new SortByFuelConsuming());
        boardCars(TaxiPark.cars); // будуємо відсортовану табличку
    }

    public static void main(String[] args) {
        int C13 = 2401 % 13;
        System.out.println("C13 - " + C13 + ", отже треба створити таксопар та ієрархію автомобілів.");
        System.out.println("--------------------------------------------------------------\n");

        TaxiPark taxiPark = new TaxiPark();

        // Додати автомобілі до таксопарку
        taxiPark.addAutomobile(new Sedan("Toyota", "Camry", 2020, 3500, 220, 7.5, 5));
        taxiPark.addAutomobile(new Coupe("BMW", "M4", 2021, 3000, 150, 9.2, "Coupe"));
        taxiPark.addAutomobile(new Hatchback("Volkswagen", "Golf", 2019, 6000, 200, 6.8, 6));

        Scanner scanner = new Scanner(System.in); // Під'єднуємо сканер
        boolean quit = false;
        while (!quit) {  // Нескінченний цикл поки користувач не введе 'q'

            System.out.print("""
                    Enter:
                    'cost' - show total fleet
                    'sort' - show cars sorted by fuel consumption
                    'board' - show cars
                    'add' - buy car on your TaxiPark
                    'find' - find cars that in speed diapason
                    or enter 'q' to exit:\s""");
            String input = scanner.nextLine();
            // Перевірка чи правильно введено слово
            if (!input.equals("cost") && !input.equals("sort") && !input.equals("board") && !input.equals("add") && !input.equals("q") && !input.equals("find")) {
                System.out.println("Invalid field to sort by! Please enter 'cost', 'sort', 'board', 'add', 'find'.");
                continue;
            }
            // Перевірка виходу з програми
            if (input.equals("q")) {
                quit = true;
                System.out.println("Closing program...");
                continue;
            }

            if (input.equals("cost")){
                // Порахувати вартість автопарку
                double fleetCost = taxiPark.calculateFleetCost(); // Викликаємо метод, який вже описав
                System.out.println("Total fleet cost: $" + fleetCost);
                continue;
            }

            if (input.equals("sort")){
                // Відсортувати автомобілі за витратами палива
                taxiPark.sortByFuelConsumption();
                continue;
            }
            if (input.equals("board")){
                taxiPark.boardCars(TaxiPark.cars); // Виведення таблички
                continue;

            }
            if (input.equals("find")){
                int minSpeed, maxSpeed;
                System.out.println("Enter min speed: "); // Користувач вводе межі діапазона
                minSpeed = scanner.nextInt();
                System.out.println("Enter max speed:");
                maxSpeed = scanner.nextInt();
                scanner.nextLine(); // Тут залишався \n тому ми його з'їли
                List<Car> carsInSpeedRange = taxiPark.findCarsBySpeedRange(minSpeed, maxSpeed); // Масив машин діапазону
                System.out.println("Cars within the speed range of " + minSpeed + " km/h to " + maxSpeed + " km/h:");
                taxiPark.boardCars(carsInSpeedRange); // Створенний масив передаємо методу для будування таблички


            }
            if (input.equals("add")){
                // Користувач вводе багато значень, перевірки не добавив, тому акуратно)
                System.out.println("Choose type of car: 'Sedan', 'Coupe', 'Hatchback'");
                String carType = scanner.nextLine();
                System.out.println("Enter Maker: ");
                String maker = scanner.nextLine();
                System.out.println("Enter Model: ");
                String model = scanner.nextLine();
                System.out.println("Enter year: ");
                int year = scanner.nextInt();
                System.out.println("Enter price (int)");
                int price = scanner.nextInt();
                System.out.println("Enter speed (int)");
                int speed = scanner.nextInt();
                System.out.println("Enter fuel consumption");
                double fuelConsumption = scanner.nextDouble();
                scanner.nextLine();
                Object additionalProperty = null; // Абстрактний об'єкт, далі в switch він набуде тип

                switch (carType) {
                    case "Sedan", "Hatchback" -> {
                        System.out.println("Enter special(int):");
                        additionalProperty = scanner.nextInt();
                    }

                    case "Coupe" -> {
                        System.out.println("Enter special(any):");
                        additionalProperty = scanner.nextLine();
                    }
                    default -> System.out.println("Invalid car type");
                }
                // Передаємо всі введені значення методу для купівлі машини у таксопарк
                taxiPark.addAutomobileConsole(carType, maker, model, year, price, speed, fuelConsumption, additionalProperty);

            }



        }



    }

}
