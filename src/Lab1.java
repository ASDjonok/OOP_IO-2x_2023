public class Lab1 {
    public static void main(String[] args) {
//        char c = 'a' + '1';
        char c = 97;
//        char c = '1';
        System.out.println(c);
        System.out.println((int) c);
        c++;
        System.out.println(c);
        System.out.println((int) c);
        System.out.println((double)'1'/'3');

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
        final int B = 0;
        final int N = 2;
        final int M = 2;

        final int C = 1;
//        boolean wasDivisionByZero = false;
//        todo char
//        todo[clear code] think about avoiding brackets
        if ((A <= -C && -C <= N) || (B <= 0 && 0 <= M)) {
            System.out.println("Division by zero!");
            return;
        }
/*myLabel:*/for (int i = A; i <= N /*&& !wasDivisionByZero*/; i++) {
            /*if (i + C == 0) { // todo optimize
                System.out.println("Division by zero!");
                wasDivisionByZero = true;
                break; //todo flag vs return;
            }*/
            for (int j = B; j <= M; j++) {
                /*if (j == 0) {
                    System.out.println("Division by zero!");
                    return;
//                    wasDivisionByZero = true;
//                    break myLabel;
                }*/
                s += (double) (i / j) / (i + C);
            }
        }
//        if (!wasDivisionByZero) {
            System.out.println("s = " + s);
//        }
    }
}
