package models;

public class StudentModel {
    private int id;
    private String name;
    private int age;
    private String course;

    public StudentModel(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public void printStudentInfo() {
        System.out.printf("%d\t%s\t%d\t%s\n", this.id, this.name, this.age, this.course);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getCourse() {
        return this.course;
    }
}
