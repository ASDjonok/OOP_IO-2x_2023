package lab6;

public class Main {
    public static void main(String[] args) {
        МузичнаКомпозиція музичнаКомпозиція = new МузичнаКомпозиція(40);
        МузичнаКомпозиція[] музичніКомпозиції = {
            new МузичнаКомпозиція(60),
            new Jazz(670),
            new Pop(670),
            new Rock(670),
        };
        музичнаКомпозиція = new Jazz(670);
        System.out.println(музичнаКомпозиція.getClass().getSimpleName());
        System.out.println("Done!");
    }
}
