package dev.timer.task.selective.practice2;

// BE 37기_박재성
// 4주차 선택 과제 2번 : Stream을 활용한 콘솔 입력 처리 프로그램

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  준수 사항 :
 *  1. 사용자가 콘솔에서 여러 개의 숫자를 입력한 후 Stream을 활용하여 다음 작업을 수행하는 프로그램 작성
 *
 *  기능 요구 사항 :
 *  1. 사용자가 숫자를 입력하면 공백 또는 쉼표(,)로 구분하여 여러개의 정수를 받을 수 있도록 함.
 *  2. Stream을 활용하여 데이터 처리
 *      - 모든 숫자의 합계와 평균을 계산
 *      - 짝수와 홀수를 분류하여 출력
 *      - 가장 큰 값과 작은 값 찾기
 *      - 중복을 제거하고 정렬하여 출력
 *  3. 결과를 출력
 *
 *  출력 순서 :
 *  1. 입력된 숫자
 *  2. 합계
 *  3. 평균
 *  4. 짝수
 *  5. 홀수
 *  6. 최댓값
 *  7. 최솟값
 *  8. 중복 제거 후 정렬된 값
 */

public class Practice2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요 (공백 또는 쉼표로 구분) :");

        String input = scanner.nextLine();
        input = input.replace(",", " "); // input 값의 쉼표를 전부 공백으로 바꾸기
        String[] results = input.split(" "); // 공백을 기준으로 나눈 값들은 숫자만 남음

        ArrayList<Integer> nums = new ArrayList<>(); // 입력 받은 숫자를 담을 배열 생성
        int sum = 0; // 합계
        double avg = 0L; // 평균
        for (String item : results) { // 타입 변환해서 배열에 넣기, 추후에 다른 값들을 계산하기 위해서!
            if (!item.isEmpty() && !item.contains(",")) { // 위에서 replace, split으로 처리하지 못한 값들을 한번 더 필터링 해줘야함. ex) ",,", "  " 쉼표 2개, 공백 2개
                int num = Integer.parseInt(item);
                nums.add(num);
                sum += num;
            }
        }
        avg = (double) sum / nums.size();

        List<Integer> evenNums = nums.stream()
                .filter(x -> x % 2 == 0) // nums 배열에 짝수만 필터링해서 evenNums에 담기
                .toList();

        List<Integer> oddNums = nums.stream()
                .filter(x -> x % 2 != 0) // nums 배열에 홀수만 필터링해서 oddNums에 담기
                .toList();

        // 최댓값 최솟값을 구하기 전에 미리 오름차순으로 정렬하고 0번째 인덱스와 n - 1번째 인덱스를 가져오자
        // distinct()로 중복 제거부터
        List<Integer> distinctNums = nums.stream()
                .distinct()
                .toList();

        // 오름차순 정렬
        distinctNums = distinctNums.stream()
                .sorted()
                .toList();

        // 첫 번째 인덱스는 최솟값, 마지막 인덱스는 최댓값임
        Integer minNum = distinctNums.get(0);
        Integer maxNum = distinctNums.get(distinctNums.size() - 1);

        // 출력 부분
        System.out.println("입력된 숫자 : " + nums);
        System.out.println("합계 : " + sum);
        System.out.println("평균 : " + avg);
        System.out.println("짝수 : " + evenNums);
        System.out.println("홀수 : " + oddNums);
        System.out.println("최댓값 : " + maxNum);
        System.out.println("최솟값 : " + minNum);
        System.out.println("중복 제거 후 정렬된 숫자 : " + distinctNums);

    }
}
