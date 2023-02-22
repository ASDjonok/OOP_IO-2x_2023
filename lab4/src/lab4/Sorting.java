package lab4;

import java.util.Comparator;

public class Sorting {

    // Непорушний клас, створений на основі абстратного класу Comparator.
    public static class SortByAlphabet implements Comparator<Student> {

        /* Реалізація методу compare().
        Метод compare(Object o1, Object 02) є одним із абстрактних методів
        класу Comparator. Нам потрібно або зробити наш клас абстактним, або
        реалізувати даний метод. Якщо ж оголосити клас SortByAlphabet
        абстрактним, ми не зможемо створити на основі його об'єкт, тому
        вибір очевидний - реалізація методу.
        */
        @Override
        public int compare(Student st1, Student st2) {
            /* Якщо в нас буде 2 однакових прізвища на порівняння, нам потрібно
            порівнювати імена аби сортування по алфавіту було правильним.
            */
            if (st1.lastName.compareTo(st2.lastName) == 0) {
                return st1.firstName.compareTo(st2.firstName);
            } else {
                return st1.lastName.compareTo(st2.lastName);
            }
        }

    }

    // Непорушний клас, створений на основі абстратного класу Comparator.
    public static class SortByAge implements Comparator<Student> {

        // Аналогічно тут, реалізуємо метод compare().
        @Override
        public int compare(Student st1, Student st2) {
            /* Метод compareTo() приймає лише дані типу String, тому
            ми перетворюємо вік з int в String. Звісно ж це може привести
            до неточності. Числа будуть порівнюватись спочатку по перших
            цифрах, потім по других і тд. Якщо в нас буде, наприклад вік
            107 і 18 на порівнянні, прогрма порахує, що 18 > 107 по
            порядку. Тут цим знехтується, адже я сумніваюсь що існують
            студенти яким >100 років.
            */
            String age1 = Integer.toString(st1.age);
            String age2 = Integer.toString(st2.age);
            return age1.compareTo(age2);
        }

    }

}
