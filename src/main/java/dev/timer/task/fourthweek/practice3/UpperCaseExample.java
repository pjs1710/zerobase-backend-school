package dev.timer.task.fourthweek.practice3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Stream;

// BE 37기_박재성
// 4주차 실습 과제 3번 : 파일 Stream 처리

public class UpperCaseExample {

    public static void main(String[] args) {
        String text = "lowercase.txt";

        // Functional Interface와 Lambda를 사용해서 모두 대문자로 바꾸는 function
        Function<String, String> function = x -> x.toUpperCase();

        try (Stream<String> lines = Files.lines(Paths.get(text))) { // 파일을 한 라인 읽어와서
            lines.map(function) // 한 라인을 대문자로 바꾸고
                    .forEach(System.out::println); // 출력
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
