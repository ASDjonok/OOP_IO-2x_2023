package encapsulationInheritancePolymorphism.polymorphism.overload;

public class MyClassForOverloadExample {
    void myMethod(int a) {
        System.out.println("Integer: " + a);
    }

    void myMethod(double a) {
        System.out.println("Double: " + a);
    }

    public static void main(String[] args) {
        MyClassForOverloadExample overload = new MyClassForOverloadExample();
        overload.myMethod(1);
        overload.myMethod(0.1);
    }
}
