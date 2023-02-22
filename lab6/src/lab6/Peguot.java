package lab6;

public class Peguot extends Car {

    public String mark = "Peguot";

    public Peguot(String _model, float speed, int price, int year, float fuel, float engineCapacity, String country) {
        super(_model, speed, price, year, fuel, engineCapacity, country);
    }

    @Override
    public void printValues() {
        System.out.println("Марка: Peguot");
        super.printValues();
    }

}
