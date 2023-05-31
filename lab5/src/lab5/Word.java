package lab5;

import java.util.ArrayList;
import java.util.List;

public class Word {
    private final String stringWord;
    private final List<Letter> letters;

    public Word(String stringWord) {
        List<Letter> letters = new ArrayList<>();
        char[] chars = stringWord.toCharArray();
        for (char c : chars) {
            letters.add(new Letter(c));
        }
        this.letters = letters;
        this.stringWord = stringWord;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public String getStringWord() {
        return stringWord;
    }

}
