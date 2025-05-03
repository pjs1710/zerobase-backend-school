package dev.timer.jvm.oom.lotto2;

import java.util.ArrayList;
import java.util.List;


public class OOMLottoApplication2 {
    private static final List<List<Integer>> lottoHistory = new ArrayList<>();

    public static void main(String[] args) {
        LottoGenerator generator = new LottoGenerator();
        while (true) {
            List<Integer> numbers = generator.generate();
            System.out.println(numbers);

            if (lottoHistory.size() > 100) {
                lottoHistory.clear();
            }
            lottoHistory.add(numbers);
        }
    }
}
