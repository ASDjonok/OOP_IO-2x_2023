package encapsulationInheritancePolymorphism.polymorphism.enhanced;

public class ElectricEngine extends Engine {
    private String batteryType;
    private int chargeLevel = 9;
    private int criticalChargeLevel = 10;
    private float coefficientCriticalPowerCut = 0.1f;

    @Override
    public int getPower() {
        return chargeLevel > criticalChargeLevel
                ? super.getPower()
                : (int) (super.getPower() * coefficientCriticalPowerCut);
    }

    /*private class Engine {
        private int power;
    }*/
}
