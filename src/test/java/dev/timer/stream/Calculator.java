//package dev.timer.stream;
//
//import java.util.Arrays;
//import java.util.function.DoubleBinaryOperator;
//
///**
// * '11' + '11'을 계산하는 클래스.
// */
//public enum Calculator {
//    ADD("+", (a, b) -> a + b),
//    SUBTRACT("-", (a, b) -> a - b),
//    MULTIPLY("*", (a, b) -> a * b),
//    DIVIDE("/", (a, b) -> a / b);
//
//    private final String symbol;
//    private final DoubleBinaryOperator operator;
//
//    Calculator(String symbol, DoubleBinaryOperator operator) {
//        this.symbol = symbol;
//        this.operator = operator;
//    }
//
//    /**
//     * '11' + '11'을 계산하는 클래스
//     * stream을 이용해서 계산
//     */
//    public static double calculate(String query) {
//        String operator = query.replaceAll("[0-9]", "");
//        String[] numbers = query.split("[+\\-*/]");
//
//        double number1 = Double.parseDouble(numbers[0]);
//        double number2 = Double.parseDouble(numbers[1]);
//
//        Calculator calc = Arrays.stream(values())
//                .filter(calculator -> calculator.getSymbol().equals(operator))
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Invalid operator: " + operator));
//
//        return calc.getOperator().applyAsDouble(number1, number2);
//    }
//}
