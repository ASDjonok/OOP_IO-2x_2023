import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        byte[][] matrix = {{4, 7, 3}, {4, 7, 6}, {7, 10, 9}};

        //C5 = 2501 mod 5 = 1, тому C = B^T (транспонування матриці)
        //C7 = 2501 mod 7 = 1, тому тип елементів матриці має бути byte
        //C11 = 2501 mod 11 = 10, тому треба знайти середнє значення елементів матриці

        // Виконуємо дію з матрицею: транспонування матриці B
        byte[][] transposedMatrix = transposeMatrix(matrix);
        System.out.println("Transposed matrix: ");
        printMatrix(transposedMatrix);

        // Виконуємо дію з матрицею C: знаходимо середнє значення елементів матриці
        double average = calculateAverage(transposedMatrix);
        System.out.println("Cереднє значення елементів матриці: " + average);
    }

    // Метод для транспонування матриці
    private static byte[][] transposeMatrix(byte[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        byte[][] transposedMatrix = new byte[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    // Метод для знаходження середнього значення елементів матриці
    private static double calculateAverage(byte[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum += matrix[i][j];
            }
        }

        return (double) sum / (rows * columns);
    }

    // Метод для виведення матриці на екран
    private static void printMatrix(byte[][] matrix) {
        for (byte[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
