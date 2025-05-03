package dev.timer.jvm.annotation.custom;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class CarPrivateMethodTest {

    @Test
    public void needMaintenance() throws Exception {
        int yearMaintenance = LocalDate.now().getYear() - 6;
        Car carMaintenance = new Car("TestModel", yearMaintenance);

        Method method = Car.class.getDeclaredMethod("isNeedMaintenance");
        method.setAccessible(true);
        boolean resultMaintenance = (boolean) method.invoke(carMaintenance);

        assertThat(resultMaintenance).isTrue();
    }

    @Test
    public void notNeedMaintenance() throws Exception {
        int yearNotMaintenance = LocalDate.now().getYear() - 4;
        Car carNotMaintenance = new Car("TestModel", yearNotMaintenance);

        Method method = Car.class.getDeclaredMethod("isNeedMaintenance");
        method.setAccessible(true);
        boolean resultNotMaintenance = (boolean) method.invoke(carNotMaintenance);

        assertThat(resultNotMaintenance).isFalse();
    }

    @Test
    public void needChangeOil() {
        int yearChangeOil = LocalDate.now().getYear() - 1;
        Car carChangeOil = new Car("TestModel", yearChangeOil);

        boolean resultChangeOil = carChangeOil.isNeedChangOil();

        assertThat(resultChangeOil).isTrue();
    }

    @Test
    public void notNeedChangeOil() {
        int yearNotChangeOil = LocalDate.now().getYear();
        Car carNotChangeOil = new Car("TestModel", yearNotChangeOil);

        boolean resultNotChangeOil = carNotChangeOil.isNeedChangOil();

        assertThat(resultNotChangeOil).isFalse();
    }

}