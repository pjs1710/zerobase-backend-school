package dev.timer.task.selective.practice1;

public class Person {

    private String name = "John Doe";

    private int age = 30;

    private String gender = "F";

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "{" +
                "full_name= '" + name + '\'' +
                ", age= " + age +
                ", gender= '" + gender + '\'' +
                '}';
    }
}
