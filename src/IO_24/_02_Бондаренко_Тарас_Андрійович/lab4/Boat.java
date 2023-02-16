package IO_24._02_Бондаренко_Тарас_Андрійович.lab4;

public class Boat {
    private String name;
    private int price;
    private int mass;
    private int age;
    private String type;

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

    public int getMass() {
        return mass;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s - %s, which was built %d years ago, with mass - %d kg, has price - %d$;",
                type, name, age, mass, price);
    }
}
