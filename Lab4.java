import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Lab4 {

    public static void main(String[] args) {
        Students student1 = new Students("Максим", 22, "ФІОТ", 91, 8);
        Students students2 = new Students("Ольга", 19, "ФЕА", 34, 4);
        Students students3 = new Students("Владислав", 18, "ФММ", 55, 10);
        Students students4 = new Students("Марія", 20, "ХТФ", 11, 6);
        Students students5 = new Students("Петро", 23, "ФМФ", 78, 2);
        Students[] students = {student1, students2, students3, students4, students5};
        System.out.println("Список студентів: ");
        System.out.println(String.format("%-9s | %-3s | %-9s | %-11s | %s", "Ім'я", "Вік", "Факультет", "Номер групи", "Рівень знань(від 0 до 10)"));
        for (Students student : students) {
            System.out.println(String.format("%-9s | %-3s | %-9s | %-11s | %s", student.getName(), student.getAge(), student.getNameOfFaculty(), student.getNumberOfGroup(), student.getLvlOfKnowledge()));
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть за чим сортувати: ");
        System.out.println("1 - Зростання \n2 - Спадання:");
        int incOrDec = scan.nextInt();
        System.out.println("Введіть за чим хочете сортувати: ");
        System.out.println("1 - Ім'я \n2 - Вік \n3 - Факультет\n4 - Група\n5 - Рівень знань: ");
        int num = scan.nextInt();
        if (incOrDec == 1) {
            switch (num) {
                case 1:
                    Arrays.sort(students, Comparator.comparing(Students::getName));
                    break;
                case 2:
                    Arrays.sort(students, Comparator.comparingInt(Students::getAge));
                    break;
                case 3:
                    Arrays.sort(students, Comparator.comparing(Students::getNameOfFaculty));
                    break;
                case 4:
                    Arrays.sort(students, Comparator.comparingInt(Students::getNumberOfGroup));
                    break;
                case 5:
                    Arrays.sort(students, Comparator.comparingInt(Students::getLvlOfKnowledge));
                    break;
            }
        } else {
            switch (num) {
                case 1:
                    Arrays.sort(students, Comparator.comparing(Students::getName).reversed());
                    break;
                case 2:
                    Arrays.sort(students, Comparator.comparingInt(Students::getAge).reversed());
                    break;
                case 3:
                    Arrays.sort(students, Comparator.comparing(Students::getNameOfFaculty).reversed());
                    break;
                case 4:
                    Arrays.sort(students, Comparator.comparingInt(Students::getNumberOfGroup).reversed());
                    break;
                case 5:
                    Arrays.sort(students, Comparator.comparingInt(Students::getLvlOfKnowledge).reversed());
                    break;
            }
        }
        System.out.println(String.format("%-9s | %-3s | %-9s | %-11s | %s", "Ім'я", "Вік", "Факультет", "Номер групи", "Рівень знань(від 0 до 10)"));
        for (Students student : students) {
            System.out.println(String.format("%-9s | %-3s | %-9s | %-11s | %s", student.getName(), student.getAge(), student.getNameOfFaculty(), student.getNumberOfGroup(), student.getLvlOfKnowledge()));
        }
    }
}
