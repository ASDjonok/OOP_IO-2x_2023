import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String inputText = "Who are you? What is your name? Where are you from?";
        int targetLength = 3;

        try {
            HashSet<String> uniqueWords = new HashSet<String>();
            String[] sentences = inputText.split("[?]");
            for (String sentence : sentences) {
                String[] words = sentence.trim().split("\\s+");
                for (String word : words) {
                    if (word.length() == targetLength) {
                        uniqueWords.add(word.toLowerCase());
                    }
                }
            }
            System.out.println("Unique words of length " + targetLength + " in the input text are: " + uniqueWords);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
