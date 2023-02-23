import java.util.Comparator;

public class Airplane {
  private String name;
	private String type; 
	private int weight; 
  private int amountOfEngines;
  private int year; 
	private String color; 
	private int capacity;
  private int price; 
	

  public Airplane(String name, String type, int weight, int amountOfEngines, int year, String color, int capacity, int price) {
		this.name = name;
    this.type = type;
		this.weight = weight;
		this.amountOfEngines = amountOfEngines;
    this.year = year;
		this.color = color;
		this.capacity = capacity;
    this.price = price;
	}

  public int getPrice() {
      return price;
  }

  public int getYear() {
      return year;
  }

  @Override
  public String toString() {
      return "Plane : " +
              "name = " + name +
              ", type = " + type +
              ", weight = " + weight + " tons" +
              ", amount of engines = " + amountOfEngines +
              ", year = " + year + 
              ", color = " + color + 
              ", capacity = " + capacity + 
              ", price = " + price + " millions dollars.";
  }
}

class SortByPrice implements Comparator<Airplane> {
    
    public int compare(Airplane a, Airplane b) {
        return a.getPrice() - b.getPrice();
    }
} 

class SortByYear implements Comparator<Airplane> {

    public int compare(Airplane a, Airplane b) {
        return a.getYear() - b.getYear();
    }
}
