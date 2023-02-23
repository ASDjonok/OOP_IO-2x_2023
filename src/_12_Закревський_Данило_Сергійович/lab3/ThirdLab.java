import java.util.Scanner;

public class ThirdLab {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string: "); 
        String text = scn.nextLine();  
        StringBuilder textBuilder = new StringBuilder(text); 
        System.out.print("Enter a string to replace the words: ");
        String replace = scn.nextLine(); 
        System.out.print("Enter the length of the words to replace: ");
        int length = scn.nextInt(); 
        String[] words = textBuilder.toString().split("\\s+"); 
        textBuilder.setLength(0);  
        for(String word : words) {
            if(word.charAt(word.length()-1) == '.' && word.length() - 1 == length) {
                textBuilder.append(replace + ". "); 
            } else if (word.charAt(word.length() - 1) == '!' && word.length() - 1 == length) {
                textBuilder.append(replace + "! ");
            } else if (word.charAt(word.length() - 1) == '?' && word.length() - 1 == length) { 
                textBuilder.append(replace + "? ");
            } else if (word.length() == length) {          
                textBuilder.append(replace + " "); 
            } else {
                textBuilder.append(word + " ");
            }
        }

        System.out.printf("Result: %s", textBuilder);
        scn.close();
    }
}
