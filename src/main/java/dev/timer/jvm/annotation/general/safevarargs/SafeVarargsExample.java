package dev.timer.jvm.annotation.general.safevarargs;

public class SafeVarargsExample {
    @SafeVarargs // 사용 추천 X
    public static <T> void printAll(T... messages) {
        for (T message : messages) {
            System.out.println(message);
        }
    }
}
