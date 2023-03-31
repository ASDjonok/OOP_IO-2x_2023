package lab7;

public class SportsCar extends Car {

    private final int power;
    private final float speed;
    private final float engineCapacity;

    public SportsCar(String mark, String model, int price, int year, float fuel, int power, float speed, float engineCapacity) {
        super(mark, model, price, year, fuel);
        this.power = power;
        this.speed = speed;
        this.engineCapacity = engineCapacity;
    }

    public int getPrice() {
        return price;
    }

    public void printValues() {
        super.printValues();
        System.out.println("-Особливості спорткару-");
        System.out.println("Потужість: " + power + " кінських сил");
        System.out.println("Максимальна швидкість: " + speed + " км/год");
        System.out.println("Об'єм двигуна: " + engineCapacity + "л");
    }

}
