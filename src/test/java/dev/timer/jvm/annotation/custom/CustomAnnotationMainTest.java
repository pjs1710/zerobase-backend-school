package dev.timer.jvm.annotation.custom;

import dev.timer.annotation.custom.Car;
import dev.timer.annotation.custom.CarFactory;
import dev.timer.annotation.custom.CarRequest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomAnnotationMainTest {

    // 2000 ~ 2025
    @Test
    public void testValidYearRange() {
        Car car = CarFactory.createCar(new CarRequest("BMW", 2021));
        assertThat(car.getYear()).isEqualTo(2021);

        System.out.println(car);
    }

    @Test
    public void testInvalidYearRange() {
        assertThatThrownBy(() -> CarFactory.createCar(new CarRequest("BMW", 2026)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}