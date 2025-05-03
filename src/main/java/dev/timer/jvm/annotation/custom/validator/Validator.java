package dev.timer.jvm.annotation.custom.validator;

import dev.timer.jvm.annotation.custom.CarRequest;
import dev.timer.jvm.annotation.custom.annotation.YearRange;

import java.lang.reflect.Field;

public class Validator {
    public static void validateYear(CarRequest request) {
        try {
            Field field = request.getClass().getDeclaredField("year"); // CarRequest의 Class정보를 가져와서 year라는 필드의 정보를 가져온다.
            field.setAccessible(true); // year 필드에 접근하기 위해서 접근 가능하도록 설정한다.
            YearRange yr = field.getAnnotation(YearRange.class); // year 필드에 붙어있는 @YearRange 어노테이션을 가져온다.

            int year = request.getYear();

            if (year < yr.min() || year > yr.max()) {
                throw new IllegalArgumentException("Invalid year range");
            }
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("No such field");
        }
    }
}
