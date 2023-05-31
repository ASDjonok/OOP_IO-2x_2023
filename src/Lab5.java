import java.util.ArrayList;
import java.util.List;

class Letter {
    private char character;

    public Letter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return String.valueOf(character);
    }
}

class Word {
    private List<Letter> letters;

    public Word(List<Letter> letters) {
        this.letters = letters;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        StringBuilder wordBuilder = new StringBuilder();
        for (Letter letter : letters) {
            wordBuilder.append(letter.getCharacter());
        }
        return wordBuilder.toString();
    }
}

class Sentence {
    private List<Object> components;

    public Sentence(List<Object> components) {
        this.components = components;
    }

    public List<Object> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        StringBuilder sentenceBuilder = new StringBuilder();
        for (Object component : components) {
            if (component instanceof Word) {
                List<Letter> letters = ((Word) component).getLetters();
                for (Letter letter : letters) {
                    sentenceBuilder.append(letter.getCharacter());
                }
            } else if (component instanceof PunctuationMark) {
                sentenceBuilder.append(((PunctuationMark) component).getMark());
            }
            sentenceBuilder.append(" ");
        }
        return sentenceBuilder.toString().trim();
    }
}

class PunctuationMark {
    private char mark;

    public PunctuationMark(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}

class Text {
    private List<Sentence> sentences;

    public Text(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder textBuilder = new StringBuilder();
        for (Sentence sentence : sentences) {
            textBuilder.append(sentence.toString()).append(". ");
        }
        return textBuilder.toString().trim();
    }
}

public class Lab5 {
    public static void main(String[] args) {
        System.out.println("C17 = " + 2425%17);
        StringBuffer sentence = new StringBuffer("об'єктно-орієнтована мова програмування , випущена 1995 року компанією" +
                " Сан Майкросістемс , як основний компонент платформи Джава." +
                " З 2009 року мовою займається компанія Оракл , яка того року придбала Сан Майкросістемс. В офіційній" +
                " реалізації Джава-програми компілюються у байт-код , який при виконанні інтерпретується віртуальною" +
                " машиною для конкретної платформи");

        // Заміна послідовності табуляцій та пробілів одним пробілом
        String cleanedText = replaceTabsAndSpaces(sentence.toString());

        // Розбиття тексту на речення
        String[] sentenceArray = cleanedText.split("\\.");

        List<Sentence> sentences = new ArrayList<>();
        List<Character> punctuationMarks = new ArrayList<>();

        for (String s : sentenceArray) {
            // Розбиття речення на слова та розділові знаки
            String[] components = s.trim().split("\\s+");

            List<Object> sentenceComponents = new ArrayList<>();

            for (String component : components) {
                if (isPunctuationMark(component)) {
                    // Додавання розділових знаків
                    char mark = component.charAt(component.length() - 1);
                    punctuationMarks.add(mark);
                    sentenceComponents.add(new PunctuationMark(mark));
                } else {
                    // Створення слова
                    List<Letter> letters = new ArrayList<>();
                    for (char c : component.toCharArray()) {
                        letters.add(new Letter(c));
                    }
                    sentenceComponents.add(new Word(letters));
                }
            }

            sentences.add(new Sentence(sentenceComponents));
        }

        // Створення тексту
        Text text = new Text(sentences);

        // Виведення букв, слів та речень
        List<Sentence> allSentences = text.getSentences();
        for (Sentence s : allSentences) {
            List<Object> components = s.getComponents();

            for (Object component : components) {
                if (component instanceof Word) {
                    System.out.println("Слово: " + component);
                    List<Letter> letters = ((Word) component).getLetters();
                    for (Letter letter : letters) {
                        System.out.println("Літера: " + letter.getCharacter());
                    }
                } else if (component instanceof PunctuationMark) {
                    System.out.println("Розділовий знак: " + ((PunctuationMark) component).getMark());
                }
            }

            System.out.println("Речення: " + s.toString());
            System.out.println();
        }

        // Виведення розділових знаків
        System.out.println("Розділові знаки:");
        for (Character mark : punctuationMarks) {
            System.out.println(mark);
        }

        // Виведення масиву речень з пробілами
        System.out.println("Масив речень:");
        for (Sentence s : allSentences) {
            System.out.println(s.toString());
        }

        // Видалення слів заданої довжини, починаючи з приголосної літери
        removeWords(allSentences);

        // Виведення оновленого тексту
        System.out.println("Оновлений текст:");
        System.out.println(text.toString());

    }


    // Функція для заміни табуляцій та пробілів одним пробілом
    private static String replaceTabsAndSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }

    // Функція для перевірки, чи є рядок розділовим знаком
    private static boolean isPunctuationMark(String text) {
        return text.matches(".*[,.]$");
    }

    // Функція для видалення слів заданої довжини, починаючи з приголосної літери
    private static void removeWords(List<Sentence> sentences) {
        String consonants = "бвгґджзклмнпрстфхцчшщ";
        for (Sentence sentence : sentences) {
            List<Object> components = sentence.getComponents();
            List<Object> componentsToRemove = new ArrayList<>();

            for (Object component : components) {
                if (component instanceof Word) {
                    Word word = (Word) component;
                    List<Letter> letters = word.getLetters();
                    int wordLength = letters.size();
                    char firstLetter = letters.get(0).getCharacter();

                    if ((wordLength > 5) && (wordLength < 9) && consonants.contains(String.valueOf(firstLetter))) {
                        componentsToRemove.add(component);
                    }
                }
            }

            components.removeAll(componentsToRemove);
        }
    }
}