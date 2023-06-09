package Lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Lab3 {
    public static void main(String[] args) {
        System.out.println("Введіть текст:");
        Scanner scan = new Scanner(System.in); // Створюємо об'єкт Scanner для зчитування введеного тексту з консолі
        String inputText = scan.nextLine(); // Зчитуємо введений текст користувача
        StringBuffer textBuffer = new StringBuffer(inputText); // Створюємо відподні об'єкти StringBuffer
        StringBuffer result = new StringBuffer();

        while (!textBuffer.isEmpty()) { // Починаємо цикл, який виконується, доки об'єкт textBuffer не стане порожнім

            int index1 = textBuffer.indexOf("."); // Знаходимо індекси для символів, які закінчують речення
            int index2 = textBuffer.indexOf("!");
            int index3 = textBuffer.indexOf("?");
            int index4 = textBuffer.indexOf("...");

            int[] SplitIndexArray = {index1, index2, index3, index4};
            ArrayList<Integer> list = new ArrayList<>();

            for (int j : SplitIndexArray) { // Перебираємо кожну позицію з масиву
                if (j >= 0) { // Якщо символ не стоїть перед реченням, додаємо його
                    list.add(j);
                }
            }
            int min = Collections.min(list); // Знаходимо мінімальну позицію, щоб працювати з першим реченням
            String sentenceString = textBuffer.substring(0, min); // Виділяємо перше речення до знайденого розділового знаку
            StringBuffer sentence = new StringBuffer(sentenceString); // Створюємо об'єкт StringBuffer для речення з пробілом

            if (sentenceString.contains(" ")) { // Перевіряємо, чи перше речення містить більше одного слова
                String firstword1;
                String secondword1 = textBuffer.substring(sentence.lastIndexOf(" ") + 1, sentence.length()); // Виділяємо друге слово з речення
                String secondword2;
                secondword2 = secondword1.substring(0, 1).toUpperCase() + secondword1.substring(1, secondword1.length()); // Першу літеру робимо великою, решту слова копіюємо
                StringBuffer secondword = new StringBuffer(secondword2);

                if (sentence.charAt(sentence.indexOf(" ") - 1) == ',') { // Перевіряємо, чи перед першим словом є кома
                    firstword1 = textBuffer.substring(0, sentence.indexOf(" ") - 1); // Виділяємо перше слово з речення
                    secondword.append(","); // Додаємо кому до другого слова
                } else {
                    firstword1 = textBuffer.substring(0, sentence.indexOf(" ")); // Виділяємо перше слово з речення
                }

                String firstword2 = firstword1.substring(0, 1).toLowerCase() + firstword1.substring(1, firstword1.length()); // Перетворюємо першу літеру першого слова малою
                StringBuffer firstword = new StringBuffer(firstword2);

                firstword.insert(0, " "); // Додаємо пробіл перед першим словом
                sentence.delete(0, sentence.indexOf(" ")); // Видаляємо перше слово з речення
                sentence.insert(0, secondword); // Додаємо друге слово на початок речення
                sentence.delete(sentence.lastIndexOf(" "), sentence.length()); // Видаляємо останнє слово з речення
                sentence.append(firstword); // Додаємо перше слово в кінець речення


            }
            if ((index1 == index4) && (index1 == min)) { // Перевіряємо випадок, коли речення закінчується на "..."
                sentence.append(textBuffer.substring(min, min + 3)); // Додаємо "..." до речення
                textBuffer.delete(0, min + 4); // видаляємо з textBuffer
            } else {
                sentence.append(textBuffer.substring(min, min + 1)); // Додаємо '.' до речення
                textBuffer.delete(0, min + 2); // видаляємо з textBuffer
            }

            sentence.append(" "); // Додаємо пробіл
            result.append(sentence); // Додаємо речення до результату

        }
        System.out.println(result);
    }
}
