package dev.timer.lambda;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void testAdd() {
        // given
        Calculator calculator = new Calculator(10, 50);

        // when
        int result = calculator.calculate(
                new Operate() {
                    @Override
                    public int operate(int a, int b) {
                        return a + b;
                    }
                }
        );

        // then
        System.out.println(result);
    }

    @Test
    void testAddLambda() {
        // given
        Calculator calculator = new Calculator(20, 50);

        // when
        int result = calculator.calculate((a, b) -> a + b);

        // then
        System.out.println(result);
    }

    @Test
    void testAddLambda2() {
        // given
        Calculator calculator = new Calculator(30, 50);
        Operate operate = (int a, int b) -> a + b;

        // when
        int result = calculator.calculate(operate);

        // then
        System.out.println(result);
    }

    @Test
    void testAddLambda3() {
        // given
        Calculator calculator = new Calculator(40, 50);

        // when
        int result = calculator.calculate(Integer::sum);

        // then
        System.out.println(result);
    }

    @Test
    void testAddLambda4() {
        // given
        Calculator calculator = new Calculator(50, 50);

        // when
        int result = calculator.calculate(getOperate());

        // then
        System.out.println(result);
    }

    private Operate getOperate() {
        return Integer::sum;
    }

    @Test
    void testSubtract() {
        // given
        Calculator calculator = new Calculator(10, 50);

        // when
        int result = calculator.calculate((a, b) -> a - b);

        // then
        System.out.println(result);
    }
}