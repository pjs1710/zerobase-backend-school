package dev.timer.jvm.oom.lotto;

import java.util.ArrayList;
import java.util.List;


public class OOMLottoApplication {
    private static final List<List<Integer>> lottoHistory = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        LottoGenerator generator = new LottoGenerator();
        while (true) {
            List<Integer> numbers = generator.generate();
            System.out.println(numbers);
            lottoHistory.add(numbers);
        }
    }
}
