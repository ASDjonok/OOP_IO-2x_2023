import java.util.Scanner;

public class FifthLab {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scn.nextLine();
        StringBuilder textBuilder = new StringBuilder(text);
        StringBuilder result = new StringBuilder();

        System.out.print("Enter a string to replace the words: ");
        String replace = scn.nextLine();
        System.out.print("Enter the length of the words to replace: ");
        int length = scn.nextInt();
        
        System.out.println("\nText before changes: ");
        System.out.println(textBuilder);


        String[] mySentence = textBuilder.toString().split("(?<=[!.?])\\s?");
        for(String s: mySentence) {
            StringBuilder sb = new StringBuilder(s);
            Sentence sentence = new Sentence(sb, length, replace);
            result.append(sentence.wordsSplit());
        }

        System.out.println("\nText after changes: ");
        System.out.println(result);
        scn.close();
    }  
}

class Sentence {
    
    private final StringBuilder sentence;
    private final int length;
    private final String replace;

    public Sentence(StringBuilder sentence, int length, String replace) {
        this.sentence = sentence;
        this.length = length;
        this.replace = replace;
    }

    public StringBuilder wordsSplit() {
        StringBuilder ReturnSentence = new StringBuilder();
        String text = sentence.toString();
        String[] words = text.split(" ");
        for(String s: words) {
            StringBuilder sb = new StringBuilder(s);
            Word word = new Word(sb, length, replace);
            ReturnSentence.append(word.lettersSplit()).append(" ");
        }

        return ReturnSentence;
    }
}

class Word {

    private final StringBuilder word;
    private final int length;
    private final String replace;

    public Word(StringBuilder word, int length, String replace) {
        this.word = word;
        this.length = length;
        this.replace = replace;
    }

    public StringBuilder lettersSplit() {
        StringBuilder ReturnWord = new StringBuilder();
        String wordstr = word.toString();
        int len = wordstr.length();
        String[] letters = wordstr.split("");
        String[] ReplaceLetters = replace.split("");
        char last = wordstr.charAt(word.length() - 1);
        if(last == '!' || last == '?' || last == '.') {
            if(wordstr.charAt(word.length() - 2) == '.') {
                len = wordstr.length() - 3;
            } else {
                len = wordstr.length() - 1;
            }
        }
        if(len == length) {
            for(String chr: ReplaceLetters) {
                StringBuilder ltr = new StringBuilder(chr);
                Letter letter = new Letter(ltr);
                ReturnWord.append(letter.getLetter());
            }
            if(wordstr.length() - len == 1) {
                ReturnWord.append(wordstr.charAt(wordstr.length() - 1));
            } else if(wordstr.length() - len == 3) {
                ReturnWord.append("...");
            }
        } else {
            for(String chr: letters) {
                StringBuilder ltr = new StringBuilder(chr);
                if(chr.equals("!") || chr.equals("?") || chr.equals(".") || chr.equals(",") || chr.equals(":") || chr.equals(";")) {
                    Punctuation punctuation = new Punctuation(ltr);
                    ReturnWord.append(punctuation.getPunctuation());
                } else {
                    Letter letter = new Letter(ltr);
                    ReturnWord.append(letter.getLetter());
                }
            }
        }
        
        return ReturnWord;
    }
}

class Letter {

    private final StringBuilder letter;

    public Letter(StringBuilder letter) {
        this.letter = letter;
    }

    public StringBuilder getLetter() {
        return letter;
    }

}

class Punctuation {

    private final StringBuilder punctuation;

    public Punctuation(StringBuilder punctuation) {
        this.punctuation = punctuation;
    }

    public StringBuilder getPunctuation() {
        return punctuation;
    }
} 
