package IO_24._02_Бондаренко_Тарас_Андрійович.lab2;

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
//        C5 = 2
//        C7 = 1
//        C11 = 4
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of matrix rows: ");
        int m = scan.nextInt();
        System.out.print("Enter the number of matrix columns: ");
        int n = scan.nextInt();

        System.out.println("\nFilling matrix A:");
        byte[][] matrixA = new byte[m][n]; // Creating MxN matrix A
        scanMatrix(matrixA, scan);

        System.out.println("\nMatrix A"); // Printing matrix A
        printMatrix(matrixA);

        System.out.println("\nFilling matrix B:");
        byte[][] matrixB = new byte[m][n];// Creating MxN matrix B
        scanMatrix(matrixB, scan);

        scan.close();

        System.out.println("\nMatrix B:");// Printing matrix B
        printMatrix(matrixB);

        System.out.println("\nMatrix C:");
        byte[][] matrixC = new byte[m][n];// Creating matrix C
        for (byte i = 0; i < m; i++) {
            for (byte j = 0; j < n; j++) {
                matrixC[i][j] = (byte) (matrixA[i][j] + matrixB[i][j]);
                System.out.print(matrixC[i][j] + "\t ");
            }
            System.out.println();
        }

        byte evenSum = 0; // Sum for the largest numbers in even rows
        byte oddSum = 0;// Sum for the smallest numbers in even rows

        for (byte i = 0; i < matrixC.length; i++) {
            byte largest = Byte.MIN_VALUE; // variable for largest element
            byte lowest = Byte.MAX_VALUE;// variable for smallest element
            for (byte j = 0; j < matrixC[i].length; j++) {
                if (i % 2 == 0) {
                    lowest = (byte) Math.min(lowest, matrixC[i][j]);
                } else {
                    largest = (byte) Math.max(largest, matrixC[i][j]);
                }
            }
            if (i % 2 == 0) {
                oddSum += lowest;
            } else {
                evenSum += largest;
            }
        }

        System.out.println("\nSum of the biggest elements: " + evenSum);
        System.out.println("Sum of the smallest elements: " + oddSum);
    }

    private static void scanMatrix(byte[][] matrix, Scanner scan) { //Method for filling matrix
        for (byte i = 0; i < matrix.length; i++) {
            for (byte j = 0; j < matrix[i].length; j++) {
                System.out.print("Enter element" + "[" + i + "]" + "[" + j + "]: ");
                matrix[i][j] = scan.nextByte();
            }
        }
    }

    private static void printMatrix(byte[][] matrix) {//Method for printing matrix
        for (byte[] row : matrix) {
            for (byte el : row) {
                System.out.print(el + "\t ");
            }
            System.out.println();
        }
    }
}

