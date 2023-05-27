package IO_24._02_Бондаренко_Тарас_Андрійович.lab5;

public class Punctuation implements SentenceElement {
    private final String character;

    public Punctuation(String character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return character;
    }
}
