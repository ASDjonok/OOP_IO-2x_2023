package IO_24._02_Бондаренко_Тарас_Андрійович.lab3;

import java.util.*;

public class Lab3 {
    // String
    // Надрукувати слова без повторень заданого тексту в алфавітному порядку за першою літерою.

    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mauris a diam maecenas sed enim ut sem viverra. Amet est placerat in egestas erat imperdiet. Sed turpis tincidunt id aliquet risus. Amet porttitor eget dolor morbi non arcu risus quis. Elementum nibh tellus molestie nunc non blandit massa. Feugiat scelerisque varius morbi enim nunc faucibus. Ipsum faucibus vitae aliquet nec ullamcorper sit amet risus nullam. Quis enim lobortis scelerisque fermentum dui faucibus in. Sem viverra aliquet eget sit amet tellus cras adipiscing enim. Sed ullamcorper morbi tincidunt ornare. Sodales ut eu sem integer vitae justo eget magna. Mi ipsum faucibus vitae aliquet nec ullamcorper.";
        String[] words = text.split("[\\p{Punct}\\s]+");
        List<String> wordList = new ArrayList<>(Arrays.asList(words));//Class ArrayList implements interface List
        // asList returns immutable list
        Set<String> wordSet = new HashSet<>(wordList);// Class HashSet implements interface Set
        wordList.clear();
        wordList.addAll(wordSet);
        wordList.sort(String::compareToIgnoreCase);

        for (String element : wordList) {
            System.out.println(element);
        }
    }
}

