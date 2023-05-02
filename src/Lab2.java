public class Lab2 {
    public static void main(String[] args) {
        final int A = 2;
        final int[][] MATRIX_B = {
                {1, 202, 1, 1, 202, 3, 1, 202, 3,},
                {1, 202, 1, 1, 202, 3, 1, 202, 3, 4},
                {1, 1,   3, 1, 202, 3, 1, 202, 3,},
//                {4, 5, 6,},
        };

        int[][] MATRIX_C = multiplication(A, MATRIX_B);

        print(MATRIX_C);

//        System.out.println("Sum of smallest elements in every column: " + sumOfSmallestElementsInEveryColumn(MATRIX_C));
        try {
            System.out.println("Sum of smallest elements in every column: " + sumOfSmallestElementsInEveryColumnRenew(MATRIX_C));
            System.out.println("???...");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("I'm still working...");

        /*int[] array = {1, 2, 3};
        int[] array2 = new int[3];
        Object[] array3 = new String[3];
        System.out.println(array3[0]); //nothing, trash from the memory, null || null
        System.out.println(array2[0]); //nothing, trash from the memory, null || 0
        System.out.println(array[0]); // || 1

        int[][] matrix2 = new int[2][3];
        matrix2[0] = new int[2];
        matrix2[1] = new int[1];
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                System.out.println("!" + array[i]);
            } else {
                System.out.println("?" + array[i]);
            }
        }

        for (int i = 0; i < array.length; i+=2) {
            System.out.println("!" + array[i]);
        }

        for (int i = 1; i < array.length; i+=2) {
            System.out.println("?" + array[i]);
        }

//        зубчасті матриці
        int[][] matrix = {
                {1, 2},
                {3}
        };

//        C=a×B, a - const


//        final int[][] MATRIX_C = int;


        MATRIX_B[0][0] = 2;
        MATRIX_B[0] = new int[]{1, 2};
        System.out.println(MATRIX_B[0][0]);
        MATRIX_B = new int[][]{
                {1, 2},
                {3}
        };*/
    }

    private static int sumOfSmallestElementsInEveryColumn(final int[][] MATRIX_C) {
//        todo check different length of rows
//        todo try to change i and j
//        todo check repetition of minimal elements
        int sum = 0;
        for (int i = 0; i < MATRIX_C[0].length; i++) {
            int tmpSmallest = MATRIX_C[0][i];
            for (int j = 1; j < MATRIX_C.length; j++) {
                if (MATRIX_C[j][i] < tmpSmallest) {
                    tmpSmallest = MATRIX_C[j][i];
                }
            }
            sum += tmpSmallest;
        }
        return sum;
    }

    private static int sumOfSmallestElementsInEveryColumnRenew(final int[][] MATRIX_C) throws Exception {
//        todo check different length of rows
        for (int i = 1; i < MATRIX_C.length; i++) {
            if (MATRIX_C[i].length != MATRIX_C[0].length) {
                throw new /*Runtime*/Exception("There are different lengths of matrix rows.");
//                System.err.println("There are different lengths of matrix rows.");
//                System.exit(0);
            }
        }
        int sum = 0;
        for (int j = 0; j < MATRIX_C[0].length; j++) {
            int tmpSmallest = MATRIX_C[0][j];
            boolean valueRepeats = false;
            for (int i = 1; i < MATRIX_C.length; i++) {
                if (MATRIX_C[i][j] < tmpSmallest) {
                    tmpSmallest = MATRIX_C[i][j];
                    valueRepeats = false;
                } else if (MATRIX_C[i][j] == tmpSmallest) {
                    valueRepeats = true;
                }
            }

            if (!valueRepeats) {
                sum += tmpSmallest;
            }
        }
        return sum;
    }

    private static void print(final int[][] MATRIX_C) {
        for (int i = 0; i < MATRIX_C.length; i++) {
            for (int j = 0; j < MATRIX_C[i].length; j++) {
//                System.out.print(MATRIX_C[i][j] + "\t");//printf("%4d",
                System.out.printf("%4d ", MATRIX_C[i][j]);//printf("%4d",
            }
            System.out.println();
        }
    }

    private static int[][] multiplication(int A, final int[][] MATRIX_B) {
        final int[][] MATRIX_C = new int[MATRIX_B.length][/*MATRIX_B[0].length*/]; // todo !!!DANGER different lengths of rows
//        final int[][] MATRIX_C = MATRIX_B;
        for (int i = 0; i < MATRIX_B.length; i++) {
            MATRIX_C[i] = new int[MATRIX_B[i].length];
            for (int j = 0; j < MATRIX_B[i].length; j++) {
                MATRIX_C[i][j] = MATRIX_B[i][j] * A;
            }
        }
        return MATRIX_C;
    }
}
