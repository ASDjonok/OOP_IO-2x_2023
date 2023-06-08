package lab5;

public class Main {
    public static void main(String[] args) {
        Word word = new Word("Hello");
        Word word2 = new Word(new Letter[]{
            new Letter('H'),
            new Letter('e'),
            new Letter('l'),
            new Letter('l'),
            new Letter('o'),
        });

        System.out.println(word.equals(word2));
        System.out.println(word == word2);

        System.out.println("Done!");
    }
}
