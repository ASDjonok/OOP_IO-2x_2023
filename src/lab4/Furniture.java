package lab4;

/**
 * My class Furniture.
 */
public class Furniture<T> {
    /**
     *
     */
    private String material;
    private int length;
    private int height;
    private int width;
    private int price;

    private T additional;

    public void setAdditional(T additional) {
        this.additional = additional;
    }

    /**
     *
     * @param material
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
}
