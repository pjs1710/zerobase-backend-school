package dev.timer.javachange.java11;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class VarTest {

    @Test
    void varTest() {
        var intVar = 1;
        var longVar = 1L;
        var booleanVar = true;
        var stringVar = "Hello, World!";

        assertThat(intVar).isInstanceOf(Integer.class);
        assertThat(longVar).isInstanceOf(Long.class);
        assertThat(booleanVar).isInstanceOf(Boolean.class);
        assertThat(stringVar).isInstanceOf(String.class);

        var listVar = new ArrayList<String>();
        var mapVar = new HashMap<String, String>();

        assertThat(listVar).isInstanceOf(ArrayList.class);
        assertThat(mapVar).isInstanceOf(HashMap.class);

        var mouse = new Mouse("Logitech", 100);
        assertThat(mouse).isInstanceOf(Mouse.class);
    }

    record Mouse(String name, int price) {

    }
}
