import java.util.Scanner;

public class lab_1 {
    
    public static int protectedInput(String variableToRead, Scanner input) {
        do {
            try {
                System.out.printf("Enter %s: ", variableToRead);
                return input.nextInt();
            } catch (Exception e) {
                System.out.printf("%s must be an integer.\n", variableToRead.toUpperCase());
                input.nextLine();
            }
        } while (true);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int n = protectedInput("n", input);
        final int m = protectedInput("m", input);
        final int a = protectedInput("a", input);
        final int b = protectedInput("b", input);

        input.close();

        final float s = ((float) (b + m) / 2) * (m - b + 1) * (n - a + 1);

        System.out.println("S = " + s);
    }
}
