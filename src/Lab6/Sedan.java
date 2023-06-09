package Lab6;

public class Sedan extends Car {
    private int seatingCapacity;
    // У об'єктів класу седан особливим є кільість пасажирських місць
    public Sedan(String make, String model, int year,int price, int speed, double fuelConsumption, int seatingCapacity) {
        super(make, model, year, price, speed, fuelConsumption);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Seats: %-10d |" , seatingCapacity); // додаємо до супер-методу додаткову властивість
    }
}
