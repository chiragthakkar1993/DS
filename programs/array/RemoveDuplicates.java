package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static int[] solution(int[] arry){
        Set<Integer> set= new LinkedHashSet<>();

        for (int val:
             arry) {
            set.add(val);
        }
        return set.stream().mapToInt(Integer::intValue).toArray();


    }
    public static void main(String[] args) {



        int[] arry1 = {1,6,4,8,2,10,2,8};
        solution(arry1);
        int[] arry = solution(arry1);
        for (int val:
            arry) {
            System.out.println(val);
        }
    }
}
