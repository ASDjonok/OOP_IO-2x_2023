public class Letter {
    // Поле що містить літеру
    private char simbol;
    // Конструктор
    public Letter(char simbol) {
        this.simbol = simbol;
    }
    // Метод повернення літери
    public char getLetter(){
        return simbol;
    }
    // Метод перевірки на те, чи є буква пробілом
    public boolean  isSpace(){
        if(this.simbol==' '){
            return true;
        }
        return false;
    }
    // Метод перевірки на те, чи є буква комою
    public boolean  isKome(){
        if(this.simbol==','){
            return true;
        }
        return false;
    }
    // Метод перевірки на те, чи є буква тире
    public boolean  isDash(){
        if(this.simbol=='-'){
            return true;
        }
        return false;
    }
    // Метод виводу літери
    public void printLetter(){
        System.out.print(simbol);
    }

}
