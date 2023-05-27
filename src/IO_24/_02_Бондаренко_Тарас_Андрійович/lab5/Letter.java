package IO_24._02_Бондаренко_Тарас_Андрійович.lab5;

public class Letter {
    private final char character;

    public Letter(char character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}
