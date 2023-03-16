public class Lab2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        /*for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                System.out.println("!" + array[i]);
            } else {
                System.out.println("?" + array[i]);
            }
        }*/

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
    }
}
