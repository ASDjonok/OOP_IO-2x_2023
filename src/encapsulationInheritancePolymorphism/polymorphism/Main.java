package encapsulationInheritancePolymorphism.polymorphism;

/*import encapsulationInheritancePolymorphism.inheritance.ElectricEngine;
import encapsulationInheritancePolymorphism.inheritance.FuelEngine;*/

public class Main {
    public static void main(String[] args) {
        /*encapsulationInheritancePolymorphism.inheritance.*/ElectricEngine electricEngine = new ElectricEngine(); // створення нового об'єкту (екземпляру) класу ElectricEngine
        /*encapsulationInheritancePolymorphism.inheritance.*/FuelEngine fuelEngine = new FuelEngine();

        Engine engine1 = fuelEngine;

        Engine[] engines = {
                electricEngine,
                fuelEngine
        };

        for (Engine engine : engines) {
            System.out.println(engine.getPower());
        }

        /*for (int i = 0; i < engines.length; i++) {
            System.out.println(engines[i].getPower());
        }*/

//        +
        int a = 1;
        int b = 1;
        int c = a + b;
        System.out.println(c);


        String sA = "1";
        String sB = "1";
        String sC = sA + sB;
        System.out.println(sC);
    }
}
