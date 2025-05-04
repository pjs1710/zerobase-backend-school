package dev.timer.javachange;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class StringTest {

    @Test
    void java8() {
        // String.join
        String str1 = String.join(",", "a", "b", "c");
        System.out.println(str1);

        // String.join with Collection
        String str2 = String.join(",", List.of("a", "b", "c"));
        System.out.println(str2);
    }

    @Test
    void java11() {
        // String.isBlank
        System.out.println(" ".isBlank()); // true
        System.out.println("abc".isBlank()); // false
        System.out.println("".isBlank()); // true
        System.out.println("a b c".isBlank()); // false

        // String.strip, string.stripLeading, string.stripTrailing
        System.out.println("   abc   ".strip()); // "abc"
        System.out.println("   abc   ".stripLeading()); // "abc   "
        System.out.println("   abc   ".stripTrailing()); // "   abc"

        // String.lines
        String str = "abc\ndef\nghi";
        str.lines().forEach(System.out::println);

        // String.repeat
        System.out.println("abc".repeat(3)); // "abcabcabc"
    }

    @Test
    void java13() {
        // String TextBlock
        String textBlock = """
                Hello, \s
                World!
                Wolrd!
                """;
        System.out.println(textBlock);
    }

    @Test
    void java14() {
        // String.transform
        String str = "hello";
        String result = str.transform(s -> s.toUpperCase());
        System.out.println(result); // "HELLO"

        // String.transform chaining
        String result2 = str
                .transform(s -> s.toUpperCase())
                .transform(s -> s + " world");
        System.out.println(result2); // "HELLO world"
    }

    @Test
    void java16() {
        // String formatting .formatted
        String formattedString = "My name is %s and I am %d years old".formatted("John", 30);
        System.out.println(formattedString);

        //
        Map<String, Integer> map = Map.of(
                "apple", 1,
                "banana", 2,
                "cherry", 3
        );
        map.forEach((k, v) -> System.out.println("I'm %s : %d age".formatted(k, v)));
    }
}
