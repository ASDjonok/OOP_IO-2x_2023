package lab7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Використання пустого конструктора CarCollection
        CarCollection<SportsCar> sportsCars = new CarCollection<>();
        sportsCars.add(new SportsCar("Ferrari", "458 Italia", 230000, 2015, 9.8f, 562, 202, 4.5f));
        sportsCars.add(new SportsCar("Lamborghini", "Huracan", 260000, 2020, 9.5f, 640, 211, 5.2f));
        sportsCars.add(new SportsCar("Porsche", "911", 150000, 2018, 14.3f, 450, 191, 3.0f));
        sportsCars.add(new SportsCar("McLaren", "570S", 200000, 2017, 11.2f, 562, 204, 3.8f));
        sportsCars.add(new SportsCar("Aston Martin", "Vantage", 150000, 2021, 12.3f, 503, 195, 4.0f));

//        Сортування спорткарів за ціною
        System.out.println("~~~~~ Відсортовані спорткари за ціною ~~~~~");
        sportsCars.sort(Comparator.comparingInt(SportsCar::getPrice));

        for (int i = sportsCars.size() - 1; i >= 0; i--) {
            sportsCars.get(i).printValues();
            System.out.println();
        }

//        Використання конструктора CarCollection з передаванням в його лише один об'єкт
        CarCollection<CombatsCar> combatsCars = new CarCollection<>(new CombatsCar("Humvee", "M1114", 220000, 1995, 6.5f, 4, 5.5f, "США"));
        combatsCars.add(new CombatsCar("Puma", "IFV", 3500000, 2010, 10.7f, 6, 31f, "Німеччина"));
        combatsCars.add(new CombatsCar("Warrior", "IFV", 4500000, 1988, 12.4f, 3, 29f, "Великобританія"));
        combatsCars.add(new CombatsCar("ZBD", "05", 1200000, 2011, 9.4f, 4, 25f, "Китай"));
        combatsCars.add(new CombatsCar("VBCI", "IFV", 5000000, 2008, 10.7f, 8, 32f, "Франція"));

//        Пошук бойової машини за країною-виробником
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть країну-виробницю бойової машини: ");
        String userCountry = scanner.nextLine();

        System.out.println("Результати пошуку:\n");
        for (CombatsCar car : combatsCars) {
            if (car.getCountry().equals(userCountry)) {
                car.printValues();
            }
        }

        ArrayList<ElectricCar> electricCarsList = new ArrayList<>();
        electricCarsList.add(new ElectricCar("Tesla", "Model S", 80000, 2022, 21.5f, 45));
        electricCarsList.add(new ElectricCar("Chevrolet", "Bolt", 35000, 2021, 28.0f, 60));
        electricCarsList.add(new ElectricCar("Nissan", "Leaf", 32000, 2021, 24.0f, 40));
        electricCarsList.add(new ElectricCar("BMW", "i3", 45000, 2021, 19.5f, 30));
        electricCarsList.add(new ElectricCar("Hyundai", "Kona", 42000, 2022, 22.0f, 50));

//        Використання конструктора CarCollection з передаванням в його колекцію об'єктів
        CarCollection<ElectricCar> electricCars = new CarCollection<>(electricCarsList);

//        Пошук автомобіля по діапазону споживання електроенергії
        System.out.println("\nВведіть діапазон споживання електроенергії (кВт·год/100км):");
        System.out.print("від ");
        float electricityLowerLimit = scanner.nextFloat();
        System.out.print("до ");
        float electricityUpperLimit = scanner.nextFloat();

        System.out.println("Результати пошуку:\n");
        for (ElectricCar car : electricCars) {
            if (car.getElectricity() < electricityUpperLimit & car.getElectricity() > electricityLowerLimit) {
                car.printValues();
            }
        }

    }

}
