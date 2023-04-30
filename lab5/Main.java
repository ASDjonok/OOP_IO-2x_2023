import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Ввід текста користувачем
        System.out.println("Введіть текст:");
        Scanner scan = new Scanner(System.in);
        String inputText1 = scan.nextLine();
        // Заміна табуляцій на пробіли
        String inputText = inputText1.replace("\n", " ");
        // Перехід від формату String до формату Text
        Text text = FromStringToText(inputText);
        // Зміна порядку слів в реченні
        text.changeOrder();
        // Вивід результату
        text.printText();
    }
    // Метод переходу від String до Text
    public static Text FromStringToText(String text) {
        // Створюємо массив char з двома пробілами в кінці
        char[] chars1 = text.toCharArray();
        char[] chars = Arrays.copyOf(chars1, chars1.length + 2);
        chars[chars.length-2]=' ';
        chars[chars.length-1]=' ';
        // Створюємо массив, який буде містити літери і знаки
        ArrayList<Object> modifiedText = new ArrayList<>();
        // Змінна, яка буде контролювати наявність знаків в тексті
        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '!' || chars[i] == '?' || chars[i] == '.') {
                if (chars[i + 1] == '!' || chars[i + 1] == '?' || chars[i + 1] == '.') {
                    if (chars[i + 1 + 1] == '!' || chars[i + 1 + 1] == '?' || chars[i + 1 + 1] == '.') {
                        // Якщо в тексті трапляється знак, який складається відразу з трьох знаків, то програма зараховує його як один і додає в массив з літерами і знаками
                        ArrayList<Character> znaki = new ArrayList<>();
                        znaki.add(chars[i]);
                        znaki.add(chars[i + 1]);
                        znaki.add(chars[i + 1 + 1]);
                        Znak element = new Znak(znaki);
                        // Додаємо до лічильника два, щоб цикл не обробляв знаки ще раз
                        i = i + 1 + 1;
                        modifiedText.add(element);
                        k = k + 1;
                    } else {
                        // Якщо в тексті трапляється знак, який складається відразу з двох знаків, то програма зараховує його як один і додає в массив з літерами і знаками
                        ArrayList<Character> znaki = new ArrayList<>();
                        znaki.add(chars[i]);
                        znaki.add(chars[i + 1]);
                        Znak element = new Znak(znaki);
                        // Додаємо до лічильника один, щоб цикл не обробляв знаки ще раз
                        i = i + 1;
                        modifiedText.add(element);
                        k = k + 1;
                    }

                } else {
                    // Якщо в тексті трапився один розділовий знак, то він додається до масиву з літер і знаків
                    ArrayList<Character> znaki = new ArrayList<>();
                    znaki.add(chars[i]);
                    Znak element = new Znak(znaki);
                    modifiedText.add(element);
                    k = k + 1;
                }

            } else {
                // Якщо елмент массиву chars не виявився знаком, то він додається як літера
                Letter element = new Letter(chars[i]);
                modifiedText.add(element);
            }


        }
        // Якщо знаків в тексті не було, програма закінчує роботу
        if (k == 0) {
            System.out.println("В вашому тексті нема жодного речення!");
            System.exit(0);
        }
        // Змінна яка буде нижнею межею для зрізання слова
        int l = 0;
        // Масиви для створення речень і тексту відповідно
        ArrayList<Word> sent = new ArrayList<Word>();
        ArrayList<Sentence> tex = new ArrayList<Sentence>();
        for (int i = 0; i < modifiedText.size(); i++) {
            // Створюємо змінні, які містять даний елемент масиву і минулий
            Object x = modifiedText.get(i);
            Object x1 = new Object();
            if (i > 0) {
                x1 = modifiedText.get(i - 1);
            }
            // Перевірка чи є елемент літерою
            if (x instanceof Letter) {
                // Переходимо до класу Letter
                Letter z = (Letter) x;
                Letter y = new Letter(' ');
                if (i > 0) {
                    y = (Letter) x1;
                }
                // Перевірка чи є елемент комою
                if (z.isKome()) {
                    // Створення слова з всіх елементів, що були до коми і додавання його до речення
                    List<Object> wor1 = modifiedText.subList(l, i);
                    ArrayList<Letter> word = new ArrayList<>();
                    for (Object j : wor1) {
                        Letter let = (Letter) j;
                        word.add(let);
                    }
                    Word w = new Word(word);
                    sent.add(w);
                    // Зсув границі
                    l = i + 1;
                    // Додавання коми до речення
                    ArrayList<Letter> kome = new ArrayList<>();
                    kome.add(z);
                    Word Kome = new Word(kome);
                    sent.add(Kome);


                }
                // Перевірка чи є літера пробілом
                if (z.isSpace()) {
                    // Перевірка чи є минулий символ комою
                    if (y.isKome() || y.isDash()) {
                        // Додавання пробілу до речення і зсув границі
                        ArrayList<Letter> word1 = new ArrayList<>();
                        word1.add(z);
                        Word word = new Word(word1);
                        sent.add(word);
                        l = i + 1;
                    } else {
                        // Створення слова з всіх елементів, що були до пробіла і додавання його до речення
                        List<Object> word1 = modifiedText.subList(l, i);
                        ArrayList<Letter> word = new ArrayList<>();
                        for (Object j : word1) {
                            Letter let = (Letter) j;
                            word.add(let);
                        }
                        Word w = new Word(word);
                        sent.add(w);
                        // Додавання пробілу до речення
                        ArrayList<Letter> space = new ArrayList<>();
                        space.add(z);
                        Word Space = new Word(space);
                        sent.add(Space);
                        // Зсув границі
                        l = i + 1;
                    }
                }
                // Перевірка чи є елемент тире
                if (z.isDash()) {
                    if (y.isSpace()) {
                        // Якщо минулий елемент був пробілом, тире додається до речення
                        ArrayList<Letter> word1 = new ArrayList<>();
                        word1.add(z);
                        Word word = new Word(word1);
                        sent.add(word);
                        l = i + 1;
                    }
                }
            } else if (x instanceof Znak) {
                // Коли елемент є знаком, то створюється речення, яке додається до тексту
                List<Object> word1 = modifiedText.subList(l, i);
                ArrayList<Letter> word = new ArrayList<>();
                for (Object j : word1) {
                    Letter let = (Letter) j;
                    word.add(let);
                }
                Word w = new Word(word);
                sent.add(w);
                Znak z = (Znak) x;
                int jump = 2;
                // Зсув границі і лічильника
                l = i+jump;
                i = i + z.Lenght();

                z.addSpace();

                Sentence sentence = new Sentence(sent, z);
                tex.add(sentence);
                // Очищення речення
                sent= new ArrayList<>();
            }

        }
        // Створення і повернення тексту
        Text text2 = new Text(tex);
        text2.printText();
        return text2;
    }
}