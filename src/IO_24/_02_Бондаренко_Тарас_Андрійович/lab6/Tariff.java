package IO_24._02_Бондаренко_Тарас_Андрійович.lab6;

public class Tariff {
    private final String name;
    private final int price;
    private final int customers;

    public Tariff(String name, int price, int customers) {
        this.name = name;
        this.price = price;
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCustomers() {
        return customers;
    }

    @Override
    public String toString() {
        return "Тариф " + name + ", коштує " + price + " грн.";
    }
}
