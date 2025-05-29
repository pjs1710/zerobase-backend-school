package dev.timer.javachange.java11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class VarTest {

    @Test
    void varTest() { // 타입 추론 var, 컴파일 시점에 타입이 결정이 된다. var은 메서드 내부에서만 사용 가능
        var intVar = 1;
        var longVar = 1L;
        var booleanVar = true;
        var stringVar = "Hello, World!";

        assertThat(intVar).isInstanceOf(Integer.class);
        assertThat(longVar).isInstanceOf(Long.class);
        assertThat(booleanVar).isInstanceOf(Boolean.class);
        assertThat(stringVar).isInstanceOf(String.class);

        var listVar = new ArrayList<String>(); // List나 Map도 가능하다
        var mapVar = new HashMap<String, String>();

        assertThat(listVar).isInstanceOf(ArrayList.class);
        assertThat(mapVar).isInstanceOf(HashMap.class);

        var mouse = new Mouse("Logitech", 100); // 객체도 가능하다
        assertThat(mouse).isInstanceOf(Mouse.class);
    }

    record Mouse(String name, int price) {

    }
}
