package encapsulationInheritancePolymorphism;

public class Student {
    private String name;
    private String surname;
    private String group;
    private String faculty;


    public String getName() {
        return name;
    }

    public void setFaculty(String faculty, String group) {
        this.faculty = faculty;
        this.group = group;
    }
}
