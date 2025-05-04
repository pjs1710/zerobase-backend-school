package dev.timer.annotation.custom;

public class CustomAnnotationMain {

    public static void main(String[] args) {
//        CarRequest carRequest = new CarRequest("BMW", 2021);
        Car car = CarFactory.createCar(new CarRequest("BMW", 2021));
        System.out.println(car);
    }
}
