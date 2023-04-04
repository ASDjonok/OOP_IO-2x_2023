import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //C2 = 2501 % 2 = 1, і операція O1 буде відніманням (-).
        //C3 = 2501 % 3 = 2
        //C5 = 2501 % 5 = 1, і операція O2 буде діленням (/).
        //C7 = 2501 % 7 = 4, тип індексів i та j буде char.
        double result = 0;  // результат
        char i, j;
        char operation1 = '-';
        double constant = 2.0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть значення n: ");
        int n = scanner.nextInt();
        System.out.print("Введіть значення m: ");
        int m = scanner.nextInt();

        // Обчислення значення функції S
        for (i = 'a'; i <= 'a' + n - 1; i++) {
            for (j = 'b'; j <= 'b' + m - 1; j++) {
                try {
                    double value = (double) i / applyOperation(j, operation1, constant);
                    result += value;
                } catch (ArithmeticException e) {
                    System.out.println("Ділення на нуль: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Виникла помилка: " + e.getMessage());
                }
            }
        }

        // Виведення результату
        System.out.println("Результат: " + result);
    }

    // Метод, який застосовує операцію О1 до двох чисел
    public static double applyOperation(char j, char operation, double constant) throws Exception {
        switch (operation) {
            case '-':
                return (double) j - constant;
            case '/':
                if (constant == 0.0) {
                    throw new ArithmeticException("C не може бути рівним нулю");
                } else {
                    return (double) j / constant;
                }
            default:
                throw new Exception("Непідтримувана операція: " + operation);
        }
    }
}