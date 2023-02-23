import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class SixthLab {
    
    public static int sumOfPassangers(Train[] trains) {
        int sum = 0;
        for (Train train: trains) {
            sum += train.getCapacity();
        }
        return sum;
    }

    public static float sumOfLuggage(Train[] trains) {
        float sum = 0.0f;
        for (Train train: trains) {
            sum += train.getLuggage();
        }
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Intercity intercity = new Intercity(2, "intercity", 57, 2.0f);
        SV sv = new SV(3, "sv", 20, 1.3f);
        Compartment compartment = new Compartment(2, "compartment", 40, 2.5f);
        Plackart plackart = new Plackart(1, "plackart", 52, 1.8f);
        Train[] trainCars = {intercity, sv, compartment, plackart};

        System.out.println("List of train cars: ");
        for (Train car: trainCars) {
            System.out.println(car);
        }

        Arrays.sort(trainCars, new sortByComfort());
        System.out.println("\nSorted list by comfort level: ");
        for (Train car: trainCars) {
            System.out.println(car);
        }

        System.out.printf("\n\nThe total number of passengers on the train - %d.\n", sumOfPassangers(trainCars));
        System.out.printf("The total amount of train baggage - %.1f tons.", sumOfLuggage(trainCars));

        System.out.println("\n\nFinding the train car by number of passengers");
        System.out.print("Enter the lower number: ");
        int lower = scn.nextInt();
        System.out.print("Enter the extreme number: ");
        int extreme = scn.nextInt();
        boolean flag = false;
        for (Train car: trainCars) {
            int amount = car.getCapacity();
            if(amount >= lower && amount <= extreme) {
                System.out.println(car);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("There is no such train car");
        }
        scn.close();
    }
}

class Train {
    private int comfortLevel;
    private String type;
    private int capacity;
    private float luggage;

    public Train(int comfortLevel, String type, int capacity, float luggage) {
        this.comfortLevel = comfortLevel;
        this.type = type;
        this.capacity = capacity;
        this.luggage = luggage;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    public String getType() {
        return type;
    }
    
    public int getCapacity() {
        return capacity;
    }

    public float getLuggage() {
        return luggage;
    }

    @Override
    public String toString() {
        return "Train : " + 
                " Type: " + type +
                ". Comfort level: " + comfortLevel +
                ". Capacity: " + capacity + 
                ". Luggage: " + luggage + " tons.";
    }
}


class Intercity extends Train {

    public Intercity(int comfortLevel, String type, int capacity, float luggage) {
        super(comfortLevel, type, capacity, luggage);
    }
}

class SV extends Train {

    public SV(int comfortLevel, String type, int capacity, float luggage) {
        super(comfortLevel, type, capacity, luggage);
    }
}

class Compartment extends Train {

    public Compartment(int comfortLevel, String type, int capacity, float luggage) {
        super(comfortLevel, type, capacity, luggage);
    }
}

class Plackart extends Train {

    public Plackart(int comfortLevel, String type, int capacity, float luggage) {
        super(comfortLevel, type, capacity, luggage);
    }
}

class sortByComfort implements Comparator<Train> {
    
    public int compare(Train a, Train b){
        return a.getComfortLevel() - b.getComfortLevel();
    }
}
