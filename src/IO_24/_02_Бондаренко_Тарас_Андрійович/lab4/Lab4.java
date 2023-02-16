package IO_24._02_Бондаренко_Тарас_Андрійович.lab4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lab4 {
    public static void main(String[] args) {
        List<Boat> boatList = Arrays.asList(
                new Boat("Row V. Wave", 150000, 50000, 25, "cutter"),
                new Boat("Dirty Oar", 250000, 40000, 15, "cutter"),
                new Boat("Tumeric", 450000, 100000, 45, "cutter"),
                new Boat("Life is Good", 350000, 20000, 5, "cutter")
        );

        boatList.sort(Comparator.comparing(Boat::getName));// comparing - method of Comparator interface
        System.out.println("Sorted by name:");
        printed(boatList);

        boatList.sort(Comparator.comparing(Boat::getPrice).reversed());
        System.out.println("\nSorted by price in reverse order:");
        printed(boatList);
    }

    public static void printed(List<Boat> boatList) {
        for (Boat boat : boatList) {
            System.out.println(boat);
        }
    }
}
