package lab5;

public class Word {
    private Letter[] letters;

    public Word(Letter[] letters) {
        this.letters = letters;
    }

    public Word(String wordString) {
        letters = new Letter[wordString.length()];

        final char[] chars = wordString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            letters[i] = new Letter(chars[i]);
        }
    }
}
