import java.util.ArrayList;

public class Sentence {
    // Поля, що містять речення
    private ArrayList<Word> words;
    private Znak znak;
    // Конструктор класу
    public Sentence(ArrayList<Word> words, Znak znak){
        this.words = words;
        this.znak = znak;

    }
    // Метод заміни першого слова на останнє
    public void ChangeOrder(){
        //Отримуємо перше і останнє слово речення
        Word FirstWord = words.get(0);
        Word LastWord = words.get(words.size()-1);
        //Використовуємо метод ChangeRegistr класу word
        FirstWord.ChangeRegistr(false);
        LastWord.ChangeRegistr(true);
        //Вставляємо в речення
        words.set(0, LastWord);
        words.set(words.size()-1, FirstWord);
    }
    // Метод виводу речення
    public void printSentence(){
        for(Word i:words){
            i.printWord();
        }
        znak.printZnak();
    }
}
