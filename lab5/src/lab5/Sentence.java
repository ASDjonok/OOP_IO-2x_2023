package lab5;

import java.util.ArrayList;
import java.util.List;

public class Sentence {
    private final List<Object> wordsAndPunctuations;

    public Sentence(String stringSentence) {
        List<Object> wordsAndPunctuations = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < stringSentence.length(); i++) {
            char ch = stringSentence.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                word.append(ch);
            } else if (Character.isWhitespace(ch)) {
                if (word.length() > 0) {
                    wordsAndPunctuations.add(new Word(word.toString()));
                    word.setLength(0);
                }
            } else if (String.valueOf(ch).matches(".*\\p{Punct}.*")) {
                if (word.length() > 0) {
                    wordsAndPunctuations.add(new Word(word.toString()));
                    word.setLength(0);
                }
                wordsAndPunctuations.add(new Punctuation(ch));
            }
        }

        if (word.length() > 0) {
            wordsAndPunctuations.add(new Word(word.toString()));
        }

        this.wordsAndPunctuations = wordsAndPunctuations;
    }

    public List<Object> getWordsAndPunctuations() {
        return wordsAndPunctuations;
    }


    public List<Word> extractWords() {
        List<Word> words = new ArrayList<>();
        for (Object element : getWordsAndPunctuations()) {
            if (element instanceof Word) {
                words.add((Word) element);
            }
        }
        return words;
    }

    public List<String> getStringWords() {
        List<String> wordStrings = new ArrayList<>();
        for (Word word : extractWords()) {
            wordStrings.add(word.getStringWord());
        }
        return wordStrings;
    }

}
