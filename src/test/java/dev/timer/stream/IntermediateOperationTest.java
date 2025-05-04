package dev.timer.stream;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperationTest {
    private final Faker faker = new Faker();

    /*
     * 1 ~ 10 사이의 숫자에서 짝수만 필터링
     */
    @Test
    void filter() {
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        List<Integer> numbers = new ArrayList<>();
//        for (int i = 1; i <= 10; i++) {
//            numbers.add(i);
//        }
//
//        List<Integer> evenNumbers = numbers.stream() // List를 Stream으로 변환
//                .filter(number -> number % 2 == 0) // 짝수만 필터링
//                .toList(); // Stream을 다시 List로 변환

        List<Integer> evenNumbers = IntStream.range(1, 10)
                .filter(number -> number % 2 == 0) // 짝수만 필터링
                .boxed()
                .toList();

        System.out.println(evenNumbers);
    }

    /*
     * 10명의 이름 리스트에서 이름 -> 이름 길이로 변환
     */
    @Test
    void map() {
        List<String> names = Stream.generate(() -> faker.name().fullName())
                .limit(10)
                .toList();
        System.out.println(names);

        List<Integer> nameLengths = names.stream()
                .map(s -> s.length()) // 이름 -> 이름 길이로 변환
                .toList();
        System.out.println(nameLengths);
    }

    /**
     * 10명의 이름을 받아서 그 이름을 한글자씩 나눈 List를 만든다.
     * 그리고 map, flatMap의 차이를 보여준다.
     */
    @Test
    void mapVsFlatMap() {
        List<String> names = Stream.generate(() -> faker.name().fullName())
                .limit(10)
                .toList();
        System.out.println(names);

        // map
        List<List<String>> nameCharacters = names.stream()
                .map(s -> List.of(s.split("")))
                .toList();
        System.out.println(nameCharacters);

        // flatMap
        List<String> nameCharacters2 = names.stream()
                .flatMap(s -> Stream.of(s.split("")))
                .toList();
        System.out.println(nameCharacters2);
    }

    /**
     * 1 ~ 100의 숫자를 받고, 5로 나눈 나머지 list를 만든다.
     * 그 다음 중복을 제거한다.
     */
    @Test
    void distinct() {
        List<Integer> numbers = IntStream.rangeClosed(1, 100)
                .map(i -> i % 5)
                .boxed()
                .toList();
        System.out.println(numbers);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println(distinctNumbers);
    }

    /**
     * 1 ~ 100 사이의 랜덤한 숫자를 받아서 정렬
     */
    @Test
    void sorted() {
        List<Integer> numbers = Stream.generate(() -> faker.number().numberBetween(1, 100))
                .limit(10)
                .toList();
        System.out.println(numbers);

        List<Integer> sortedNumbers = numbers.stream()
                .sorted() // 오름차순 정렬
                .toList();
        System.out.println(sortedNumbers);
    }

    /**
     * 1 ~ 100 사이의 랜덤한 숫자 10개를 받아서 출력
     * 4개 skip 후 출력
     */
    @Test
    void skip() {
        List<Integer> numbers = Stream.generate(() -> faker.number().numberBetween(1, 100))
                .limit(10)
                .toList();
        System.out.println(numbers);

        List<Integer> skippedNumbers = numbers.stream()
                .skip(4) // 4개 skip
                .toList();
        System.out.println(skippedNumbers);
    }
}
