import java.util.ArrayList;


public class ElectroAppliance {
    // Поля що містять потужність, електромагнітне випромінювання та назву
    private int power;
    private int electromagneticRadiation;
    private String name;
    // Статичні поля, які потрібні для зберігання даних про всі об'єкти класу
    private static int totalPower = 0;
    private static ArrayList<Integer> sortedPowers = new ArrayList<Integer>();
    private static ArrayList<String> sortedNames = new ArrayList<String>();
    private static ArrayList<Integer> electromagneticList = new ArrayList<Integer>();
    private static ArrayList<String> namesList = new ArrayList<String>();


    public ElectroAppliance(int power, int electromagneticRadiation, String name) {
        // Присвоюємо полям значення
        this.name = name;
        this.power = power;
        this.electromagneticRadiation = electromagneticRadiation;
        // Додаємо потужність до загальної
        totalPower = totalPower + power;
        // Додаємо дані про електромагнітне випромінювання
        electromagneticList.add(electromagneticRadiation);
        namesList.add(name);
        // Відразу в конструкторі сортуємо список з потужностями
        if (sortedPowers.isEmpty()) {
            sortedPowers.add(power);
            sortedNames.add(name);
        } else {
            for (int i = sortedNames.size()-1; i>=0; i=i-1) {
                if(power>sortedPowers.get(i)){
                    sortedPowers.add(i+1, power);
                    sortedNames.add(i+1, name);
                } else if(i==0&&power<=sortedPowers.get(i)){
                    sortedPowers.add(0, power);
                    sortedNames.add(0, name);
                }
            }
        }

    }

    public static void printSortedPowers(){
        for(int i = 0; i<sortedNames.size(); i=i+1){
            System.out.println(sortedNames.get(i)+": "+ Integer.toString(sortedPowers.get(i))+" Вт");
        }
        /** Метод повертає відсортований список приборів по потужності */
    }

    public static int getTotalPower() {
        return totalPower;
        /** Метод повертає загальну потужність*/
    }
    public static void printDiapasonedElectromagneticRadiation(int[] limits){
        // Втсановлюємо границі з отриманого списку
        int top = limits[1];
        int bottom = limits[0];
        // Створюємо списки з кінцевими значеннями
        ArrayList<Integer> wantedElectromagneticRadiation = new ArrayList<Integer>();
        ArrayList<String> wantedElectromagneticNames = new ArrayList<String>();
        // Відбираємо потрібні значення
        for (int i = 0; i<=electromagneticList.size()-1; i=i+1){
            if(electromagneticList.get(i)<=top&&electromagneticList.get(i)>=bottom){
                wantedElectromagneticRadiation.add(electromagneticList.get(i));
                wantedElectromagneticNames.add(namesList.get(i));
            }
        }
        // Виводимо
        System.out.println("Шуканий список:");
        for (int i = 0; i<=wantedElectromagneticRadiation.size()-1; i=i+1){
            System.out.println(wantedElectromagneticNames.get(i)+": " +Integer.toString(wantedElectromagneticRadiation.get(i))+" Вт");
        }
        /** Метод шукає значення випромінювання в данному діапазоні і виводить ці значення */
    }
    /** Клас елктроприладів, який має може повертати відсортований список приладів по потужності, загальну потужність і
     * електромагнітне випромінювання в данному діапазоні
     */
}
