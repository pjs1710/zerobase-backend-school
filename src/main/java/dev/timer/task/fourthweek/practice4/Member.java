package dev.timer.task.fourthweek.practice4;

// 디자인 패턴 - Builder 패턴 실습
public class Member {

    private final String name;
    private final int age;

    // Builder 클래스
    public static class Builder { // Main 함수에서 builder를 사용할 때 입력받을 파라미터들을 Builder로 입력받고
        private String name;
        private int age;

        public Builder name(String name) { // .name(param)
            this.name = name;
            return this;
        }

        public Builder age(int age) { // .age(param)
            this.age = age;
            return this;
        }

        public Member build() { // .build(); 이런 식으로
            return new Member(this); // 생성자에 입력받은 값을 넣어서 객체 생성
        }
    }

    Member(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
