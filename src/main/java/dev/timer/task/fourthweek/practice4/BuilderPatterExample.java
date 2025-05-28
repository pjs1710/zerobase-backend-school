package dev.timer.task.fourthweek.practice4;

public class BuilderPatterExample {

    public static void main(String[] args) {
        Member member = new Member.Builder()
                .name("Jae Seong")
                .age(25)
                .build();

        System.out.println(member);
    }
}
/**
 *  Builder Pattern 이론 설명 :
 *
 *  - 디자인 패턴에서 생성 패턴 중 하나이다.
 *  - 복잡한 객체를 생성하는 방법 중 하나로, 객체 생성 과정을 단계별로 나누어 유연하게 생성한다. 이 때문에 코드의 가독성과 유지 보수성을 향상시키는 패턴이다.
 *
 *  > 장점 :
 *  - 생성할 객체의 속성을 자유롭게 지정할 수 있다.
 *      - Builder 패턴은 유연성을 제공하며, 필수적인 속성만 생성자에서 처리하고 선택적인 속성은 Chaining을 통해 처리할 수 있다.
 *  - 생성할 객체의 속성이 많거나 복잡한 경우에도 코드의 가독성을 유지할 수 있다.
 *  - 재사용이 가능하다.
 *
 *  > 단점 :
 *  - Chaining을 통해 작성하기 때문에 코드량이 많아질 수 있다.
 *
 */
