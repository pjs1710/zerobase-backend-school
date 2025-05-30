package dev.timer.task.selective.practice1;


public class Person {

    @JsonField(value = "full_name")
    private String name = "John Doe";

    @JsonField(value = "age")
    private int age = 30;

    @JsonField(value = "gender", skipYn = true) // skipYn이 true이면 출력하지 않는 상황. -> 예시 출력 비교
    private String gender = "F";

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

}
