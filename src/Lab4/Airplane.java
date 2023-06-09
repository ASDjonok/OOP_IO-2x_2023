package Lab4;

import java.util.Comparator;

public class Airplane {
    private int number; // Номер літака
    private String model; // Модель літака
    private String airline; // Компанія-власник
    private int capacity; // Ємність для пасажирів
    private double fuelCapacity; // Ємність палива
    private boolean isFlying; // Стан літака: летить/в ангарі

    // Конструктор класа
    public Airplane(int number, String model, String airline, int capacity, double fuelCapacity) {
        this.number = number;
        this.model = model;
        this.airline = airline;
        this.capacity = capacity;
        this.fuelCapacity = fuelCapacity;
        this.isFlying = false;
    }

    // Методи доступу, а саме геттери
    public int getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public String getAirline() {
        return airline;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    // Метод для запускання літака
    public void takeOff() {
        if (isFlying) { // Перевірка, якщо літає, то його знову не запустити,
            // у мому коді до цього уже є перевірка, але якщо наприклад розришяти
            // для інших програм, де перевірки не буде, то воно збереже від помилки
            System.out.println("The airplane is already flying.");
        } else {
            System.out.println("Taking off...");
            // Виводимо інформацію про взліт літака, міняємо прапор на 'true'
            isFlying = true;
            System.out.println("Airplane " + number + " took off!");
        }
    }

    // Метод для посадки літака
    public void land() {
        if (!isFlying) { // та сама перевірка, тільки для посадки
            System.out.println("The airplane is already on the ground.");
        } else {
            // садимо літак, пасажири плескають в долоні, а прапор 'false'
            System.out.println("Landing...");
            isFlying = false;
            System.out.println("Airplane number " + number + " landed!");
            System.out.println("Passengers: *claps*");
        }
    }

    // Перевизначений метод toString для виведення інформації про літак у зручному форматі
    @Override
    public String toString() {
        String flying = "In angar";
        if (isFlying) {
            flying = "Flying"; // друкувати стан прапора було би не естетично, тому перевіряємо 'true' - Flying
        }
        return String.format("%-7d | %-25s | %-10s | %-8d | %-12.1f | %-10s",
                number, model, airline, capacity, fuelCapacity, flying); // використовуємо метод .format для зручного виведення
    }
}

// Клас, що реалізує інтерфейс Comparator для порівняння літаків за номером
class SortByNumber implements Comparator<Airplane> {
    public int compare(Airplane a, Airplane b) {
        return a.getNumber() - b.getNumber();
    }
}

// Клас, що реалізує інтерфейс Comparator для порівняння літаків за моделлю
class SortByModel implements Comparator<Airplane> {
    public int compare(Airplane a, Airplane b) {
        return a.getModel().compareTo(b.getModel()); // Для типу String використовуємо метод compareTo
    }
}

// Клас, що реалізує інтерфейс Comparator для порівняння літаків за ємністю
class SortByCapacity implements Comparator<Airplane> {
    public int compare(Airplane a, Airplane b) {
        return a.getCapacity() - b.getCapacity();
    }
}

// Клас, що реалізує інтерфейс Comparator для порівняння літаків за ємністю палива
class SortByFuelCapacity implements Comparator<Airplane> {
    public int compare(Airplane a, Airplane b) {
        return Double.compare(a.getFuelCapacity(), b.getFuelCapacity()); // Для типу double застосовуємо відповідний метод
                                                                         // з абстрактного класу Double
    }
}
