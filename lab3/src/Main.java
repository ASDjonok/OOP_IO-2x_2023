import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer text = new StringBuffer(scanner.nextLine());
        String str_text = text.toString();
        // Заміна ? й ! на .
        str_text = str_text.replaceAll("[?!]", ".");
        // Очищення від спеціальних символів.
        str_text = str_text.replaceAll("\"", "");
        str_text = str_text.replaceAll("-", "");
        str_text = str_text.replaceAll("[,':;^*&%$#@]", "");
        // Створення масиву з речень.
        String[] spl_text = str_text.split("\\.");

        // Перевірка на кількість речень.
        if (spl_text.length == 0 || spl_text.length == 1) {
            System.out.println("Не вдалося виконати дію з рядками (було введено одне речення або взагалі нічого)");
            return;
        }

        System.out.println("Слова першого речення, яких немає у жодному з наступних:");
        for (String st : spl_text[0].split(" ")) {
            int index = 0;
            for (int i = 1; i < spl_text.length; i++) {
                // Усунення кейсу з регістром, усунення пробілів.
                if (Arrays.asList(spl_text[i].toLowerCase().trim().split(" ")).contains(st.trim().toLowerCase())) {
                    index = 1;
                    break;
                }
            }
            // Перевірка на те, чи було дане слово хоча б в одному реченні.
            if (index == 0) {
                System.out.println(st.trim().toLowerCase());
            }
        }
    }

}

/* [Input]
"У молодості я взяв собі за правило не пити ні краплі спиртного до обіду. Тепер, коли я вже немолодий, я тримаюся правила не пити ні краплі спиртного до сніданку". - Вінстон Черчилль
   [Output]
у
молодості
взяв
собі
за
правило
обіду
 */
