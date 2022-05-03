package array;

import java.util.stream.IntStream;

public class BuildingWithOceanView {

    public static void solution(int arry[]){
        boolean oceanView[] = new boolean[arry.length];
        oceanView[arry.length - 1] = true;
        int maxHeight = arry[arry.length - 1];
        for(int i = arry.length - 2 ; i >= 0 ; i--) {
            int currHeight = arry[i];
            if(currHeight > maxHeight){
                maxHeight = currHeight;
                oceanView[i] = true;
            }
        }
        IntStream.range(0,oceanView.length).filter(index -> oceanView[index]).forEach(System.out::print);
        System.out.println();



    }
    public static void main(String[] args) {
        solution(new int[]{4,2,3,1});
        solution(new int[]{4,3,2,1});
        solution(new int[]{1,3,2,4});
        solution(new int[]{2,2,2,2});
    }

}
