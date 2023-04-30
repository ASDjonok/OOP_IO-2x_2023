import java.util.ArrayList;

public class Word {
    // Поле, що містить слово
     private ArrayList<Letter> letters;
     // Конструктор класу
     public Word(ArrayList<Letter> letters){
         this.letters = letters;
     }
     // Метод зміни регістру першої літери слова
    public void ChangeRegistr(boolean loh /*low or high?*/) {
         Letter FirstLetter = letters.get(0);
         char Let = FirstLetter.getLetter();
         // В залежності від значення змінної loh літера змінюється або в нижній або в верхній регістр
         if(loh==true){
             Let = Character.toUpperCase(Let);
         } else {
             Let = Character.toLowerCase(Let);
         }
         letters.set(0, new Letter(Let));
    }
    // Метод виводу слова
    public void printWord(){
         for(Letter i:letters){
             i.printLetter();
         }
    }

}
