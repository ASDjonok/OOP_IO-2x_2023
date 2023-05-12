public class Students {
    private String name;
    private int age;
    private String nameOfFaculty;
    private int numberOfGroup;
    private int lvlOfKnowledge;

    public Students(String name, int age, String nameOfFaculty, int numberOfGroup, int lvlOfKnowledge) {
        this.name = name;
        this.age = age;
        this.nameOfFaculty = nameOfFaculty;
        this.numberOfGroup = numberOfGroup;
        this.lvlOfKnowledge = lvlOfKnowledge;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getNameOfFaculty() {
        return nameOfFaculty;
    }
    public int getNumberOfGroup() {
        return numberOfGroup;
    }
    public int getLvlOfKnowledge() {
        return lvlOfKnowledge;
    }
}
