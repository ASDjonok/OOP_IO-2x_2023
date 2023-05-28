public class Lab5 {
    public static void main(String[] args) {
        StringBuilder txt = new StringBuilder("соціальна мережа, яка є мережею мікроблогів. Дає змогу користувачам надсилати короткі текстові повідомлення (до 2802 символів, до 2017 року — до 140 символів), використовуючи SMS,");
        System.out.println("Початковий текст:");
        System.out.println(txt);
        Text text = new Text(txt);
        StringBuilder result = text.splitText();
        System.out.println("Змінений текст:");
        System.out.println(result);
    }
}

class Text {
    private final StringBuilder textString;
    public Text(StringBuilder textString){
        this.textString = textString;
    }

    public StringBuilder splitText() {
        StringBuilder result = new StringBuilder();
        String[] sentenceStrings = textString.toString().split("(?<=[?.!])\\s?");
        for (String s : sentenceStrings) {
            StringBuilder sb = new StringBuilder(s);
            Sentence sentence = new Sentence(sb);
            result.append(sentence.splitSentence());
        }
        return result;
    }

}

class Sentence {
    private final StringBuilder sentence;

    public Sentence(StringBuilder sentence) {
        this.sentence = sentence;

    }

    public StringBuilder splitSentence() {
        StringBuilder returnSentence = new StringBuilder();
        String text = sentence.toString();
        String[] words = text.split(" ");
        for (String w : words) {
            StringBuilder wb = new StringBuilder(w);
            Word word = new Word(wb);
            returnSentence.append(word.splitWord()).append(" ");
        }
        return returnSentence;

    }
}

class Word {
    private final StringBuilder word;

    public Word(StringBuilder word) {
        this.word = word;
    }

    public StringBuilder splitWord() {
        StringBuilder returnWord = new StringBuilder();
        String wordstring = word.toString();
        String[] letters = wordstring.split("");
        String firstLetter = wordstring.substring(0, 1);
        returnWord.append(firstLetter);
        for (String l: letters){
            StringBuilder lb = new StringBuilder(l);
            Letter letter = new Letter(lb);
            if (firstLetter.equals(letter.getLetter().toString())){
                returnWord.append("");
            }else{
                if(l.equals("!") || l.equals("?") || l.equals(".") || l.equals(",") || l.equals(":") || l.equals(";")){
                    Punctuation punctuation = new Punctuation(lb);
                    returnWord.append(punctuation.getPunctuation());
                }else{
                    returnWord.append(letter.getLetter());
                }
            }
        }
        return returnWord;
    }
}

class Letter {
    private final StringBuilder letter;

    public Letter(StringBuilder letter) {
        this.letter = letter;
    }

    public StringBuilder getLetter() {
        return letter;
    }
}

class Punctuation {
    private final StringBuilder punctuation;

    public Punctuation(StringBuilder punctuation) {
        this.punctuation = punctuation;
    }

    public StringBuilder getPunctuation() {
        return punctuation;
    }
}
