import java.util.Scanner;

public class Lab_2 {

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

        do {
            try {
                System.out.println();
                System.out.print("Input a constant to multipy a matrix by: ");

                a = input.nextShort();
                break;
            } catch (Exception e) {
                System.out.println("A constant must be a short-data type integer, try again.");
                input.nextLine();
            }
        } while (true);

        System.out.println();
        System.out.println("Input size of the matrix.");

        do {
            try {
                System.out.print("Rows: ");
                rows = input.nextShort();
            } catch (Exception e) {
                System.out.println("A number of rows must be a short-data type integer, try again.");
                input.nextLine();
            }
        } while (rows <= 0);

        do {
            try {
                System.out.print("Columns: ");
                columns = input.nextShort();
            } catch (Exception e) {
                System.out.println("A number of columns must be a short-data type integer, try again.");
                input.nextLine();
            }
        } while (columns <= 0);

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

        for (short i = 0; i < rows; i++) {
            for (short j = 0; j < columns; j++) {
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

        input.close();
    }
}
