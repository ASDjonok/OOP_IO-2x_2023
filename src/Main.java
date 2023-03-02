public class Main {
    public static void main(String[] args) {
        System.out.println(args[2]);
        System.out.println("Hello world!");
//        System.out.println(1);

        int a = 1;
        int b = 2;
        int c = 1;
        int d = 1;

        System.out.println(2&1);
        System.out.println(2|1);
        int aa = 2;

        /*if (aa) {

        }*/

//        System.out.println("a"&"b");
        System.out.println('a'&'b');

        if ((a > b) & MyBooleanMethod()) {
            System.out.println("?????????????????????????");
        }


    }

    static boolean MyBooleanMethod() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return true;
    }

    void myFunction() {

    }

    int myFunction2() {
        return 1;
    }
}
