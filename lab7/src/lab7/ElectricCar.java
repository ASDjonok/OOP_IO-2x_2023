package lab7;

public class ElectricCar extends Car {

    private final float electricity;
    private final float chargingSpeed;

    public ElectricCar(String mark, String model, int price, int year, float electricity, int chargingSpeed) {
        super(mark, model, price, year);
        this.electricity = electricity;
        this.chargingSpeed = chargingSpeed;
    }

    public float getElectricity() {
        return electricity;
    }

    public void printValues() {
        super.printValues();
        System.out.println("-Особливості електрокару-");
        System.out.println("Споживання електроенергії: " + electricity + " кВт·год/100км");
        System.out.println("Швидкість зарядки (з 0% до 100%): " + chargingSpeed + " хв");
    }

}
