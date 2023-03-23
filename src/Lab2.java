public class Lab2 {
    public static void main(String[] args) {
        final int A = 2;
        final int[][] MATRIX_B = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] C = calculation(A, MATRIX_B);

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

    private static int[][] calculation(int A, final int[][] MATRIX_B) {
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
