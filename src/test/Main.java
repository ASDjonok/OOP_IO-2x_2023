package test;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.getF());
        a.setF(1);
        System.out.println(a.getF());

        System.out.println(a.f);

        int[] array = {1, 2, 1};
        System.out.println(array.length);
    }
}
