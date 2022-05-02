package array;

public class MaximumBrushstrokeSkyline {
    public static int solution(int[] A){

        int prevHeight = 0;
        int brushCount = 0;
        for(int i = 0;i < A.length; i++){
            if(A[i] > prevHeight)
                brushCount = brushCount + ( A[i] - prevHeight );

            prevHeight = A[i];
        }
        return brushCount;

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,4,1,6,3,5,1}));
    }
}
