package lab3;

import java.util.Arrays;

/**
 * Знайти найбільшу кількість речень заданого тексту, в яких є однакові слова.
 */
public class Variant0 {
    public static void main(String[] args) {
        String textString = "A, a. B a. B a. B a. C.";
        final String[] sentencesStrings = textString.split("\\. ?");
        for (String sentencesString : sentencesStrings) {
            System.out.println(sentencesString);
        }
//        System.out.println(Arrays.toString(sentencesStrings));
        System.out.println("++++++++++++");
    }
}
