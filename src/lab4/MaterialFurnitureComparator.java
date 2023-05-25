package lab4;

import java.util.Comparator;

public class MaterialFurnitureComparator implements Comparator<Furniture> {

    @Override
    public int compare(Furniture o1, Furniture o2) {
        return o1.getMaterial().compareTo(o2.getMaterial());
    }
}
