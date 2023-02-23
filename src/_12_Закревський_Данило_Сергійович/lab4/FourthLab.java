import java.util.Arrays;

public class FourthLab {

    public static void main(String[] args) {
        final Airplane plane1 = new Airplane("Boeing 747", "passenger", 180, 4, 1970, "Lightblue", 467, 70);
        final Airplane plane2 = new Airplane("Airbus A380", "passenger", 575, 4, 2003, "Orange", 850, 389);
        final Airplane plane3 = new Airplane("General Dynamics F-16", "military", 9, 1, 1974, "Grey", 1, 45);
        final Airplane plane4 = new Airplane("Boeing C-17 Globemaster III", "cargo", 130, 4, 1995, "Grey", 102, 340);
        final Airplane plane5 = new Airplane("An-225 Mriya", "cargo", 285, 6, 1990, "White", 20, 500);
        Airplane[] planes = {plane1, plane2, plane3, plane4, plane5};

        System.out.println("List of planes: ");
        for(Airplane plane : planes) {
            System.out.println(plane);
        }
        System.out.println();

        Arrays.sort(planes, new SortByPrice());
        System.out.println("Sorted by price: ");  
        for(Airplane plane : planes) {
            System.out.println(plane);
        }
        System.out.println();

        Arrays.sort(planes, new SortByYear().reversed());
        System.out.println("Sorted by year: ");
        for(Airplane plane : planes) {
            System.out.println(plane);
        }
    }
}
