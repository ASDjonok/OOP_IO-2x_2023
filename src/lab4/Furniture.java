package lab4;

/**
 * My class Furniture.
 */
public class Furniture {
    /**
     *
     */
    private String material;
    private int length;
    private int height;
    private int width;
    private int price;

    /**
     *
     * @param material
     * @param length
     * @param height
     * @param width
     * @param price
     */
    public Furniture(String material, int length, int height, int width, int price) {
        this.material = material;
        this.length = length;
        this.height = height;
        this.width = width;
        this.price = price;
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
}
