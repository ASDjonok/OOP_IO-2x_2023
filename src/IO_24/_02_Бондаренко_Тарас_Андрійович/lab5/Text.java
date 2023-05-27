package IO_24._02_Бондаренко_Тарас_Андрійович.lab5;

public class Text {
    private final Sentence[] sentences;

    public Text(String text) {
        String[] splitText = text.split("(?=[.!?]+)| ");
        sentences = new Sentence[splitText.length];
        for (int i = 0; i < splitText.length; i++) {
            sentences[i] = new Sentence(splitText[i]);
        }
    }

    public void getSortedWordsByFirstLetter() {
        Sentence.getSortedWordsByFirstLetter(sentences);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (Sentence sentence : sentences) {
            out.append(sentence.toString());
        }
        return out.toString().strip();
    }
}