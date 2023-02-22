package lab6;

/*
Номер заліковї книжки - 2518.

Завдання:
9)Визначити ієрархію легкових автомобілів. Створити таксопарк.
Порахувати вартість автопарку. Провести сортування автомобілів
парку за витратами палива. Знайти автомобіль у компанії, що
відповідає заданому діапазону швидкості автомобіля.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(" ".repeat(15) + "Таксопарк" + " ".repeat(15));
        System.out.println("~".repeat(40));

        Volkswagen Car1 = new Volkswagen("Golf 4", 224, 5000, 2001, 6.8f, 1.6f, "Німеччина");
        Volkswagen Car2 = new Volkswagen("Passat", 240, 15000, 2007, 7.0f, 2.0f, "Німеччина");
        Toyota Car3 = new Toyota("Prius", 231, 12500, 2014, 4.3f, 1.8f, "Японія");
        Peguot Car4 = new Peguot("308", 220, 12000, 2007, 6.1f, 1.6f, "Франція");
        Lexus Car5 = new Lexus("LS", 250, 80000, 2022, 10.9f, 3.5f, "Японія");
        Skoda Car6 = new Skoda("Octavia", 220, 25000, 2022, 6.2f, 1.5f, "Чехія");
        Ford Car7 = new Ford("Focus", 242, 7800, 2014, 6.9f, 2.0f, "США");
        Bmw Car8 = new Bmw("5-Series", 250, 50000, 2018, 8.3f, 3.0f, "Німеччина");
        Car[] CarList = new Car[] {Car1, Car2, Car3, Car4, Car5, Car6, Car7, Car8};
        /*
        Використовується лямбда функція, щоб описати компаратор в Arrays.sort().
         */
        java.util.Arrays.sort(CarList, (a, b) -> Float.compare(a.fuel, b.fuel));

        System.out.println("Сортування автомобілів за витратами палива:");
        for (Car Car : CarList) {
            System.out.println(Car._model + ": " + Car.fuel + "л/100км");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть діапазон швидкості автомобіля:\nвід ");
        float speed_down = scanner.nextFloat();
        System.out.print("до ");
        float speed_up = scanner.nextFloat();
        System.out.println("Автомобілі із заданою швидкістю:");
        for (Car Car : CarList) {
            if ((Car.speed >= speed_down) && (Car.speed <= speed_up)) {

                System.out.println(Car._model + ": " + Car.speed + " км/год");
            }
        }
    }

}

