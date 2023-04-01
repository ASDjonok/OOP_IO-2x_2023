import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введіть текст:");
        Scanner scan = new Scanner(System.in);
        String inputText = scan.nextLine();
        StringBuilder text = new StringBuilder(inputText);
        StringBuilder suz = new StringBuilder();
        while (true){
            if(text.isEmpty()){
                break;
            }
            int index1 = text.indexOf(".");
            int index2 = text.indexOf("!");

            int index3 = text.indexOf("?");

            int index4 = text.indexOf("...");

            int[] array1= {index1, index2, index3, index4};
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] >= 0) {
                    list.add(array1[i]);
                }
            }
            int min = Collections.min(list);
            String rechennya1 = text.substring(0, min);
            System.out.println(rechennya1);
            if (rechennya1.contains(" ")){
                StringBuilder rechennya = new StringBuilder(rechennya1);
                String firstword1;
                String secondword1 = text.substring(rechennya.lastIndexOf(" ")+1, rechennya.length());
                String secondword2;
                secondword2 = secondword1.substring(0, 1).toUpperCase()+secondword1.substring(1, secondword1.length());
                StringBuilder secondword = new StringBuilder(secondword2);
                if(rechennya.charAt(rechennya.indexOf(" ")-1)==','){
                    firstword1 = text.substring(0, rechennya.indexOf(" ")-1);
                    secondword.append(",");
                }
                else {
                    firstword1 = text.substring(0, rechennya.indexOf(" "));
                }

                String firstword2 = firstword1.substring(0, 1).toLowerCase()+firstword1.substring(1, firstword1.length());
                StringBuilder firstword = new StringBuilder(firstword2);


                firstword.insert(0, " ");
                rechennya.delete(0, rechennya.indexOf(" "));
                rechennya.insert(0, secondword);
                rechennya.delete(rechennya.lastIndexOf(" "), rechennya.length());
                rechennya.append(firstword);
                if ((index1==index4)&&(index1==min)){
                    rechennya.append(text.substring(min, min+3));
                    rechennya.append(" ");
                    text.delete(0, min+4);
                }
                else {
                    rechennya.append(text.substring(min, min+1));
                    rechennya.append(" ");
                    text.delete(0, min+2);
                }
                suz.append(rechennya);
            }
            else {
                StringBuilder rechennya = new StringBuilder(rechennya1);
                if ((index1==index4)&&(index1==min)){
                    rechennya.append(text.substring(min, min+3));
                    rechennya.append(" ");
                    text.delete(0, min+4);
                }
                else {
                    rechennya.append(text.substring(min, min+1));
                    rechennya.append(" ");
                    text.delete(0, min+2);
                }
                suz.append(rechennya);
            }








        }
        System.out.println(suz);
    }
}