package lab4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //todo equals+hashcode
//        todo JavaDoc
        Furniture[] furnitureArray = {
             new Furniture("A", 1, 1, 1, 1),
                new Furniture("D", 1, 1, 1, 4),
                new Furniture("B", 1, 2, 1, 1),
                new Furniture("C", 1, 1, 3, 1),
        };

        Arrays.sort(furnitureArray, (o1, o2) -> o1.getMaterial().compareTo(o2.getMaterial()));
//        todo print

//        todo check
        Arrays.sort(furnitureArray, (o1, o2) -> Integer.compare(o2.getPrice(), o1.getPrice()));
    }
}
