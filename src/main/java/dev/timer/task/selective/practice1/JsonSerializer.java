package dev.timer.task.selective.practice1;

import java.lang.reflect.Field;

public class JsonSerializer {

    // Custom Annotation에 적용된 값들을 최종적으로 JSON 문자열로 출력하는 로직을 구현해야 함.
    public static String printJsonSerializer(Person person) { // 최종적으로 Main에서는 Person 객체를 넘겨줌
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        boolean isFirst = true; // 첫 field인지 확인하기 위한 변수, 아래 주석에서 추후에 설명할게요.

        try {
            Field[] fields = person.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(JsonField.class)) { // field에 해당 어노테이션이 없으면 다음 데이터로
                    continue;
                }
                field.setAccessible(true);
                JsonField jsonField = field.getAnnotation(JsonField.class);

                // 출력하기 전에 skipYn에 관한 내용이 있는지 확인하기
                if (jsonField.skipYn()) { // true이면 출력 X
                    continue;
                }

                // 여기까지 왔으면 field에 해당 어노테이션이 있고, 어노테이션에서 skipYn = false인 상태 (default도 false임)
                // 어노테이션 적용된 field들을 JSON 형식으로 출력하는 로직 구현해야 함.
                // key : value, 형식으로 출력하기
                String key = jsonField.value(); // full_name, age, gender가 key
                Object value = field.get(person); // "John Doe", 30, "F"가 value

                if (!isFirst) { // 첫 번째 field가 아니면
                    builder.append(", "); // 첫 번째 field가 끝나고 바로 앞에 ", "를 붙임
                }
                isFirst = false; // 이제 할 일 끝난 변수

                builder.append(key)
                        .append(": ");
                // value 타입이 문자열이면 "" 붙여줘야 함
                if (value instanceof String) {
                    builder.append("\"")
                            .append(value)
                            .append("\"");
                } else {
                    builder.append(value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        builder.append("}");
        return builder.toString();
    }
}
