package dev.timer.task.fourthweek.practice2;

import java.lang.reflect.Method;

public class Validator {

    public static void call(Object obj, String methodName, Object... args) {
        try {
            for (Method method : obj.getClass().getDeclaredMethods()) { // Main에서 매개변수로 받은 example의 Class 정보를 가져옴
                if (method.getName().equals(methodName) && method.getParameterCount() == args.length) { // method 이름이 같은지 & 파라미터 개수가 같은지
                    method.setAccessible(true);
                    method.invoke(obj, args);
                    return;
                }
            }
            System.out.println("존재하지 않는 메서드입니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
