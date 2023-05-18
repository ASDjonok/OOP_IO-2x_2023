package lab4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        todo Comparable
        //todo equals+hashcode
//        todo JavaDoc
        final Furniture<Furniture> furniture1 = new Furniture<>("A", 1, 1, 1, 1);
        final Furniture<String> furniture2 = new Furniture<>("D", 1, 1, 1, 4);
        Furniture[] furnitureArray = {
                furniture1,
                furniture2,
            new Furniture("B", 1, 2, 1, 1),
            new Furniture("C", 1, 1, 3, 1),
        };

        for (Furniture furniture : furnitureArray) {
//            System.out.println(furniture.getMaterial() + " " + furniture.getPrice());
            System.out.println(furniture);
        }
        System.out.println("+++++++++++++");

        furniture1.setAdditional(new Furniture("Y", 1, 1, 1, 0));
        furniture2.setAdditional("new Furniture(\"Y\", 1, 1, 1, 0)");

//        furnitureArray[0].setMaterial("E");

        Arrays.sort(furnitureArray, (o1, o2) -> o1.getMaterial().compareTo(o2.getMaterial()));
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }

        System.out.println("+++++++++++++");

//        todo check
        Arrays.sort(furnitureArray, (o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice()));
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }

        System.out.println("+++++++++++++");
    }
}
