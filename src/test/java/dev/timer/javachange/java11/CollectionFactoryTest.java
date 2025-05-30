package dev.timer.javachange.java11;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionFactoryTest {

    @Test
    void listFactory() {
        // old - 불변
        List<String> oldList = Collections.unmodifiableList(Arrays.asList("apple", "banana", "cherry"));

        // new - 불변
        List<String> newList = List.of("apple", "banana", "cherry"); // List.of로 불변 객체 생성

        assertThat(oldList.equals(newList));
    }

    @Test
    void mapFactory() {
        // old - 불변
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("key1", "value1");
        dataMap.put("key2", "value2");
        Map<String, String> oldMap = Collections.unmodifiableMap(dataMap);

        // new - 불변
        Map<String, String> newMap = Map.of( // Map.of로 불변 객체 생성
                "key1", "value1",
                "key2", "value2"
        );

        assertThat(oldMap.equals(newMap));
    }
}
