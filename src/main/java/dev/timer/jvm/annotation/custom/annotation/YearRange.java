package dev.timer.jvm.annotation.custom.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
    Custom Annotation을 사용하게 되면 @Retention과 @Target은 무조건 사용하게 된다.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface YearRange {
    int min();

    int max();
}
