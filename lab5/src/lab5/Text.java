package lab5;

import java.util.ArrayList;
import java.util.List;

public class Text {
    private final List<Sentence> sentences;

    public Text(String stringText) {
        this.sentences = new ArrayList<>();
        String[] splitText = stringText.split("(?<=[!.?])\\s*");
        for (String sentence : splitText) {
            getSentences().add(new Sentence(sentence));
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

}
