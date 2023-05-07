public class HeatingDevices extends ElectroAppliance {
    // Поля похідного класу Heating Devices
    private int heatTransfer;
    private static int totalHeatTransfer = 0;
    // Конструктор який задає поля і шукає загальне випромінення тепла
    public HeatingDevices(int heatTransfer, int power, int electromagneticRadiation, String name) {
        super(power, electromagneticRadiation, name);
        this.heatTransfer = heatTransfer;
        totalHeatTransfer = totalHeatTransfer + heatTransfer;
    }
    // Повертає загальне випромінення тепла
    public static int getTotalHeatTransfer() {
        return totalHeatTransfer;
    }
    /** Похідний класу електроприбору, який ще має поле випромінення тепла*/
}
