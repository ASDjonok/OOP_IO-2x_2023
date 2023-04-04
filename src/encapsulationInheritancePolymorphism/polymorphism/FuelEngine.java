package encapsulationInheritancePolymorphism.polymorphism;

public class FuelEngine extends Engine {
    private String fuelType;

    @Override
    public int getPower() {
        return 50;
    }
}
