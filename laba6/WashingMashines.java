public class WashingMashines extends ElectroAppliance {
    // Поля похідного класу Washing Machines
    private int waterConsumption;
    private static int totalWaterConsumption = 0;
    // Конструктор який задає поля і шукає загальне споживання води
    public WashingMashines(int waterConsumption, int power, int electromagneticRadiation, String name) {
        super(power, electromagneticRadiation, name);
        this.waterConsumption = waterConsumption;
        totalWaterConsumption = totalWaterConsumption + waterConsumption;
    }
    // Метод що повертає загальне споживання води
    public static int getTotalWaterConsumption() {
        return totalWaterConsumption;
    }
    /** Похідний класу електроприбору, який ще має поле споживання води */
}

