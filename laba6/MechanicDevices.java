public class MechanicDevices extends ElectroAppliance {
    // Поля похідного класу Mechanic Devices
    private int mechanicPower;
    private static int totalMechanicPower = 0;
    // Конструктор який дає значення полям і шукає загальну механічна потужність
    public MechanicDevices(int mechanicPower, int power, int electromagneticRadiation, String name) {
        super(power, electromagneticRadiation, name);
        this.mechanicPower = mechanicPower;
        totalMechanicPower = totalMechanicPower + mechanicPower;
    }
    // Метод, який повертає загальну механічну потужність

    public static int getTotalMechanicPower() {
        return totalMechanicPower;
    }
    /** Похідний класу електроприбору, який ще має поле механічної потужності */
}
