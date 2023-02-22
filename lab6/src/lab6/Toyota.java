package lab6;

public class Toyota extends Car {

    public String mark = "Toyota";

    public Toyota(String _model, float speed, int price, int year, float fuel, float engineCapacity, String country) {
        super(_model, speed, price, year, fuel, engineCapacity, country);
    }

    @Override
    public void printValues() {
        System.out.println("Марка: Toyota");
        super.printValues();
    }

}
