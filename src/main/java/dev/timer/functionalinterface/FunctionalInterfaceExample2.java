package dev.timer.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;

public class FunctionalInterfaceExample2 {

    public static void main(String[] args) {

        // BiConsumer : 입력값을 두 개 받아 처리만 하고 반환값은 없음
        BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println("BiConsumer: " + (a + b));
        biConsumer.accept(10, 20);

        // BiFunction : 입력값을 두 개 받아 결과값을 반환함
        BiFunction<Integer, Integer, String> biFunction = (a, b) -> "BiFunction: sum is " + (a + b);
        System.out.println(biFunction.apply(10, 20));

        // BinaryOperator : 입력값을 두 개 받아 같은 타입의 결과값을 반환함
        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
        System.out.println("BinaryOperator: " + binaryOperator.apply(10, 20));

        // BiPredicate : 입력값을 두 개 받아 boolean 결과값을 반환함
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> (a + b) > 10;
        System.out.println("BiPredicate: " + biPredicate.test(5, 10));
    }
}
