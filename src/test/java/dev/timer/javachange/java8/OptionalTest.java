package dev.timer.javachange.java8;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OptionalTest {

    @Test
    void create() {
        // 생성
        Optional<String> optional = Optional.ofNullable("Hello"); // value가 null이면 빈 Optional 반환
        assertThat(optional.isPresent()).isTrue();
        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        Optional<String> optional2 = Optional.of("Hello2"); // value가 null이면 NPE 발생
        assertThat(optional2.isPresent()).isTrue();
        System.out.println(optional2.isPresent());
        System.out.println(optional2.get());

        Optional<String> optional3 = Optional.ofNullable(null);
        assertThat(optional3.isPresent()).isFalse();
        System.out.println(optional3.isPresent());
//        System.out.println(optional3.get());

        Optional<String> optional4 = Optional.empty(); // 명시적으로 비어있는 Optional
        assertThat(optional4.isPresent()).isFalse();
        System.out.println(optional4.isPresent());
    }

    @Test
    void orElse() {
        // orElse
        Optional<String> optional = Optional.ofNullable("Hello");
        assertThat(optional.orElse("Default Value")).isEqualTo("Hello");
        System.out.println(optional.orElse("Default Value")); // 값이 존재하면 반환, 없으면 default 반환

        Optional<String> optional2 = Optional.ofNullable(null);
        assertThat(optional2.orElse("Default Value")).isEqualTo("Default Value");
        System.out.println(optional2.orElse("Default Value"));
    }

    @Test
    void orElseThrow() {
        // orElseThrow
        Optional<String> optional = Optional.ofNullable("Hello");
        assertThat(optional.orElseThrow()).isEqualTo("Hello");
        System.out.println(optional.orElseThrow()); // 값이 있으면 반환, 없으면 예외 발생

        Optional<String> optional2 = Optional.empty();
        assertThatThrownBy(() -> optional2.orElseThrow(IllegalStateException::new))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void map() {
        // map
        Optional<String> optional = Optional.ofNullable("Hello");
        assertThat(optional.map(String::toUpperCase).orElse("Default Value")).isEqualTo("HELLO");
        System.out.println(optional.map(String::toUpperCase).orElse("Default Value"));

        Optional<String> optional2 = Optional.empty(); // Optional.map(func) 값이 있으면 func 적용, 없으면 그대로 빈 Optional
        assertThat(optional2.map(String::toUpperCase).orElse("Default Value")).isEqualTo("Default Value");
        System.out.println(optional2.map(String::toUpperCase).orElse("Default Value"));
    }

    @Test
    void ifPresent() {
        // ifPresent
        Optional<String> optional = Optional.ofNullable("Hello");
        optional.ifPresent(s -> System.out.println(s.toUpperCase())); // 값이 있으면 실행

        Optional<String> optional2 = Optional.empty();
        optional2.ifPresent(s -> System.out.println(s.toUpperCase()));
    }
}
