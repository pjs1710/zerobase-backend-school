package dev.timer.task.selective.practice1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface JsonField { // Custom Annotation
    String value() default "";  // value가 없으면 공백 문자열
    boolean skipYn() default false; // true이면 해당 필드는 출력 X
}
