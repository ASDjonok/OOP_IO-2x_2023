package lab4;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE - 1);
        /*final*/ Furniture/*<Furniture>*/ furniture1 = new Furniture("A", 1, 1, 1, 1);
        final Furniture/*<String>*/ furniture2 = new Furniture("A", 2, 1, 1, 1);

//        furniture1 = null;

        System.out.println(furniture1.equals(furniture2));
        System.out.println(furniture1.hashCode());
        System.out.println(furniture2.hashCode());

        System.out.println(furniture1.compareTo(furniture2));
//        System.out.println(furniture1.compareTo("furniture2"));

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

//        furniture1.setAdditional(new Furniture("Y", 1, 1, 1, 0));
//        furniture2.setAdditional("new Furniture(\"Y\", 1, 1, 1, 0)");

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

        /*Arrays.sort(furnitureArray);
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }

        System.out.println("+++++++++++++");*/

        /*Arrays.sort(furnitureArray, new PriceFurnitureComparator());
        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }

        System.out.println("+++++++++++++");*/

        /*Arrays.sort(furnitureArray, new Comparator<Furniture>() {
            @Override
            public int compare(Furniture o1, Furniture o2) {
                return o1.getMaterial().compareTo(o2.getMaterial());
            }
        });*/
//        Arrays.sort(furnitureArray, (o1, o2) -> o1.getMaterial().compareTo(o2.getMaterial()));
//        Arrays.sort(furnitureArray, Comparator.comparing(Furniture::getMaterial));
//        Arrays.sort(furnitureArray, Comparator.comparing(Furniture::getMaterial).reversed());
//        Arrays.sort(furnitureArray, Comparator.comparing(Furniture::getPrice)
//        .thenComparing(Furniture::getMaterial).reversed());
        Arrays.sort(furnitureArray, Comparator.comparing(Furniture::getPrice)
                .thenComparing(Comparator.comparing(Furniture::getMaterial).reversed()));

        for (Furniture furniture : furnitureArray) {
            System.out.println(furniture);
        }

        System.out.println("+++++++++++++");
    }
}
