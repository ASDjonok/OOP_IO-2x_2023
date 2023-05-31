package IO_24._02_Бондаренко_Тарас_Андрійович.lab5;

import java.util.Arrays;
import java.util.HashSet;

public class Sentence {
    private final SentenceElement[] sentenceElements;
    private static final String PUNCTUATION = "\\p{Punct}";

    public Sentence(String sentences) {
        String[] sentenceElement = sentences.split("(?=" + PUNCTUATION + ")| ");
        sentenceElements = new SentenceElement[sentenceElement.length];
        for (int i = 0; i < sentenceElement.length; i++) {
            if (sentenceElement[i].matches(PUNCTUATION)) {
                sentenceElements[i] = new Punctuation(sentenceElement[i]);
            } else {
                sentenceElements[i] = new Word(sentenceElement[i]);
            }
        }
    }

    public static void getSortedWordsByFirstLetter(Sentence[] sentences) {
        StringBuilder allWords = new StringBuilder();
        for (Sentence sentence : sentences) {
            allWords.append(sentence).append(" ");
        }

        String[] words = allWords.toString().split("\\W+");

        HashSet<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }

        String[] uniqueSortedWords = uniqueWords.toArray(new String[0]);

        Arrays.sort(uniqueSortedWords);

        for (String word : uniqueSortedWords) {
            System.out.println(word);
        }
    }
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (SentenceElement se : sentenceElements) {
            if (se.getClass().isAssignableFrom(Word.class)) {
                out.append(" ");
            }
            out.append(se);
        }
        return out.toString();
    }
}
