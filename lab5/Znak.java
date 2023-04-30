import java.util.ArrayList;

public class Znak {
    // Поле, що містить знак
    private ArrayList<Character> simbols;
    // Конструктор класу
    public Znak(ArrayList<Character> simbols) {
        this.simbols = simbols;
    }
    // Метод визначення довжини знаку
    public int Lenght(){
        int x = simbols.size();
        return x;
    }
    // Метод виводу знаку
    public void printZnak(){
        for(Character i:simbols){
            System.out.print(i);
        }
    }
    // Метод додавання пробілу в кінці знаку

    public void addSpace(){
        simbols.add(' ');
    }
}
