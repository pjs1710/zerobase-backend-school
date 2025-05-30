package dev.timer.jvm.annotation.custom;

import dev.timer.annotation.custom.Car;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void testGetModelIonic() {
        Car car = new Car("Ionic", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelSonata() {
        Car car = new Car("Sonata", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelGrandeur() {
        Car car = new Car("Grandeur", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelAvante() {
        Car car = new Car("Avante", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelMorning() {
        Car car = new Car("Morning", 2021);
        car.getModel();
    }

    @Test
    public void testGetModelUnknown() {
        Car car = new Car("Unknown", 2021);
        car.getModel();
    }

}