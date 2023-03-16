public class Lab1 {
    public static void main(String[] args) {
//        System.out.println( (double) 0 / 0 );
//        System.out.println( Math.sqrt(-1) );
        double s = 0;
        /*for (int i = 1; i <= 3; i++) { // 1) ��������� � i = 1, 2) ���� � <= 3, 3) �������� 䳿 � �� �����,
            System.out.println(i);     // 4) �������������� � �� 1, 5) ����������� �� ����� 2
//            s = s + i;
            s += i;
        }*/
        /*int[] array = new int[2];
        for (int i = 0; i < array.length; i++) {

        }*/
        final int A = -3;
        final int B = 1;
        final int N = 2;
        final int M = 2;

        final int C = 1;
        boolean wasDivisionByZero = false;
//        todo char
        for (int i = A; i <= N && !wasDivisionByZero; i++) {
            if (i + C == 0) { // todo optimize
                System.out.println("Division by zero!");
                wasDivisionByZero = true;
                break; //todo flag vs return;
            }
            for (int j = B; j <= M; j++) {
                if (j == 0) {
                    System.out.println("Division by zero!");
                    wasDivisionByZero = true;
                    break;
                }
                s += (double) (i / j) / (i + C);
            }
        }
        if (!wasDivisionByZero) {
            System.out.println("s = " + s);
        }
    }
}
