package lab4;

public class Student {

    // Створення полів класу.
    public String firstName;
    public String lastName;
    public int age;
    private String faculty;
    private boolean hasStipend;

    // Конструктор класу.
    public Student(String fn, String ln, int age, String fac, boolean wealth) {
        setValues(fn, ln, age, fac, wealth);
        getValues();
    }

    /* Метод, який нічого не повертає.
    Визначає поля класу.
    */
    private void setValues(String fn, String ln, int age, String fac, boolean wealth) {
        this.firstName = fn;
        this.lastName = ln;
        this.age = age;
        this.faculty = fac;
        this.hasStipend = wealth;
    }

    /* Метод, який нічого не повертає.
    Виводить значення полів.
    */
    private void getValues() {
        System.out.println("Прізвище та ім'я: " + this.lastName + " " + this.firstName);
        System.out.println("Вік: " + this.age);
        System.out.println("Факультет: " + this.faculty);
        System.out.print("Наявність стипендії: ");
        if (this.hasStipend)
            System.out.println("є");
        else
            System.out.println("немає");
        System.out.println("~".repeat(40));
    }

}
