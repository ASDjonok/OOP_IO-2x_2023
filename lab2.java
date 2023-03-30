import java.util.Scanner;
import java.util.Random;

public class lab2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введіть кількість рядків матриці А:");
        int mA = scan.nextInt();
        System.out.println("Введіть кількість стовпців матриці А:");
        int nA = scan.nextInt();
        System.out.println("Введіть кількість рядків матриці B:");
        int mB = scan.nextInt();
        if (nA != mB) {
            System.out.println("Щоб помножити матриці, потрібно, щоб кількість стовпців матриці А == кількості рядків матриці B");
            return;
        }
        System.out.println("Введіть кількість стовпців матриці B:");
        int nB = scan.nextInt();
        System.out.println("Границя значень у матрицях:");
        int upperbound = scan.nextShort();
        int[][] matrixA = new int[mA][nA];
        int[][] matrixB = new int[mB][nB];
        int[][] matrixC = new int[mA][nB];
        generationMatrixes(matrixA, matrixB, upperbound);
        printMatrixC(matrixA, matrixB, matrixC);
        AverageValueofElementsofEachColumn(matrixC);
    }

    private static void AverageValueofElementsofEachColumn(int[][] matrixC) {
        System.out.println("Середнє значення елементів кожного стовпчика матриці:");
        System.out.print("||");
        for (int i = 0; i < matrixC.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrixC[i].length; j++) {
                sum += matrixC[j][i];
            }
            System.out.printf(" %.2f ||", (sum) / matrixC.length);
        }
    }

    private static void printMatrixC(int[][] matrixA, int[][] matrixB, int[][] matrixC) {
        for (int i = 0; i < matrixC.length; i++) {
            for (int j = 0; j < matrixC[i].length; j++) {
                for (int k = 0; k < matrixA[j].length; k++) {
                    matrixC[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        System.out.println("Матриця С:");
        for (int i = 0; i < matrixC.length; i++) {
            for (int j = 0; j < matrixC[i].length; j++) {
                System.out.printf("|%4d", matrixC[i][j]);
            }
            System.out.println("|");
        }
    }

    private static void generationMatrixes(int[][] matrixA, int[][] matrixB, int upperbound) {
        Random rand = new Random();
        System.out.println("Матриця А:");
        for (short i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                matrixA[i][j] = rand.nextInt(upperbound);
                System.out.printf("|%4d", matrixA[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("Матриця B:");
        for (short i = 0; i < matrixB.length; i++) {
            for (int j = 0; j < matrixB[i].length; j++) {
                matrixB[i][j] = rand.nextInt(upperbound);
                System.out.printf("|%4d", matrixB[i][j]);
            }
            System.out.println("|");
        }
    }
}