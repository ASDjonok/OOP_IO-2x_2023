package lab7;

public class CombatsCar extends Car {

    private final int crew;
    private final float weight;
    private final String country;

    public CombatsCar(String mark, String model, int price, int year, float fuel, int crew, float weight, String country) {
        super(mark, model, price, year, fuel);
        this.crew = crew;
        this.weight = weight;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void printValues() {
        super.printValues();
        System.out.println("--- Особливості бойової машини ---");
        System.out.println("Екіпаж: " + crew + " людей");
        System.out.println("Бойова маса: " + weight + "т");
        System.out.println("Країна-виробник: " + country);

    }

}
