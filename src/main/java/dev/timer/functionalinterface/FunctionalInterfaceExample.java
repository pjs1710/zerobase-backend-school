package dev.timer.functionalinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        // Consumer: 입력값을 받아 처리할 때 사용하고 반환값은 없음
        Consumer<String> consumer = s -> System.out.println("Consumer: " + s);
        consumer.accept("Test");

        // Supplier: 값을 생성할 때 사용
        Supplier<String> supplier = () -> "Hello";
        System.out.println("Supplier: " + supplier.get());

        // Predicate: 입력값에 대해 true/false 반환
        Predicate<Integer> predicate = i -> i > 10;
        System.out.println("Predicate: " + predicate.test(15));

        // Function: 입력값을 받아 변환해서 리턴
        Function<Integer, String> function = i -> "숫자는 " + i;
        System.out.println("Function: " + function.apply(5));
    }
}
