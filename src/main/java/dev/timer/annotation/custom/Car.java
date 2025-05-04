package dev.timer.annotation.custom;

import dev.timer.annotation.custom.annotation.ModelDescriptionPrint;
import dev.timer.annotation.custom.annotation.ModelDescriptionPrints;

import java.time.LocalDate;

public class Car {
    private final String model;
    // 1980 ~ 2025
    private final Integer year;

    public Car(String model, Integer year) {
        this.model = model;
        this.year = year;
    }

    // print model description
    // Ionic : new model
    // Sonata : steady seller
    // Grandeur : luxury model
    // Avante : compact model
    // Morning : small car
    @ModelDescriptionPrints({
            @ModelDescriptionPrint(model = "Ionic", description = "new model"),
            @ModelDescriptionPrint(model = "Sonata", description = "steady seller"),
            @ModelDescriptionPrint(model = "Grandeur", description = "luxury model"),
            @ModelDescriptionPrint(model = "Avante", description = "compact model"),
            @ModelDescriptionPrint(model = "Morning", description = "small car")
    })
    public String getModel() {
        try {
            // getModel 메서드에서 ModelDescriptionPrint 타입의 모든 어노테이션을 가져옴
            ModelDescriptionPrint[] annotations = this.getClass().getMethod("getModel").getAnnotationsByType(ModelDescriptionPrint.class);
            // 각 어노테이션을 순회
            for (ModelDescriptionPrint annotation : annotations) {
                // 어노테이션의 model 값이 현재 객체의 model 값과 일치하는지 확인
                if (annotation.model().equals(model)) {
                    // 일치하는 경우 해당 어노테이션의 description 값을 출력
                    System.out.println(annotation.description());
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        
        return model;
    }

    public Integer getYear() {
        return year;
    }

    private boolean isNeedMaintenance() {
        return LocalDate.of(year, 1, 1).isBefore(LocalDate.now().minusYears(5));
    }

    public boolean isNeedChangOil() {
        // oil 교체는 1개월마다 해야함
        return LocalDate.of(year, 1, 1).isBefore(LocalDate.now().minusYears(1));
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
