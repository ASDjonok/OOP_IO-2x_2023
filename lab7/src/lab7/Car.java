package lab7;

public class Car {

    protected String mark;
    protected String model;
    protected int price;
    protected int year;
    protected float fuel;

    public Car(String mark, String model, int price, int year, float fuel) {
        setValues(mark, model, price, year, fuel);
    }

//    Цей конструктор був створений окремо для класу ElectricCar
    public Car(String mark, String model, int price, int year) {
        setValues(mark, model, price, year);
    }

    public void setValues(String mark, String model, int price, int year, float fuel) {
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.year = year;
        this.fuel = fuel;
    }

    public void setValues(String mark, String model, int price, int year) {
        this.mark = mark;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    public void printValues() {
        System.out.println("Марка: " + mark);
        System.out.println("Модель: " + model + " " + year);
        System.out.println("Ціна: " + price + "$");
        System.out.println("Витрати палива: " + fuel + "л/100км");
    }

}
