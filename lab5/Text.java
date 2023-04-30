import java.util.ArrayList;

public class Text {
    // Поле що містить текст
    private ArrayList<Sentence> sentences;
    // Конструктор класу
    public Text(ArrayList<Sentence> sentences){
        this.sentences = sentences;
    }
    // Метод виводу текста
    public void printText(){
        for(Sentence i:sentences){
            i.printSentence();
        }
    }
    // Метод повернення довжини тексту

    public int Lenght(){
        return sentences.size();
    }
    // Метод зміни порядку слів у тексті
    public void changeOrder(){
        for(Sentence i: sentences){
            i.ChangeOrder();
        }
    }
}
