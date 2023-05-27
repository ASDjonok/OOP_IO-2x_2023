package IO_24._02_Бондаренко_Тарас_Андрійович.lab5;

import java.util.*;

public class Lab5 {
    public static void main(String[] args) {
        Text text = new Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Mauris a diam maecenas sed enim ut sem viverra. Amet est placerat in egestas erat imperdiet. Sed turpis tincidunt id aliquet risus. Amet porttitor eget dolor morbi non arcu risus quis. Elementum nibh tellus molestie nunc non blandit massa. Feugiat scelerisque varius morbi enim nunc faucibus. Ipsum faucibus vitae aliquet nec ullamcorper sit amet risus nullam. Quis enim lobortis scelerisque fermentum dui faucibus in. Sem viverra aliquet eget sit amet tellus cras adipiscing enim. Sed ullamcorper morbi tincidunt ornare. Sodales ut eu sem integer vitae justo eget magna. Mi ipsum faucibus vitae aliquet nec ullamcorper.");
        System.out.println(text);
        text.getSortedWordsByFirstLetter();
    }

}
