package array.frequencycounter;

import java.util.HashMap;
import java.util.Map;

/*
        given 2 positive integers, find out if the two numbers have the same frequency of digits.

        input: 182, 281
        o/p: true

        input: 3589578, 5879385
        o/p: true

        input: 34, 14
        o/p: false

        input: 22, 222
        o/p: false

        explanation: here each digit in number1 should have the exact same frequency as in number 2

 */
public class SameFrequencyCounter {


    public static void main(String[] args) {
        System.out.println(solution(182, 281));
        System.out.println(solution(3589578, 5879385));
        System.out.println(solution(34, 14));
        System.out.println(solution(22, 222));
    }

    private static boolean solution(int n1, int n2) {
        Map<Integer, Integer> frequencyCounter = new HashMap<>();

        while (n1 > 0) {
            int rem1 = n1 % 10;
            if (frequencyCounter.get(rem1) == null) frequencyCounter.put(rem1, 1);
            else frequencyCounter.put(rem1, frequencyCounter.get(rem1) + 1);

            n1 = n1 / 10;
        }

        while (n2 > 0) {
            int rem1 = n2 % 10;
            if (frequencyCounter.get(rem1) == null || frequencyCounter.get(rem1) <= 0) return false;
            else frequencyCounter.put(rem1, frequencyCounter.get(rem1) - 1);

            n2 = n2 / 10;
        }

        for (Integer key : frequencyCounter.keySet()) {
            if (frequencyCounter.get(key) != 0) return false;
        }
        return true;


    }
}
