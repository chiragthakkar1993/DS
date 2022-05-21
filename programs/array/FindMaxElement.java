package array;

public class FindMaxElement {

    public static int solution(int [] arry){
        long starTime = System.nanoTime();

        int max = 0;
        int start = 0;
        int end = arry.length - 1;
        while(start<=end){
            if(arry[start] > arry[end] && arry[start] > max)
                max = arry[start];

            if(arry[end] > arry[start] && arry[end] > max)
                max = arry[end];;

            start++;
            end--;
        }
        long endTime = System.nanoTime();
        System.out.println("timeTaken = "+ (endTime - starTime));
        return max;
    }
    public static int solution2(int [] arry){
        long starTime = System.nanoTime();
        int max = 0;

     for(int i=0; i<arry.length;i++){
            if(arry[i] > max)
                max = arry[i];
        }
        long endTime = System.nanoTime();
        System.out.println("timeTaken = "+ (endTime - starTime));
        return max;
    }
    public static void main(String[] args) {
        int arry[] = {10,2,6,3,9,11,70,23,56,45,101};
        System.out.println(solution(arry));
        System.out.println(solution2(arry));
    }
}
