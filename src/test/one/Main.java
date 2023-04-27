package test.one;

public class Main {
    public static void main(String[] args) {
        Object[] objects = {
                new A(),
                new B(),
        };
        for (Object object : objects) {
            ((MyMethodInterface)object).myMethod();
        }
    }
}
