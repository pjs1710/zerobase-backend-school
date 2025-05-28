package dev.timer.task.fourthweek.practice2;

public class AnnotationExampleMain {

    public static void main(String[] args) {
        AnnotationExample example = new AnnotationExample();

        Validator.call(example, "helloWorld");
        Validator.call(example, "helloGuy", "Jae Seong");
        Validator.call(example, "helloGuys", "Jae Seong", "Zero-Base");
    }
}
