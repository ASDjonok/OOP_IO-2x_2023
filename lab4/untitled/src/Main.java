import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<SeaShip> ships = createList();

        printList(ships);

        ships = sortList(ships);

        System.out.println("==============================");

        printList(ships);
    }

    private static ArrayList<SeaShip> createList() {
        ArrayList<SeaShip> ships = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++)
            ships.add(new SeaShip("name" + (i + 1), "class" + (i + 1), "type" + (i + 1),
                    random.nextInt(10000) + 1000, random.nextDouble() * 100 + 20,
                    random.nextInt(10000) + 1000, random.nextDouble() * 100));

//        ships.add(new SeaShip("nameA", "classA", "typeA",
//                random.nextInt(10000) + 1000, 100d,
//                random.nextInt(10000) + 1000, 120d));
//        ships.add(new SeaShip("nameA", "classA", "typeA",
//                random.nextInt(10000) + 1000, 100d,
//                random.nextInt(10000) + 1000, 130d));
//        ships.add(new SeaShip("nameA", "classA", "typeA",
//                random.nextInt(10000) + 1000, 100d,
//                random.nextInt(10000) + 1000, 140d));
//        ships.add(new SeaShip("nameA", "classA", "typeA",
//                random.nextInt(10000) + 1000, 120d,
//                random.nextInt(10000) + 1000, 120d));
//        ships.add(new SeaShip("nameA", "classA", "typeA",
//                random.nextInt(10000) + 1000, 120d,
//                random.nextInt(10000) + 1000, 100d));

        return ships;
    }

    private static List<SeaShip> sortList(List<SeaShip> list) {
        Comparator<SeaShip> comparator = Comparator.comparing(SeaShip::getLength).reversed()
                .thenComparing(SeaShip::getMaxSpeed);

        list.sort(comparator);

        return list;
    }

    private static void printList(List<SeaShip> list) {
        list.forEach(System.out::println);
    }
}
