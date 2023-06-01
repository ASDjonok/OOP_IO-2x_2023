package lab4;


import java.util.Objects;

/**
 * My class Furniture.
 */
//todo uncomment /*<Furniture>*/
public /*abstract*/ class Furniture/*<T>*/ implements Comparable<Furniture> {

    /**
     * Material with which furniture was made of
     */
    private String material;
    private int length;
    private int height;
    private int width;
    private int price;

//    private T additional;

//    public void setAdditional(T additional) {
//        this.additional = additional;
//    }

    /**
     * Our class constructor.
     *
     * @param material Material with which furniture was made of
     * @param length
     * @param height
     * @param width
     * @param price
     */
    public Furniture(String material, int length, int height, int width, int price) {
//        this.material = material;
        setMaterial(material);
        this.length = length;
        this.height = height;
        this.width = width;
        this.price = price;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getPrice() {
        return price;
    }

    /*public Furniture() {

    }*/

    @Override
    public String toString() {
        return "Furniture{" +
                "material='" + material + '\'' +
                ", length=" + length +
                ", height=" + height +
                ", width=" + width +
                ", price=" + price +
                '}';
    }

//    @Override
//    public int compareTo(Object o) {
//        return /*this.*/price - ((Furniture) o).price;
////        return /*this.*/material.compareTo(((Furniture) o).material);
//    }

    @Override
    public int compareTo(Furniture o) {
        final int priceDifference = price - o.price;
        return priceDifference != 0
                ? priceDifference
//                : -material.compareTo(o.material);
                : o.material.compareTo(material);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Furniture furniture = (Furniture) o;
        return length == furniture.length && height == furniture.height && width == furniture.width
                && price == furniture.price && material.equals(furniture.material);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, length, height, width, price);
    }
}
