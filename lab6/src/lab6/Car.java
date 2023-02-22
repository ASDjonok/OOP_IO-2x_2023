package lab6;

import java.util.Comparator;

public class Car {

    protected String _model;
    protected float speed;
    protected int price;
    protected int year;
    protected float fuel;
    protected float engineCapacity;
    protected String country;

    public Car(String _model, float speed, int price, int year, float fuel, float engineCapacity, String country) {
        setValues(_model, speed, price, year, fuel, engineCapacity, country);
        printValues();
    }

    public void setValues(String _m, float s, int p, int y, float f, float e, String c) {
        this._model = _m;
        this.speed = s;
        this.price = p;
        this.year = y;
        this.fuel = f;
        this.engineCapacity = e;
        this.country = c;
    }

    public void printValues() {
        System.out.println("Модель: " + _model + " " + year);
        System.out.println("Максимальна швидкість: " + speed + "км/год");
        System.out.println("Ціна: " + price + "$");
        System.out.println("Витрати палива: " + fuel + "л/100км");
        System.out.println("Об'єм двигуна: " + engineCapacity);
        System.out.println("Країна-виробник: " + country);
        System.out.println("~".repeat(40));
    }

}
