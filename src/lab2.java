public class lab2 {
    public static void main(String[] args){

        // 2131 % 7 = 3; C7 = int

        int[][] matrix = {
                {1,2,3,4,5},
                {1,3,5,7,9},
                {10,1,20,2,5}
        };

        int rows = matrix.length;
        int column = matrix[0].length;
        System.out.println("Матриця:");
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < column; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        // 2131 % 5 = 1; C5 = транспортування;

        int[][] transportMatrix = new int[column][rows];


        for(int i = 0; i < rows; i++){
             for(int j = 0; j < column; j++){
                 transportMatrix[j][i] = matrix[i][j];
             }
        }
        System.out.println("Транспонована матриця:");
        for (int i = 0; i < column; i++){
            for (int j = 0; j < rows; j++){
                System.out.print(transportMatrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        // 2131 % 11 = 8; C11 = Знайти середнє значення елементів кожного рядка матриці;
        int sum;
        for(int i = 0; i < rows; i++){
            sum = 0;
            for(int j = 0; j < column; j++){
                sum += matrix[i][j];
            }
            System.out.println("Середнє арифметичне " + (i+1) + " строки = " + (float)sum/column);
        }
    }
}
