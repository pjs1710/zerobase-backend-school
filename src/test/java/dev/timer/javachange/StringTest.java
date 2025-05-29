package dev.timer.javachange;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class StringTest {

    @Test
    void java8() { // 문자열 연결
        // String.join
        String str1 = String.join(",", "a", "b", "c");
        System.out.println(str1);

        // String.join with Collection
        String str2 = String.join(",", List.of("a", "b", "c"));
        System.out.println(str2);
    }

    @Test
    void java11() {
        // String.isBlank : 공백 문자열 확인
        System.out.println(" ".isBlank()); // true
        System.out.println("abc".isBlank()); // false
        System.out.println("".isBlank()); // true
        System.out.println("a b c".isBlank()); // false

        // String.strip, string.stripLeading, string.stripTrailing : 공백 제거
        System.out.println("   abc   ".strip()); // "abc"
        System.out.println("   abc   ".stripLeading()); // "abc   "
        System.out.println("   abc   ".stripTrailing()); // "   abc"

        // String.lines : 개행문자 단위로 분리
        String str = "abc\ndef\nghi";
        str.lines().forEach(System.out::println);

        // String.repeat : 문자열 반복
        System.out.println("abc".repeat(3)); // "abcabcabc"
    }

    @Test
    void java13() {
        // String TextBlock : 여러줄 문자열 지원, \s는 공백 유지
        String textBlock = """
                Hello, \s
                World!
                Wolrd!
                """;
        System.out.println(textBlock);
    }

    @Test
    void java14() {
        // String.transform // 람다 형식으로 로직 체이닝
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
        // String formatting .formatted, String.format의 간편한 형태
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
