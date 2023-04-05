package Lab1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        int C2, C3, C5, C7; // creating variables
        int numBook = 2401; // default value of scorebook

        Scanner sc = new Scanner(System.in); // scanner creating for inputing values from keyboard
        System.out.println("By default number of scorebook is 2401. \nEnter to skip or input new value: ");
        String input = sc.nextLine();

        if (!input.equals("")) { // try-catch for checking correct inputing of value
            try {
                numBook = Math.abs(Integer.parseInt(input)); // scorebook can be only unsigned
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Using default value 2401"); // printing that will be used default value
            }
        }

        String[] operations1 = {"+", "-"};//
        String[] operations2 = {"*", "/", "%", "+", "-"}; //  String array for choosing operations
        String[] operations3 = {"byte", "short", "int", "long", "char", "float", "double"}; //
        // determining variables
        C2 = numBook % 2;
        C3 = numBook % 3;
        C5 = numBook % 5;
        C7 = numBook % 7;

        String O1 = operations1[C2];
        int C = C3;
        String O2 = operations2[C5];
        String O3 = operations3[C7];

        System.out.println("C2 is: " + C2 + ", operation is: " + O1); //
        System.out.println("C3 is: " + C);                            // printing parameters that user got
        System.out.println("C5 is: " + C5 + ", operation is: " + O2); //
        System.out.println("C7 is: " + C7 + ", Type of indexes i and j is: " + O3); //

        Number i = 0; // creating objects i j of (abstract)superclass Number
        Number j = 0; //


        System.out.println("\nEnter a value for i and j in the " + O3 + " type: ");

        switch (O3) { // Choosing type of i and j by C7
            case "byte" -> {
                try {
                    i = sc.nextByte();
                    j = sc.nextByte();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid byte value.");
                    sc.nextLine();
                }
            }
            case "short" -> {
                i = sc.nextShort();
                j = sc.nextShort();
            }
            case "int" -> {
                i = sc.nextInt();
                j = sc.nextInt();
            }
            case "long" -> {
                i = sc.nextLong();
                j = sc.nextLong();
            }
            case "char" -> {
                System.out.println("Read only first character!");
                i = (int) sc.next().charAt(0);
                j = (int) sc.next().charAt(0);
            }
            case "float" -> {
                i = sc.nextFloat();
                j = sc.nextFloat();
            }
            case "double" -> {
                i = sc.nextDouble();
                j = sc.nextDouble();
            }

        }


        System.out.println("The value of the created variables is: " + i + " and " + j);



        class Sum { // creating class Sum
            int n, m;
            double i, j;

            public Sum(double i, double j, int n, int m) { // Constructor to initialize all variables
                this.i = i;
                this.j = j;
                this.n = n;
                this.m = m;
            }

            public void calc() { // create method for our class
                double sum = 0, result = 0, result2 = 0;
                if ((O1.equals("-") && i + n >= C && i <= C) || (C == 0 && i == 0)) { // exclude situations
                    System.out.println("dividing by zero!");                          // with dividing by 0
                } else if (i > n || j > m) {
                    System.out.println("i or j greater than n or m");
                } else {
                    for (double b = i; b <= n; b++) {
                        for (double a = j; a <= m; a++) {
                            switch (O2) {
                                case "+" -> result = b + a;
                                case "-" -> result = b - a;
                                case "*" -> result = b * a;
                                case "/" -> result = b / a;
                                case "%" -> result = b % a;
                            }
                            switch (O1) {
                                case "+" -> result2 = b + C;
                                case "-" -> result2 = b - C;
                            }
                            sum += result / result2;
                        }
                    }
                    System.out.println("Sum is: " + sum);
                }
            }
        }

        System.out.print("Enter value for n and m: \n");

        int n = sc.nextInt();
        int m = sc.nextInt();

        Sum sum = new Sum(i.doubleValue(), j.doubleValue(), n, m); // creating new instance of Sum class
        // .doubleValue() converting our variables to double
        sum.calc();
        sc.close();
    }
}