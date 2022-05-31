package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SmallestInterval {
    public static int findSmallestInterval(int[] numbers) {
        Arrays.sort(numbers);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length - 1; i++) {
            int diff = numbers[i + 1] - numbers[i];
            if (diff < min)
                min = diff;
        }
        return min;
    }

    public static void main(String[] args) {
        int arry1[] = {1,6,4,8,2};
        System.out.println(findSmallestInterval(arry1));
    }
}
