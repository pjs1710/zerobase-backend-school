package dev.timer.task.selective.practice1;

// BE 37기_박재성
// 4주차 선택 과제 1번 : Reflection을 활용한 JSON Serializer 구현 프로그램

/**
 *  주제 : Reflection을 활용하여 주어진 클래스를 JSON 문자열로 생성
 *
 *  Description :
 *  - 자바의 활성 특징 중 Reflection을 활용
 *  - 인터넷 및 웹에서 표준화된 JSON 문자열을 작성해 실습
 *  - Annotation 활용법을 학습
 *
 *  준수 사항 :
 *  1. Person 클래스 활용
 *  2. Person 클래스의 내용을 JSON 문자열로 출력
 *  3. Gson등 Json 라이브러리 활용하지 않고 진행
 *  4. Reflection, Annotation을 활용해서 진행
 *  5. Person의 속성이 문자열인 경우 따옴표로 표시
 *
 */

public class PersonMain {

    public static void main(String[] args) {
        Person person = new Person("John Doe", 30, "F");
        String result = JsonSerializer.printJsonSerializer(person);
        System.out.println(result);
    }
}
