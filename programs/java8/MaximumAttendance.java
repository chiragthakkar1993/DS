package java8;


import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaximumAttendance {
    public static long solution(String[] E) {
        Map<Integer, HashSet<Integer>> map = new HashMap();
        IntStream.range(0, 10)
                .forEach(i -> map.put(i, new HashSet()));
        IntStream.range(0, E.length).filter(index -> !E[index].isEmpty())
                .forEach(index ->
                        E[index].chars().forEach(
                                key -> map.get(Character.getNumericValue((char)key)).add(index)
                        )
                );
        System.out.println(map);
    AtomicLong max = new AtomicLong();
     IntStream.range(0,map.values().size()-1).forEach(
             index ->
                     max.set(Math.max(max.get(), Stream.of(map.get(index), map.get(index + 1)).flatMap(x -> x.stream()).distinct().count())));

        return max.get();
    }
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"039", "4", "14", "32", "", "34", "7"}));
    }
}
