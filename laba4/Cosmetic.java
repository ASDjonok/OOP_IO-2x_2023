import java.util.Random;
public class Cosmetic {
    public String name;
    public int price_in_$;
    public int health_damage_from1to10;
    public int attractiveness_from1to10;
    public int quality_from1to10;
    public int brightness_from1to10;


    public Cosmetic(String name) {
        Random random = new Random();
        this.name= name;
        this.price_in_$ = random.nextInt(1000) + 1;;
        this.health_damage_from1to10 = random.nextInt(11);
        this.attractiveness_from1to10 = random.nextInt(11);
        this.quality_from1to10 = random.nextInt(11);
        this.brightness_from1to10 = random.nextInt(11);
    }

    public Cosmetic(String name, int price_in_$, int health_damage_from1to10, int attractiveness_from1to10, int quality_from1to10, int brightness_from1to10) {
        this.name= name;
        this.price_in_$ = price_in_$;
        this.health_damage_from1to10 = health_damage_from1to10;
        this.attractiveness_from1to10 = attractiveness_from1to10;
        this.quality_from1to10 = quality_from1to10;
        this.brightness_from1to10 = brightness_from1to10;
    }
    public int getPrice_in_$() {
        return price_in_$;
    }
    public int getHealth_damage_from1to10() {
        return health_damage_from1to10;
    }
    public int getAttractiveness_from1to10() {
        return attractiveness_from1to10;
    }
    public int getQuality_from1to10() {
        return quality_from1to10;
    }
    public int getBrightness_from1to10() {
        return brightness_from1to10;
    }
    public String getName() {
        return name;
    }
}