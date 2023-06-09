package Lab6;

public class Coupe extends Car {
    private final String bodyType;
    // Клас купе має додатковий тип який визначає тип кузова, або можна написати чи машина без криші чи з кришою
    public Coupe(String make, String model, int year, int price, int speed, double fuelConsumption, String bodyType) {
        super(make, model, year, price, speed, fuelConsumption);
        this.bodyType = bodyType;
    }

    public String getBodyType() {
        return bodyType;
    }

    @Override
    public String toString() {

        return super.toString()+ String.format("Type: %-10s  |" , bodyType); // викликаємо супер-метод, додаємо тип кузова
    }
}
