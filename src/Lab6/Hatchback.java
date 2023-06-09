package Lab6;

public class Hatchback extends Car {
    private int numberOfDoors;
    // Клас Hatchback має додаткову властивість - кількість дверей
    public Hatchback(String make, String model, int year, int price, int speed,  double fuelConsumption, int numberOfDoors) {
        super(make, model, year, price, speed, fuelConsumption);
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("Doors: %-10d |" , numberOfDoors); // додаємо до супер-методу нову властивість
    }
}
