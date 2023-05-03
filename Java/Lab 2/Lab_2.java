import java.util.Scanner;

public class Lab_2 {

    public static short protectedInput(String inputPrompt, String errorMessage, Scanner input) {
        short read_variable;

        do {
            try {
                System.out.println();
                System.out.print(inputPrompt);

                read_variable = input.nextShort();
                break;
            } catch (Exception e) {
                System.out.println(errorMessage);
                input.nextLine();
            }
        } while (true);

        return read_variable;
    }

    public static String format(int number) {
        int width = String.valueOf(number).length() + 1;
        String format = "|%" + width + "d ";

        return format;
    }

    public static double average(short[] row) {
        short sum = 0;

        for (short element : row) {
            sum += element;
        }

        double result = sum / row.length;

        return result;
    }

    public static void main(String[] args) {
        short a, rows = 0, columns = 0;
        String format;
        
        Scanner input = new Scanner(System.in);

        a = protectedInput("Input a constant to multipy a matrix by: ", "A constant must be a short-data type integer, try again.", input);
        
        System.out.println();
        System.out.println("Input size of the matrix.");

        do {
            rows = protectedInput("Rows: ", "A number of rows must be a short-data type integer, try again.", input);
        } while (rows <= 0);
        
        do {
            columns = protectedInput("Columns: ", "A number of columns must be a short-data type integer, try again.", input);
        } while (columns <= 0);
        
        input.close();

        short[][] matrix_B = new short[rows][columns];

        System.out.println();
        System.out.println("Matrix B:");

        format = format(rows * columns);

        for (short i = 0; i < rows; i++) {
            for (short j = 0; j < columns; j++) {
                matrix_B[i][j] = (short) ((i + 1) * (j + 1));

                System.out.printf(format, matrix_B[i][j]);
            }

            System.out.println("|");
        }

        System.out.println();
        System.out.println("Matrix a×B:");

        format = format(rows * columns * a);

        for (short i = 0; i < matrix_B.length; i++) {
            for (short j = 0; j < matrix_B[i].length; j++) {
                matrix_B[i][j] *= (short) (a);

                System.out.printf(format, matrix_B[i][j]);
            }

            System.out.println("|");
        }

        System.out.println();
        System.out.println("Averages of each row:");

        for (short[] row : matrix_B) {
            System.out.println(average(row));
        }
    }
}
