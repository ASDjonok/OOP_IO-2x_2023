import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Train {
    private List<PassengerCarriage> carriages;

    public Train(List<PassengerCarriage> carriages) {
        this.carriages = carriages;
    }

    public int getTotalPassengerCount() {
        int totalPassengerCount = 0;
        for (PassengerCarriage carriage : carriages) {
            totalPassengerCount += carriage.getPassengerCount();
        }
        return totalPassengerCount;
    }

    public int getTotalLuggageCount() {
        int totalLuggageCount = 0;
        for (PassengerCarriage carriage : carriages) {
            totalLuggageCount += carriage.getLuggageCount();
        }
        return totalLuggageCount;
    }

    public void sortCarriagesByComfortLevel() {
        Collections.sort(carriages, new Comparator<PassengerCarriage>() {
            @Override
            public int compare(PassengerCarriage c1, PassengerCarriage c2) {
                return c1.getComfortLevel() - c2.getComfortLevel();
            }
        });
    }

    public PassengerCarriage findCarriageByPassengerCount(int minPassengers, int maxPassengers) {
        for (PassengerCarriage carriage : carriages) {
            int passengerCount = carriage.getPassengerCount();
            if (passengerCount >= minPassengers && passengerCount <= maxPassengers) {
                return carriage;
            }
        }
        return null;
    }
}

class PassengerCarriage {
    private int passengerCount;
    private int luggageCount;
    private int comfortLevel;

    public PassengerCarriage(int passengerCount, int luggageCount, int comfortLevel) {
        this.passengerCount = passengerCount;
        this.luggageCount = luggageCount;
        this.comfortLevel = comfortLevel;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public int getLuggageCount() {
        return luggageCount;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }
}

public class Lab6 {
    public static void main(String[] args) {
        // Задаємо характеристики вагонів
        List<PassengerCarriage> carriages = new ArrayList<>();
        carriages.add(new PassengerCarriage(30, 64, 3));
        carriages.add(new PassengerCarriage(53, 126, 2));
        carriages.add(new PassengerCarriage(89, 164, 1));

        Train train = new Train(carriages);

        int totalPassengerCount = train.getTotalPassengerCount();
        int totalLuggageCount = train.getTotalLuggageCount();

        System.out.println("Кількість всіх пасажирів: " + totalPassengerCount);
        System.out.println("Кількість всього багажу: " + totalLuggageCount);

        train.sortCarriagesByComfortLevel();

        System.out.println("Вагони відсортовані за рівнем комфорту:");
        for (PassengerCarriage carriage : carriages) {
            System.out.println("Кількість пасажирів: " + carriage.getPassengerCount() +
                    ", Рівень комфорту: " + carriage.getComfortLevel());
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть мінімальну кількість пасажирів: ");
        int minPassengers = scanner.nextInt();
        System.out.print("Введіть максимальну кількість пасажирів: ");
        int maxPassengers = scanner.nextInt();

        PassengerCarriage carriage = train.findCarriageByPassengerCount(minPassengers, maxPassengers);

        if (carriage != null) {
            System.out.println("Вагон знайдений за кількість пасажирів між " +
                    minPassengers + " та " + maxPassengers);
            System.out.println("Кількість пасажирів: " + carriage.getPassengerCount() +
                    ", Рівень комфорту: " + carriage.getComfortLevel());
        } else {
            System.out.println("Вагон не знайдений за кількістю пасажирів " +
                    minPassengers + " між " + maxPassengers);
        }
    }
}