package encapsulationInheritancePolymorphism.polymorphism;

public class ElectricEngine extends Engine {
    private String batteryType;

    @Override
    public int getPower() {
        return 20;
    }

    /*private class Engine {
        private int power;
    }*/
}
