import java.util.Arrays;
import java.util.Comparator;

/**
 * Клас, що описує базовий рухомий склад залізничного транспорту.
 */
class RollingStock {
    private int number;

    public RollingStock(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

/**
 * Клас, що описує пасажирський вагон.
 */
class PassengerCarriage extends RollingStock {
    private int passengerCount;
    private int comfortLevel;

    public PassengerCarriage(int number, int passengerCount, int comfortLevel) {
        super(number);
        this.passengerCount = passengerCount;
        this.comfortLevel = comfortLevel;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }
}

/**
 * Клас, що описує вагон для багажу.
 */
class BaggageCarriage extends RollingStock {
    private int baggageCount;

    public BaggageCarriage(int number, int baggageCount) {
        super(number);
        this.baggageCount = baggageCount;
    }

    public int getBaggageCount() {
        return baggageCount;
    }
}

/**
 * Клас, що описує пасажирський потяг.
 */
class PassengerTrain {
    private RollingStock[] rollingStock;

    public PassengerTrain(RollingStock[] rollingStock) {
        this.rollingStock = rollingStock;
    }

    public int getTotalPassengerCount() {
        int totalPassengerCount = 0;
        for (RollingStock stock : rollingStock) {
            if (stock instanceof PassengerCarriage) {
                PassengerCarriage carriage = (PassengerCarriage) stock;
                totalPassengerCount += carriage.getPassengerCount();
            }
        }
        return totalPassengerCount;
    }

    public int getTotalBaggageCount() {
        int totalBaggageCount = 0;
        for (RollingStock stock : rollingStock) {
            if (stock instanceof BaggageCarriage) {
                BaggageCarriage carriage = (BaggageCarriage) stock;
                totalBaggageCount += carriage.getBaggageCount();
            }
        }
        return totalBaggageCount;
    }

    public void sortByComfortLevel() {
        Arrays.sort(rollingStock, new Comparator<RollingStock>() {
            @Override
            public int compare(RollingStock o1, RollingStock o2) {
                if (o1 instanceof PassengerCarriage && o2 instanceof PassengerCarriage) {
                    PassengerCarriage carriage1 = (PassengerCarriage) o1;
                    PassengerCarriage carriage2 = (PassengerCarriage) o2;
                    return carriage1.getComfortLevel() - carriage2.getComfortLevel();
                }
                return 0;
            }
        });
    }

    public RollingStock findCarriageByPassengerCountRange(int minPassengerCount, int maxPassengerCount) {
        for (RollingStock stock : rollingStock) {
            if (stock instanceof PassengerCarriage) {
                PassengerCarriage carriage = (PassengerCarriage) stock;
                if (carriage.getPassengerCount() >= minPassengerCount && carriage.getPassengerCount() <= maxPassengerCount) {
                    return carriage;
                }
            }
        }
        return null;
    }
}

/**
 * Головний клас програми.
 */
public class Main {
    public static void main(String[] args) {
        // Створення вагонів потягу
        RollingStock[] rollingStock = new RollingStock[5];
        rollingStock[0] = new PassengerCarriage(1, 40, 3);
        rollingStock[1] = new PassengerCarriage(2, 30, 2);
        rollingStock[2] = new BaggageCarriage(3, 50);
        rollingStock[3] = new PassengerCarriage(4, 20, 1);
        rollingStock[4] = new PassengerCarriage(5, 35, 2);

        // Створення пасажирського потягу
        PassengerTrain train = new PassengerTrain(rollingStock);

        // Розрахунок загальної кількості пасажирів та багажу в потязі
        int totalPassengerCount = train.getTotalPassengerCount();
        int totalBaggageCount = train.getTotalBaggageCount();
        System.out.println("Total passenger count: " + totalPassengerCount);
        System.out.println("Total baggage count: " + totalBaggageCount);

        // Сортування вагонів за рівнем комфортності
        train.sortByComfortLevel();
        System.out.println("Sorted carriages by comfort level:");

        for (RollingStock stock : rollingStock) {
            if (stock instanceof PassengerCarriage) {
                PassengerCarriage carriage = (PassengerCarriage) stock;
                System.out.println("Carriage " + carriage.getNumber() + ", Comfort Level: " + carriage.getComfortLevel());
            }
        }

        // Знаходження вагона з пасажирськими місцями в заданому діапазоні кількості пасажирів
        int minPassengerCount = 25;
        int maxPassengerCount = 40;
        RollingStock foundCarriage = train.findCarriageByPassengerCountRange(minPassengerCount, maxPassengerCount);
        if (foundCarriage != null) {
            System.out.println("Found carriage with passenger count in range (" + minPassengerCount + "-" + maxPassengerCount + "): " + foundCarriage.getNumber());
        } else {
            System.out.println("No carriage found with passenger count in range (" + minPassengerCount + "-" + maxPassengerCount + ")");
        }
    }
}
