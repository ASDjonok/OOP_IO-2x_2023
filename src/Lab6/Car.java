package Lab6;

import java.util.Comparator;

/**
 * Абстрактний клас Car представляє основні властивості автомобіля
 * Він містить конструктор для ініціалізації властивостей автомобіля,
 * а також методи доступу до цих властивостей.
 */
public abstract class Car {
    private final String make;           // Марка автомобіля
    private final String model;          // Модель автомобіля
    private final int year;              // Рік випуску автомобіля
    private final int price;             // Ціна автомобіля
    private final int speed;             // Швидкість автомобіля
    private final double fuelConsumption;// Споживання палива автомобілем

    /**
     * Конструктор класу Car ініціалізує властивості автомобіля.
     *
     * @param make            марка автомобіля
     * @param model           модель автомобіля
     * @param year            рік випуску автомобіля
     * @param price           ціна автомобіля
     * @param speed           швидкість автомобіля
     * @param fuelConsumption споживання палива автомобілем
     */
    public Car(String make, String model, int year, int price, int speed, double fuelConsumption) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
        this.speed = speed;
        this.fuelConsumption = fuelConsumption;
    }
    // Звичайні геттери, тому їх сильно не розписував
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Перезаписаний метод toString для представлення об'єкту автомобіля у вигляді рядка.
     *
     * @return рядок, що містить всі властивості абстрактного автомобіля
     */
    @Override
    public String toString() {
        return String.format("%-10s | %-7s | %-6s | %-6d | %-5d | %-5s | ",
                make, model, year, price, speed, fuelConsumption);
    }
}

/**
 * Клас SortByFuelConsuming реалізує інтерфейс Comparator і використовується для порівняння автомобілів
 * за споживанням палива.
 */
class SortByFuelConsuming implements Comparator<Car> {
    /**
     * Метод compare порівнює два об'єкти Car за споживанням палива.
     * Він порівнює значення споживання палива для обох автомобілів.
     *
     * @param a перший автомобіль
     * @param b другий автомобіль
     * @return -1, 0 або 1, якщо перше значення менше, рівне або більше другого відповідно
     */
    public int compare(Car a, Car b) {
        return Double.compare(a.getFuelConsumption(), b.getFuelConsumption());
    }
}


  // Щоб реалізувати ієрархію я рішив використати абстрактний клас машини, який має всі базові якості машини
  // його нащадки мають додаткове поле, крім того різних типів
  // Клас SortByFuelConsuming є інтерфейсом Comparator і використовується для порівняння автомобілів
  // за споживанням палива.
  // повертає значення за яким потім буде сортуватися масив машин

