package IO_24._02_Бондаренко_Тарас_Андрійович.lab4;

/**
 * Class that represents a boat with different characteristics.
 */
public class Boat {
    private final String name;
    private final int price;
    private final int mass;
    private final int age;
    private final String type;

    public Boat(String name, int price, int mass, int age, String type) {
        this.name = name;
        this.price = price;
        this.mass = mass;
        this.age = age;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s - %s, which was built %d years ago, with mass - %d kg, has price - %d$;",
                type, name, age, mass, price);
    }
}
