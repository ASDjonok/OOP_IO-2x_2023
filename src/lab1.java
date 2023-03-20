import java.util.Scanner;
public class lab1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // 2131 % 7 = 3; C7 = long
        long n, m, a, b;
        float result, sum;
        while(true) {
            try {
                System.out.println("Введіть n типу long:");
                n = scanner.nextLong();
                System.out.println("Введіть m типу long:");
                m  = scanner.nextLong();
                System.out.println("Введіть a типу long:");
                a  = scanner.nextLong();
                System.out.println("Введіть b типу long:");
                b  = scanner.nextLong();
                break;
            }catch(Exception e){
                scanner.nextLine();
                System.out.println("Введене неправильне число");
            }
        }

        // 2131 % 5 = 1; O2 = /
        // 2131 % 2 = 1; O1 = -
        // 2131 % 3 = 1; C = 1
        result = 0;
        byte C = 1;
        for(long i = a; i <= n; i++){
            sum = 0;
            for(long j = b; j <= m; j++){
                if (i - C == 0 || j == 0){
                    System.out.println("Помилка ділення на 0");
                    System.exit(0);
                }
                sum += (float) (i/j)/(i-C);
            }
            result += sum;
        }
        System.out.println(result);

    }
}
