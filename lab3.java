public class lab3 {
    public static void main(String[] args) {
        StringBuilder txt = new StringBuilder("— соціальна мережа, яка є мережею мікроблогів, дає змогу користувачам надсилати короткі текстові повідомлення (до 2802 символів, до 2017 року — до 140 символів), використовуючи SMS,");
        System.out.println(txt);
        String[] words = txt.toString().split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder(words[i]);
            StringBuilder firstLetter = new StringBuilder(word.substring(0, 1));
            if (word.substring(1).contains(firstLetter.toString().toLowerCase()) || word.substring(1).contains(firstLetter)) {
                String changedWord = firstLetter + word.substring(1).replaceAll(firstLetter.toString().toLowerCase(), "").replaceAll(firstLetter.toString(), "");
                result.append(changedWord);
                result.append(" ");
            } else {
                result.append(word);
                result.append(" ");
            }
        }
        System.out.println(result);
    }
}
