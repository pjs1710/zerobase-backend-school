package dev.timer.task.fourthweek.practice2;

public class AnnotationExample {

    @CustomLogging
    public void helloWorld() {
        System.out.println("이 메서드는 매개변수가 없습니다.");
    }

    @CustomLogging
    public void helloGuy(String name) {
        System.out.println(name);
    }

    @CustomLogging
    public void helloGuys(String name1, String name2) {
        System.out.println(name1 + " " + name2);
    }
}
