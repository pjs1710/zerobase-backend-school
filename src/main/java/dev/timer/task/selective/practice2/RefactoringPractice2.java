package dev.timer.task.selective.practice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RefactoringPractice2 {

    public static void main(String[] args) {
        List<Integer> nums = getInputNums();

        int sum = getSum(nums);
        double avg = getAvg(nums);
        List<Integer> evenNums = getEvenNums(nums);
        List<Integer> oddNums = getOddNums(nums);
        List<Integer> distinctSortedNums = getDistinctSortedNums(nums);
        Integer min = distinctSortedNums.get(0);
        Integer max = distinctSortedNums.get(distinctSortedNums.size() - 1);

        System.out.println("입력된 숫자 : " + nums);
        System.out.println("합계 : " + sum);
        System.out.println("평균 : " + avg);
        System.out.println("짝수 : " + evenNums);
        System.out.println("홀수 : " + oddNums);
        System.out.println("최댓값 : " + max);
        System.out.println("최솟값 : " + min);
        System.out.println("중복 제거 후 정렬된 숫자 : " + distinctSortedNums);
    }

    // 숫자 입력 받은 후 배열 만드는 메서드
    private static List<Integer> getInputNums() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자를 입력하세요 (공백 또는 쉼표로 구분) :");
        String input = scanner.nextLine();
        input = input.replace(",", " ");
        String[] results = input.split(" ");

        ArrayList<Integer> nums = new ArrayList<>();
        for (String item : results) {
            if (!item.isEmpty() && !item.contains(",")) {
                int num = Integer.parseInt(item);
                nums.add(num);
            }
        }
        return nums;
    }

    private static int getSum(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).sum();
    }

    private static double getAvg(List<Integer> nums) {
        return (double) getSum(nums) / nums.size();
    }

    private static List<Integer> getEvenNums(List<Integer> nums) {
        return nums.stream().filter(x -> x % 2 == 0).toList();
    }

    private static List<Integer> getOddNums(List<Integer> nums) {
        return nums.stream().filter(x -> x % 2 != 0).toList();
    }

    private static List<Integer> getDistinctSortedNums(List<Integer> nums) {
        return nums.stream().distinct().sorted().toList();
    }
}
