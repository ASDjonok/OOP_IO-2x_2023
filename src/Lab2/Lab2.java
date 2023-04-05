package Lab2;

import java.util.Scanner;
import java.util.Random;

public class Lab2 {
    public static void main(String[] args) {
        final int C5, C7, C11, NumBook;
        NumBook = 2401;
        C5 = NumBook % 5;
        C7 = NumBook % 7;
        C11 = NumBook % 11;
        System.out.println("-----------------------------------------------------");
        System.out.println("C5 is: " + C5 + " - act with martix is C=Bт");
        System.out.println("C7 is: " + C7 + " - type of elements is double");
        System.out.println("C11 is: " + C11 + " - calculate the sum of the largest elements\n" +
                "of each row of the matrix");
        System.out.println("-----------------------------------------------------");
        int Mside = 0;
        int Nside = 0;
        int Choose;
        double MaxSum = 0;
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter random or handle input(1 or 0): ");
                Choose = Math.abs(Integer.parseInt(sc.nextLine()));
                if (Choose == 1 || Choose == 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }

        }
        while (true) {
            try {
                System.out.print("Enter number of rows: ");
                Mside = Math.abs(Integer.parseInt(sc.nextLine()));
                if (Mside <= 0) {
                    System.out.println("Invalid input. Number of rows must be greater than 0");

                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        while (true) {
            try {
                System.out.print("Enter number of columns: ");
                Nside = Math.abs(Integer.parseInt(sc.nextLine()));
                if (Nside <= 0) {
                    System.out.println("Invalid input. Number of columns must be greater than 0");

                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        final int lenghtMaxElements = 5;
        double[][] CArray = new double[Mside][Nside];
        double[][] TransposedArray = new double[Nside][Mside];
        double[][] MaxElements = new double[Nside][lenghtMaxElements];
        if (Choose == 1) {
            for (int i = 0; i < Mside; i++) {
                for (int j = 0; j < Nside; j++) {
                    CArray[i][j] = rand.nextDouble(-100, 100);
                }

            }
        }
        if (Choose == 0) {
            for (int i = 0; i < Mside; i++) {
                for (int j = 0; j < Nside; j++) {
                    while (true) {
                        try {
                            System.out.printf("Enter the element at position (%d,%d): ", i + 1, j + 1);
                            CArray[i][j] = Double.parseDouble(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                        }
                    }
                }
            }
        }
        for (int i = 0; i < Mside; i++) {
            for (int j = 0; j < Nside; j++) {
                System.out.printf("%8.2f", CArray[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < Nside; i++) {
            for (int j = 0; j < Mside; j++) {
                TransposedArray[i][j] = CArray[j][i];
            }
        }
        System.out.println("Transposed array is:");
        int row, cols;
        for (row = 0; row < Nside; row++) {
            for (cols = 0; cols < Mside; cols++) {
                System.out.printf("%8.2f", TransposedArray[row][cols]);

            }
            System.out.println();
        }

        for (int i = 0; i < Nside; i++) {
            MaxElements[i][0] = TransposedArray[i][0];

            for (int j = 1; j < Mside; j++) {
                MaxElements[i][1] = i;
                if (TransposedArray[i][j] > MaxElements[i][0]) {
                    MaxElements[i][0] = TransposedArray[i][j];
                    MaxElements[i][2] = j;


                } else if (TransposedArray[i][j] == MaxElements[i][0]) {
                    MaxElements[i][3] = MaxElements[i][0];
                    MaxElements[i][4] = 1;

                }


            }
            //System.out.println(MaxElements[i][0] +" "+ MaxElements[i][1] +" "+ MaxElements[i][2] + " " + MaxElements[i][3] + " " + MaxElements[i][4]);
            //code i used for debug
        }
        System.out.println("Max elements for each row:");
        if (Mside == 1) {
            System.out.println("I can`t find max element for mx1 matrix");

        } else {
            for (int i = 0; i < Nside; i++) {
                if (MaxElements[i][0] == MaxElements[i][3] && MaxElements[i][4] == 1) {
                    System.out.printf("In row %1.0f does not exist a max element\n", MaxElements[i][1] + 1);
                } else {
                    System.out.printf("%8.2f is max value and his coordinate: (%1.0f, %1.0f)\n", MaxElements[i][0], MaxElements[i][1] + 1, MaxElements[i][2] + 1);
                    MaxSum += MaxElements[i][0];
                }
            }
            System.out.printf("Sum of elements with max values is: %.2f\n", MaxSum);
        }
    }
}
