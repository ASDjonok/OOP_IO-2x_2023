
public class SeaShip {
    private String name;
    private String shipClass;
    private String type;
    private Integer weight;
    private Double length;
    private Integer power;
    private Double maxSpeed;

    public SeaShip(String name, String shipClass, String type,
                   Integer weight, Double length, Integer power, Double maxSpeed) {
        this.name = name;
        this.shipClass = shipClass;
        this.type = type;
        this.weight = weight;
        this.length = length;
        this.power = power;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShipClass() {
        return shipClass;
    }

    public void setShipClass(String shipClass) {
        this.shipClass = shipClass;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Sea ship '" + name + "', class: " + shipClass + ", type: " + type + ".\n" +
                "Weight: " + weight + "\n" +
                "Length: " + length + "\n" +
                "Engine power: " + power + "\n" +
                "Max speed: " + maxSpeed + "\n";
    }
}