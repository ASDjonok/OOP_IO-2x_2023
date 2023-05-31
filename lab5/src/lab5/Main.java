package lab5;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String inputText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam tempor dictum velit, vitae sollicitudin mauris facilisis et. Praesent mi odio, pretium eget sem ac, ultricies eleifend elit. Maecenas vulputate efficitur risus, a ornare lorem sollicitudin vitae. Pellentesque rhoncus posuere risus eu placerat. Maecenas luctus felis ac interdum sodales. Quisque nec est lectus.";

        // Створений Text об'єкт
        Text text = new Text(inputText);

        // Пошук у першому реченні слів, яких немає в наступних реченнях
        List<String> result = findUniqueWords(text);
        System.out.println("Unique words in the first sentence: " + result);
    }

    public static List<String> findUniqueWords(Text text) {
        if (text.getSentences().isEmpty()) {
            throw new IllegalArgumentException("Text must contain at least one sentence.");
        }

        Sentence firstSentence = text.getSentences().get(0);
        List<String> wordsInFirstSentence = firstSentence.getStringWords();

        Set<String> uniqueWords = new HashSet<>(wordsInFirstSentence);

        for (int i = 1; i < text.getSentences().size(); i++) {
            Sentence sentence = text.getSentences().get(i);
            List<String> wordsInCurrentSentence = sentence.getStringWords();

            wordsInCurrentSentence.forEach(uniqueWords::remove);
        }

        return new ArrayList<>(uniqueWords);
    }

}
