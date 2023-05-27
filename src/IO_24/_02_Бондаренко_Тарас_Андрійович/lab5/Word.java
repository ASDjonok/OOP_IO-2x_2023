package IO_24._02_Бондаренко_Тарас_Андрійович.lab5;

public class Word implements SentenceElement {
    private final Letter[] letters;

    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Letter let : letters) {
            out.append(let.toString());
        }
        return out.toString();
    }
}
