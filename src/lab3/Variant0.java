package lab3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Знайти найбільшу кількість речень заданого тексту, в яких є однакові слова.
 */
public class Variant0 {
    public static void main(String[] args) {
        System.out.println("\\");
        String textString = "Aa, a b. Bb a? B a! B a. Ccc.";
//        final String[] sentencesStrings = textString.split("(?<=(\\.|!|\\?)) ");
//        final String[] sentencesStrings = textString.split("(?<=[.!?]) ");
        final String[] sentencesStrings = textString.split("[.!?] ?");
        for (String sentencesString : sentencesStrings) {
            System.out.println("[" + sentencesString + "]");
        }
        System.out.println("++++++++++++");

        final String[][] wordsStringsBySentences = new String[sentencesStrings.length][];
        for (int i = 0; i < sentencesStrings.length; i++) {
            wordsStringsBySentences[i] = sentencesStrings[i].split(",? ");
        }

        for (String[] wordsStrings : wordsStringsBySentences) {
            for (String wordsString : wordsStrings) {
                System.out.print("[" + wordsString + "] - ");
            }
            System.out.println();
        }

        Set<String> originalWordsStrings = new HashSet();
        for (String[] wordsStrings : wordsStringsBySentences) {
            for (String wordsString : wordsStrings) {
                originalWordsStrings.add(wordsString.toLowerCase());
            }
        }
        final String[] originalWordsArray = originalWordsStrings.toArray(new String[0]);

        System.out.println("++++++++++++");
        for (Object originalWordsString : originalWordsStrings) {
            System.out.println(originalWordsString);
        }

        int[] entersQuantitiesOriginalWordsInSentences = new int[originalWordsArray.length];
        for (int i = 0; i < originalWordsArray.length; i++) {
            String originalWord = originalWordsArray[i];
            for (String[] words : wordsStringsBySentences) {
                for (String word : words) {
                    if (originalWord.equalsIgnoreCase(word)) {
                        entersQuantitiesOriginalWordsInSentences[i]++;
                        break;
                    }
                }
            }
        }

//        todo show greatest value from entersQuantitiesOriginalWordsInSentences

//        System.out.println(Arrays.toString(sentencesStrings));
        System.out.println("++++++++++++");
    }
}
