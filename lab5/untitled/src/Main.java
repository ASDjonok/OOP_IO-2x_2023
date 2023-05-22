import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String inputText = "Раз два три, літо прийди! По ООП сто балів захвати. ім'я запише без апострофу, ех"; //вход даних, текст
        int targetLength = 3; //змінна, кількість літер в слові

        try {
            TextProcessor textProcessor = new TextProcessor();
            HashSet<Word> uniqueWords = textProcessor.findUniqueWordsWithLength(inputText, targetLength);
            System.out.println("Unique words of length " + targetLength + " in the input text are: " + uniqueWords);// вивод повідомлення, що містить довжину та унікальні слова змінної
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());//вивиод помилки
        }
    }
}

class Letter {
    private char value;

    public Letter(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}

class Word {
    private Letter[] letters;

    public Word(Letter[] letters) {
        this.letters = letters;
    }

    public Letter[] getLetters() {
        return letters;
    }

    public void setLetters(Letter[] letters) {
        this.letters = letters;
    }

    public int getLength() {
        return letters.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter.getValue());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Word other = (Word) obj;
        return this.toString().equals(other.toString());
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}

class Sentence {
    private Word[] words;
    private String punctuation;

    public Sentence(Word[] words, String punctuation) {
        this.words = words;
        this.punctuation = punctuation;
    }

    public Word[] getWords() {
        return words;
    }

    public void setWords(Word[] words) {
        this.words = words;
    }

    public String getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Word word : words) {
            sb.append(word.toString()).append(" ");
        }
        sb.append(punctuation);
        return sb.toString();
    }
}

class Text {
    private Sentence[] sentences;

    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    public void setSentences(Sentence[] sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Sentence sentence : sentences) {
            sb.append(sentence.toString());
        }
        return sb.toString();
    }
}

class TextProcessor {
    public HashSet<Word> findUniqueWordsWithLength(String inputText, int targetLength) {
        HashSet<Word> uniqueWords = new HashSet<>();
        String[] sentenceStrings = inputText.split("[?]");
        for (String sentenceString : sentenceStrings) {
            String[] wordStrings = sentenceString.trim().split("\\s+");
            for (String wordString : wordStrings) {
                wordString = wordString.replaceAll("[\\t\\s]+", " "); // Заміна послідовності табуляцій та пробілів одним пробілом
                wordString = wordString.replaceAll("[^\\p{L}\\s]", ""); // Вилучення розділових знаків
                wordString = wordString.toLowerCase(); // Перетворення на нижній регістр
                wordString = wordString.replace("’", ""); // Вилучення апострофів

                if (wordString.length() == targetLength) {
                    Letter[] letters = new Letter[wordString.length()];
                    for (int i = 0; i < wordString.length(); i++) {
                        letters[i] = new Letter(wordString.charAt(i));
                    }
                    Word word = new Word(letters);
                    uniqueWords.add(word);
                }
            }
        }
        return uniqueWords;
    }
}
