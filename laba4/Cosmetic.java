import java.util.Random;
public class Cosmetic {
    public int price_in_$;
    public int health_damage_from1to10;
    public int attractiveness_from1to10;
    public int quality_from1to10;
    public int brightness_from1to10;

    public Cosmetic() {
        Random random = new Random();
        this.price_in_$ = random.nextInt(1000) + 1;;
        this.health_damage_from1to10 = random.nextInt(11);
        this.attractiveness_from1to10 = random.nextInt(11);
        this.quality_from1to10 = random.nextInt(11);
        this.brightness_from1to10 = random.nextInt(11);
    }

    public Cosmetic(int price_in_$, int health_damage_from1to10, int attractiveness_from1to10, int quality_from1to10, int brightness_from1to10) {
        this.price_in_$ = price_in_$;
        this.health_damage_from1to10 = health_damage_from1to10;
        this.attractiveness_from1to10 = attractiveness_from1to10;
        this.quality_from1to10 = quality_from1to10;
        this.brightness_from1to10 = brightness_from1to10;
    }
}