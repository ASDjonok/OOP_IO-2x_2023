import java.util.Scanner;

public class FirstLab {
 
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        final int C = 0; 
        double S = 0.0;
        System.out.print("Enter a: "); 
        int a = scn.nextInt(); 
        System.out.print("Enter b: ");
        int b = scn.nextInt();
        System.out.print("Enter n: ");
        int n = scn.nextInt();
        System.out.print("Enter m: ");
        int m = scn.nextInt();
        if ((a <= 0 & n >= 0) | (b <= 0 & m >= 0)){
            System.out.println("Division by 0!"); 
        } else {
            for (char i = (char) a; i <= n; i++) {
                for(char j = (char) b; j <= m; j++) {
                        S += (double) (i % j) / (i + C);
                }
            }
            System.out.printf("Result - %.3f", S);
        }

        scn.close();
    }
}
