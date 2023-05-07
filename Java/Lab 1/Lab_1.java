import java.util.Scanner;

public class Lab_1 {

    public static int protectedInput(String variable_to_read, Scanner input) {
        int read_variable;
        do {
            try {
                System.out.printf("Enter %s: ", variable_to_read);
                read_variable = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.printf("%s must be an integer.\n", variable_to_read.toUpperCase());
                input.nextLine();
            }
        } while (true);
        return read_variable;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int n = protectedInput("n", input);
        final int m = protectedInput("m", input);
        final int a = protectedInput("a", input);
        final int b = protectedInput("b", input);

        input.close();

        float s = ((float) (b + m) / 2) * (m - b + 1) * (n - a + 1);

        System.out.println("S = " + s);
    }
}
