package lab4;

import java.util.Comparator;

public class PriceFurnitureComparator implements Comparator<Furniture> {

    @Override
    public int compare(Furniture o1, Furniture o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
